package szpt.gpa.view;

import szpt.gpa.domain.Student;
import szpt.gpa.domain.Course;
import szpt.gpa.domain.RequiredCourse;
import szpt.gpa.domain.ElectiveCourse;
import szpt.gpa.service.Test;
import szpt.gpa.service.StudentListService;

import java.util.ArrayList;

public class SysMenuView{
    private ArrayList<Student> students = new ArrayList<>();
    private StudentListService studentService;
    public SysMenuView() {
        studentService = new StudentListService();
    }
    public void mainMenu() {
        studentService.printStuGPA();
        while (true) {
            System.out.print("操作: 1-查看平均GPA 2-查看学生课程GPA 3-添加学生 4-删除学生 5-退出\n请选择(1~5):");
            int menu = IOUlity.readMainMenu();
            switch (menu) {
                case 1:
                    studentService.printStuGPA();
                    break;
                case 2:
                    this.listStudentCourses();
                    break;
                case 3:
                    this.addStudent();
                    break;
                case 4:
                    this.deleteStudent();
                    break;
                case 5:
                    System.exit(0);
                    System.out.println(menu);
            }
        }
    }

    public void listStudentCourses() {
        System.out.print("输入要查看的学生序号：");
        int index = -1;
        while (true) {
            index = IOUlity.readIndex();
            if (index >= 1 && index <=studentService.getStudentsSize()) {
                studentService.printCouGPA(index);
                break;
            } else
                System.out.print("序号超出范围,重新输入：");
        }
        this.courseMenu(index);
    }

    public void addStudent(){
        System.out.println("学生学号：");
        String stuNo = IOUlity.readStudentData();
        System.out.println("学生姓名：");
        String name = IOUlity.readStudentData();
        System.out.println("学生班级：");
        String stuClass =IOUlity.readStudentData();
        System.out.println("学生专业：");
        String major = IOUlity.readStudentData();
        studentService.addStudent(stuNo, name,stuClass, major);
        studentService.printStuGPA();
    }

    public void deleteStudent(){
        System.out.println("输入要删除的学生的序号：");
        int index = -1;
        while (true) {
            index = IOUlity.readIndex();
            if (index >= 1 && index <=studentService.getStudentsSize()) {
                studentService.deleteStudent(index);
                studentService.printStuGPA();
                break;
            } else
                System.out.print("序号超出范围,重新输入：");
        }
    }

    public void courseMenu(int index){
        while (true) {
            System.out.println("操作：1-录入课程成绩 2-修改成绩 3-返回学生GPA成绩列表\n请选择(1~3):");
            int menu = IOUlity.readCourseMenu();
            switch (menu) {
                case 1:
                    this.inputScore(index);
                    break;
                case 2:
                    this.updateScore(index);
                    break;
                case 3:
                    studentService.printStuGPA();
                    return;
            }
        }
    }

    public void inputScore(int index) {
        System.out.print("输入课程序号：");
        int courseIndex = 0;
        while(true) {
            courseIndex = IOUlity.readIndex();
            if(courseIndex>=1 && courseIndex<=Test.courses.length)
                break;
            else
                System.out.println("课程序号不对，请重新输入：");
        }
        Student student = studentService.getStudents().get(index - 1);
        Course course =student.getCourses().get(courseIndex - 1);
        if (course instanceof RequiredCourse) {
            System.out.print("输入课程成绩：");
            double score = IOUlity.readScore();
            ((RequiredCourse)course).setScore(score);
            studentService.printCouGPA(index);
        }
        else {
            System.out.println("输入课程等级(优秀、良好、中等、及格、不及格)：");
            String level = IOUlity.readlevel();
            ((ElectiveCourse)course).setGrade(level);
            studentService.printCouGPA(index);
        }
    }

    public void updateScore(int index) {
        System.out.print("输入修改成绩的课程序号：");
        int updateCourseIndex = 0;
        while(true) {
            updateCourseIndex = IOUlity.readIndex();
            if(updateCourseIndex>=1 && updateCourseIndex<=Test.courses.length)
                break;
            else
                System.out.println("课程序号不对，请重新输入：");
        }
        Student updateStudent = studentService.getStudents().get(index - 1);
        Course updateCourse = updateStudent.getCourses().get(updateCourseIndex- 1);
        if (updateCourse instanceof RequiredCourse) {
            System.out.print("输入课程成绩：");
            double updateScore = IOUlity.readScore();
            ((RequiredCourse)updateCourse).setScore(updateScore);
            studentService.printCouGPA(index);
        }
          else {
            System.out.println("输入课程等级(优秀、良好、中等、 及格、 不及格):");
            String level = IOUlity.readlevel();
            ((ElectiveCourse)updateCourse).setGrade(level);
            studentService.printCouGPA(index);
        }
    }

    public static void main(String[] args) {
        SysMenuView view = new SysMenuView();
        view.mainMenu();
    }
}

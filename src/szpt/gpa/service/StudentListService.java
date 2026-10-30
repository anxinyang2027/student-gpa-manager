package szpt.gpa.service;

import szpt.gpa.domain.Student;
import szpt.gpa.domain.Course;
import szpt.gpa.domain.ElectiveCourse;
import szpt.gpa.domain.RequiredCourse;

import java.util.ArrayList;

public class StudentListService {
    private ArrayList<Student> students;
    public StudentListService(){
        students = new ArrayList<Student>();
        initStudentData();
    }

    public void initStudentData(){
        for(int i = 0; i<Test.students.length; i++) {
            //创建学生课程列表
            ArrayList<Course> courses = this.createCoursesList();
            //创建学生对象
            String stuNo = Test.students[i][0];
            String name = Test.students[i][1];
            String className = Test.students[i][2];
            String major = Test.students[i][3];
            Student student = new Student(stuNo, name, className, major, courses);
            //添加到students
            students.add(student);
        }
    }

    private ArrayList<Course> createCoursesList(){
        ArrayList<Course> courses = new ArrayList();
        for(int j = 0; j<Test.courses.length; j++){
            Course course = null;
            String id=Test.courses[j][0];
            String courseName=Test.courses[j][1];
            double credit=Double.parseDouble(Test.courses[j][3]);
            if(Test.courses[j][2].equals("必修")) {
                course = new RequiredCourse(id,courseName,credit);
            }else {
                course = new ElectiveCourse(id,courseName,credit);
            }
            courses.add(course);
        }
        return courses;
    }

    public void printStuGPA() {
        System.out.println("-------------------------- 学生GPA成绩列表 --------------------------");
        System.out.println("序号\t学号\t\t姓名\t班级\t专业\t\t平均GPA");
        int i = 0;
        for(Student student:students) {
            i++;
            System.out.print(i+"\t");
            System.out.print(student.getStuNo() + "\t");
            System.out.print(student.getStuName() + "\t");
            System.out.print(student.getClassName() + "\t");
            System.out.print(student.getMajor() + "\t");
            System.out.println(String.format("%.2f",student.getGPA()));
        }
        System.out.println("-------------------------------------------------------------------");
    }

    public void printCouGPA(int index) {
        Student student = students.get(index - 1);
        System.out.println("************************" + index + "号学生" + student.getStuName() + "课程表 ************************");
        System.out.println("序号\t课程编号\t课程名\t学分\t\t修读状态\t课程成绩\t课程绩点");
        int i = 0;
        for (Course course : student.getCourses()) {
            i++;
            System.out.print(i + "\t");
            System.out.print(course.getCourseId() + "\t\t");
            System.out.print(course.getCourseName() + "\t");
            System.out.print(course.getCredit() + "\t\t");
            if (course.getIsTaken()) {
                System.out.print("已修\t");
                System.out.print(course.getCourseGrade() + "\t");
            } else {
                System.out.print("未修\t\t");
                System.out.print("null\t");
            }
            System.out.println(String.format("%.2f", course.getGradePoint()));
        }
        System.out.println("****************************************************************");
    }

    //添加学生
    public void addStudent(String stuNo,String name,String className,String major){
        ArrayList<Course>courses=this.createCoursesList();
        //创建学生对象
        Student student =new Student(stuNo,name,className,major,courses);
        //添加到students中
        students.add(student);
    }

    //删除学生
    public void deleteStudent(int index){
        students.remove(index-1);
    }

    public int getStudentsSize() {
        return students.size();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}

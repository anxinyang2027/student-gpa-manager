package szpt.gpa.domain;

import java.sql.DataTruncation;
import java.util.ArrayList;

public class Student {
    private String stuNo;
    private String stuName;
    private String className;
    private String major;
    private double GPA;
    private ArrayList<Course> courses;

    public Student(String stuNo, String stuName, String className,
                   String major, ArrayList<Course> courses){
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.className = className;
        this.major = major;
        this.courses = courses;
    }

    private void averageGPA(){
        if (courses != null) {
            double totalPoints = 0;
            double totalCredit = 0;
            for (Course course:courses){
                if (course.isTaken){
                    totalPoints += course.getCredit()*course.getGradePoint();
                    totalCredit += course.getCredit();
                }
            }
            if (totalPoints == 0)
                GPA = 0;
            else GPA = totalPoints/totalCredit;
        }
        else
            GPA = 0;
    }


    public String getStuNo(){
        return this.stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public String getClassName() {
        return className;
    }

    public String getMajor() {
        return major;
    }

    public double getGPA() {
        this.averageGPA();
        return GPA;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}

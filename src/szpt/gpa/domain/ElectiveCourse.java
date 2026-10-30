package szpt.gpa.domain;

public class ElectiveCourse extends Course{
    protected String grade ;

    public ElectiveCourse(String id, String courseName, double credit){
        super(id, courseName, credit);
    }

    public void calculatePoint(){
        if (grade == null) {
            this.gradePoint = 0;
            return;
        }
        switch (grade){
            case "优秀" -> this.gradePoint=4.0;
            case "良好" -> this.gradePoint=3.6;
            case "中等" -> this.gradePoint=2.8;
            case "及格" -> this.gradePoint=1.7;
            case "不及格" -> this.gradePoint=0;
            default -> System.out.println("错误的等级");
        }
    }

    public void setGrade(String grade) {
        this.grade = grade;
        this.isTaken = true;
        this.calculatePoint();
    }

    public String getGrade() {
        return grade;
    }

    @Override
    public String getCourseGrade() {
        return this.grade;
    }
}

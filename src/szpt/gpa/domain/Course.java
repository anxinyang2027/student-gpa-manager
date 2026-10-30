package szpt.gpa.domain;

public abstract class Course {
    protected String courseId;
    protected String courseName;
    protected double credit;
    protected double gradePoint;
    protected boolean isTaken;

    public Course(String courseId, String courseName, double credit){
        this.courseId = courseId;
        this.courseName = courseName;
        this.credit = credit;
        this.gradePoint = 0;
        this.isTaken = false;
    }

    public abstract void calculatePoint();

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getCredit() {
        return credit;
    }

    public double getGradePoint() {
        this.calculatePoint();
        return gradePoint;
    }

    public boolean getIsTaken() {
        return isTaken;
    }

    public void setIsTaken(boolean taken) {
        isTaken = taken;
    }

    public abstract String getCourseGrade();
}

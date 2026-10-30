package szpt.gpa.domain;

public class RequiredCourse extends Course{
    private double score;

    public RequiredCourse(String id, String courseName, double credit){
        super(id, courseName, credit);
        this.score = 0;
        this.gradePoint = 0;
    }

    public void calculatePoint(){
        if (score == 100)
            this.gradePoint = 4.0;
        else if (score>60 && score<100)
            this.gradePoint = 4-3*(100-score)*(100-score)/1600;
        else if (score == 60)
            this.gradePoint = 1.0;
        else
            this.gradePoint = 0;
    }

    public void setScore(double score) {
        this.score = score;
        this.isTaken = true;
        calculatePoint();
    }

    public double getScore() {
        return score;
    }

    @Override
    public String getCourseGrade() {
        return this.score+"";
    }
}

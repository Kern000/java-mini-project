public class SGStudent extends Student { 

    private String highestEducation;
    private String courseEnrolled;
    private Double courseFeesPaid;

    public SGStudent(){
        super();
        highestEducation="";
        courseEnrolled="";
        courseFeesPaid=0.0;
    }

    public String getHighestEducation(){
        return highestEducation;
    }

    public void setHighestEducation(String highestEducation) throws IllegalArgumentException {
        if (highestEducation != null && !highestEducation.isEmpty()){
            this.highestEducation = highestEducation;
        } else {
            throw new IllegalArgumentException("Invalid highest education, set non-empty string");
        }
    }

    public String getCourseEnrolled(){
        return courseEnrolled;
    }

    public void setCourseEnrolled(String courseEnrolled) throws IllegalArgumentException {
        if (courseEnrolled != null && !courseEnrolled.isEmpty()){
            this.courseEnrolled = courseEnrolled;
        } else {
            throw new IllegalArgumentException("Please enter a valid non-empty string");
        }
    }

    public double getCourseFeesPaid(){
        return courseFeesPaid;  
    }

    public void setCourseFeesPaid(double courseFeesPaid){
        this.courseFeesPaid = courseFeesPaid;        
    }




}
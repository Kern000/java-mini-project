public class NonSGStudent extends Student { 

    private String highestEducation;
    private String courseEnrolled;
    private Double courseFeesPaid;
    private Boolean approvalForStay;

    public NonSGStudent(){
        super();
        highestEducation="";
        courseEnrolled="";
        courseFeesPaid=0.0;
        approvalForStay=false;
    }

    //constructor overload
    public NonSGStudent(String highestEducation, String courseEnrolled, Double courseFeesPaid, Boolean approvalFor){
        super();

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

    public void setCourseFeesPaid(double courseFeesPaid) throws IllegalArgumentException{
        if (courseFeesPaid < 0){
            this.courseFeesPaid = courseFeesPaid;        
        } else {
            throw new IllegalArgumentException("Course fees need to be 0 or more");
        }
    }

    public Boolean getApprovalForStay(){
        return approvalForStay;
    }

    public void setApprovalForStay(Boolean approvalForStay) throws IllegalArgumentException{
        if (approvalForStay instanceof Boolean){
            this.approvalForStay = approvalForStay;
        } else {
            throw new IllegalArgumentException("Needs to be a boolean true or false");
        }
    }

    
}
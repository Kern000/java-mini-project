import java.util.Scanner;

public class NonSGStudent extends Student { 

    private String highestEducation;
    private String courseEnrolled;
    private Double courseFeesPaid;
    private Boolean approvalForStay;

    private Double foreignRebateRate=0.03;

    public NonSGStudent(){
        super();
        highestEducation="";
        courseEnrolled="";
        courseFeesPaid=0.0;
        approvalForStay=false;
    }

    public NonSGStudent(    int studentId,
                            String name,
                            String nationality,
                            int age,
                            int idOrForeignPass,
                            String address,
                            String highestEducation,
                            String courseEnrolled,
                            Double courseFeesPaid,
                            Boolean approvalForStay)
    {
        super(studentId, name, nationality, age, idOrForeignPass, address);
        setHighestEducation(highestEducation);
        setCourseEnrolled(courseEnrolled);
        setCourseFeesPaid(courseFeesPaid);
        setApprovalForStay(approvalForStay);
    }

    //constructor overload
    public NonSGStudent(String highestEducation, String courseEnrolled, Double courseFeesPaid, Boolean approvalForStay){
        super();
        this.highestEducation = highestEducation;
        this.courseEnrolled = courseEnrolled;
        this.courseFeesPaid = courseFeesPaid;
        this.approvalForStay = approvalForStay;
    }

    public double calculateSalesTax(){
        return this.getCourseFeesPaid() * 0.08;
    };

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
        if (courseFeesPaid >= 0){
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

    public double getForeignRebateRate(){
        return foreignRebateRate;
    }

    public void setForeignRebateRate(double rebateRate){
        this.foreignRebateRate = rebateRate;
    }

    public void displayForeignRebate(int courseFeeAmount, double rebateRate){
        double rebateAmount = calculateStudentRebate(courseFeeAmount, rebateRate);
        System.out.println("Net course fees are: " + (courseFeeAmount - rebateAmount));
    }

    @Override
    public void displayStudentDetails(){
        super.displayStudentDetails();
        System.out.println("Highest Education: " + getHighestEducation());
        System.out.println("Course Enrolled: " + getCourseEnrolled());
        System.out.println("Course Fees Paid: " + getCourseFeesPaid());
        System.out.println("Approval for stay: " + getApprovalForStay());
    }

    @Override
    public void editDetails(){
        super.editDetails();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter new highest education: ");
        String newHighestEducation = scanner.nextLine();
        this.setHighestEducation(newHighestEducation);

        System.out.println("Enter new course enrolled");
        String newCourseEnrolled = scanner.nextLine();
        this.setCourseEnrolled(newCourseEnrolled);

        System.out.println("Enter new course Fees Paid");
        double newCourseFeesPaid = scanner.nextDouble();
        this.setCourseFeesPaid(newCourseFeesPaid);

        System.out.println("Enter approval for stay status");
        boolean newApprovalForStay = scanner.nextBoolean();
        this.setApprovalForStay(newApprovalForStay);;

    }

    
}
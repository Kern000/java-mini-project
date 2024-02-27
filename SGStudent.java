import java.util.Scanner;

public class SGStudent extends Student { 

    private String highestEducation;
    private String courseEnrolled;
    private Double courseFeesPaid;
    private Double localRebateRate = 0.05;

    public SGStudent(){
        super();
        highestEducation="";
        courseEnrolled="";
        courseFeesPaid=0.0;
    }
   
    public SGStudent(   int studentId,
                        String name,
                        String nationality,
                        int age,
                        int idOrForeignPass,
                        String address,
                        String highestEducation,
                        String courseEnrolled,
                        Double courseFeesPaid)
    {
        super(studentId, name, nationality, age, idOrForeignPass, address);
        setHighestEducation(highestEducation);
        setCourseEnrolled(courseEnrolled);
        setCourseFeesPaid(courseFeesPaid);
    }

    public String getHighestEducation(){
        return highestEducation;
    }

    public double calculateSalesTax(){
        return this.getCourseFeesPaid() * 0.05;
    };


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

    public double getLocalRebateRate(){
        return localRebateRate;
    }

    public void setLocalRebateRate(double rebateRate){
        this.localRebateRate = rebateRate;
    }

    public void displayLocalRebate(int courseFeeAmount, double rebateRate){
        double rebateAmount = calculateStudentRebate(courseFeeAmount, rebateRate);
        System.out.println("Net course fees are: " + (courseFeeAmount - rebateAmount));
    }

    @Override
    public void displayStudentDetails(){
        super.displayStudentDetails();
        System.out.println("Highest Education: " + getHighestEducation());
        System.out.println("Course Enrolled: " + getCourseEnrolled());
        System.out.println("Course Fees Paid: " + getCourseFeesPaid());
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

    }


}
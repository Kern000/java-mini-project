import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

public class Main {

    private static List<Student> allStudents = new ArrayList<>();
    private static List<SGStudent> localStudentList = new ArrayList<>();
    private static List<NonSGStudent> foreignStudentList = new ArrayList<>();
    private static List<ClassPass> classPassList = new ArrayList<>();

    public List getLocalStudentArrayList (){
        return localStudentList;
    }

    public List getForeignStudentArrayList(){
        return foreignStudentList;
    }

    protected static int assignStudentId(){
        double id = Math.random() * 1000 * 17238;
        int intId = (int) Math.round(id); //typecasting
        return intId;
    }

    private static Scanner scanner = new Scanner(System.in);

    private static int displayChoiceMenu(){

        int choice = 0;

        while (true){
            System.out.println("Choice menu");
            System.out.println("1. Add a student");
            System.out.println("2. Display all students");
            System.out.println("3. Update student");
            System.out.println("4. Delete Student");
            System.out.println("5. Add classpass");
            System.out.println("6. Display classpass");
            System.out.println("7. Display all taxed programs");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline in buffer

            if (choice >= 1 && choice <=8){
                break;
            }
        }
        return choice;
    }

    private static void addNewStudent(){
       
        System.out.println("Enter name: ");
        String name = scanner.nextLine();

        System.out.println("Enter nationality: ");
        String nationality = scanner.nextLine();

        System.out.println("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();             //consume newline chr in buffer

        System.out.println("Enter Id or Foreign Pass No.: ");
        int idOrForeignPass = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter student address: ");
        String address = scanner.nextLine();

        int choice;

        while (true){
            System.out.println("For local student press 1. For foreign student press 2");
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1 || choice == 2){
                break;
            } else {
                System.out.println("invalid choice, try again");
            }
        }

        if (choice == 1){

            System.out.println("Enter highest Education: ");
            String highestEducation = scanner.nextLine();

            System.out.println("Enter course enrolled: ");
            String courseEnrolled = scanner.nextLine();

            System.out.println("Enter course fee paid: ");
            Double courseFeesPaid = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Assigning student id...");
            int studentId = assignStudentId();
            System.out.println("student id assigned is: " + studentId);
    
            SGStudent newStudent = new SGStudent(studentId, name, nationality, age, idOrForeignPass, address, highestEducation, courseEnrolled, courseFeesPaid);
            localStudentList.add(newStudent);
            allStudents.add(newStudent);
            newStudent.displayStudentDetails();
            System.out.println("");

        } else if (choice == 2){
            System.out.println("Enter highest Education: ");
            String highestEducation = scanner.nextLine();

            System.out.println("Enter course enrolled: ");
            String courseEnrolled = scanner.nextLine();

            System.out.println("Enter course fee paid: ");
            Double courseFeesPaid = scanner.nextDouble();
            scanner.nextLine();

            System.out.println("Enter stay approval status: ");
            Boolean approvalForStay = scanner.nextBoolean();
            scanner.nextLine();

            System.out.println("Assigning student id...");
            int studentId = assignStudentId();
            System.out.println("student id assigned is: " + studentId);

            NonSGStudent newStudent = new NonSGStudent(studentId, name, nationality, age, idOrForeignPass, address, highestEducation, courseEnrolled, courseFeesPaid, approvalForStay);
            foreignStudentList.add(newStudent);
            allStudents.add(newStudent);

            System.out.println("New foreign student added!");
            newStudent.displayStudentDetails();
            System.out.println("");
        }
    } 

    private static void displayAllStudents(){
        for (Student student : allStudents){

            if (student instanceof SGStudent){
                System.out.println();
                SGStudent sgStudent = (SGStudent) student;
                sgStudent.displayStudentDetails();
    
            } else if (student instanceof NonSGStudent){
                System.out.println();
                NonSGStudent nonSgStudent = (NonSGStudent) student;
                nonSgStudent.displayStudentDetails();;
            }
        }
        System.out.println();
    }

    // private static void displayAllStudentsByCategory(){
    //     System.out.println("List of all students");
    //     System.out.println("Local Students: ");

    //     for (SGStudent student: localStudentList){
    //         System.out.println();
    //         student.displayStudentDetails();
    //         System.out.println("");
    //     }

    //     System.out.println("Foreign Students: ");

    //     for (NonSGStudent student: foreignStudentList){
    //         System.out.println();
    //         student.displayStudentDetails();
    //         System.out.println("");
    //     }
    // }

    public static void editStudentDetails(Student student){
        student.editDetails();
    }

    public static void editChoice (){
        System.out.print("Enter index of student you want to edit: ");
        int index = scanner.nextInt();
        scanner.nextLine();
            
        if (index >= 0 && index < allStudents.size()){
            Student studentToEdit = allStudents.get(index);
            editStudentDetails(studentToEdit);
        } else {
            System.out.println("Invalid index");
        }
    }

    public static void deleteChoice(){
        System.out.print("Enter index of student you want to terminate: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < allStudents.size()){
            allStudents.remove(index);
            System.out.println("Student terminated.");
        } else {
            System.out.println("Invalid Index");
        }
    }

    private static void addNewClassPass(){
        System.out.println("Enter class pass type: ");
        String type = scanner.nextLine();
        System.out.println("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        ClassPass newClassPass = new ClassPass(type, price);
        classPassList.add(newClassPass);
        System.out.println("Class pass added successfully");
    }

    private static void displayClassPasses(){
        System.out.println("Class pass list");
        for (ClassPass classPass : classPassList){
            System.out.println("Type: " + classPass.getType());
            System.out.println("Price: $" + classPass.getPrice());
            System.out.println("Sales Tax: $" + classPass.calculateSalesTax());
            System.out.println();
        }
    }

    private static void displayAllTaxedPrograms(){
        
        ArrayList<CompanyTaxReturns> taxedPrograms = new ArrayList<>();

        for (Student student : allStudents){
            taxedPrograms.add(student);
        }

        for (ClassPass classPass : classPassList){
            taxedPrograms.add(classPass);
        }

        System.out.println("List of taxed programs");
        double total = 0;
        for (CompanyTaxReturns program : taxedPrograms){
            double taxItem = program.calculateSalesTax();
            System.out.println("Tax: $" + program.calculateSalesTax());
            total += taxItem;
        }
        System.out.println("Total Tax: $" + total);
    }


    public static void main (String[] args){
        do {
            int choice = displayChoiceMenu();
            if (choice == 1){
                addNewStudent();
            } else if (choice == 2){
                displayAllStudents();
            } else if (choice == 3){
                editChoice();                     
            } else if (choice == 4){
                deleteChoice();
            } else if (choice == 5) {
                addNewClassPass();
            } else if (choice == 6){
                displayClassPasses();
            } else if (choice == 7){
                break;
            }
        } while (true);
    }   




}
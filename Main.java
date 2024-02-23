import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static int displayChoiceMenu(){

        int choice = 0;

        while (true){
            System.out.println("Choice menu");
            System.out.println("1. Add a student");
            System.out.println("2. Display all students");
            System.out.println("3. Update student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline in buffer

            if (choice >= 1 && choice <=5){
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

        System.out.println("Enter Highest Education: ");
        String highestEducation = scanner.nextLine();

        System.out.println("Enter Id or Foreign Pass No.: ");
        int idOrForeignPass = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter student address: ");
        String address = scanner.nextLine();

        System.out.println("Assign student id: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
    
        Student newStudent = new Student(studentId, name, nationality, age, highestEducation, idOrForeignPass, address);
        studentList.add(newStudent);
        System.out.println("New student added!");
    } 

    private static void displayAllStudents(){
        System.out.println("List of all students");
        for (Student student: studentList){
            System.out.println("");
            System.out.println("Student Id: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            System.out.println("Nationality: " + student.getNationality());
            System.out.println("Age: " + student.getAge());
            System.out.println("Highest Education: " + student.getHighestEducation());
            System.out.println("IdOrForeignPass: " + student.getIdOrForeignPass());
            System.out.println("Address: " + student.getAddress());
            System.out.println("");
        }
    }

    public static void main (String[] args){
        do {
            int choice = displayChoiceMenu();
            if (choice == 1){
                addNewStudent();
            } else if (choice == 2){
                displayAllStudents();
            }
            else if (choice == 5){
                break;
            }
        } while (true);
    }   
}
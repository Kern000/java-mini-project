import java.util.Scanner;

public abstract class Student implements CompanyTaxReturns {
    
    private int studentId;
    private String name;
    private String nationality;
    private int age;
    private int idOrForeignPass;
    private String address;

    public Student(){
        studentId =0;        
        name ="";
        nationality = "";
        age = 0;
        idOrForeignPass = 0;
        address="";
    }

    public Student( int studentId,
                    String name,
                    String nationality,
                    int age,
                    int idOrForeignPass,
                    String address                   
                    ){
        setStudentId(studentId);
        setName(name);
        setNationality(nationality);
        setAge(age);
        setIdOrForeignPass(idOrForeignPass);
        setAddress(address);
    }

    protected double calculateStudentRebate(double courseFeesPaid, double rebateRateForStudent){
        double rebateRate = rebateRateForStudent;
        return courseFeesPaid * rebateRate;
    }

    public abstract double calculateSalesTax();

    public int getStudentId(){
        return studentId;
    }

    public void setStudentId(int studentId){
        this.studentId = studentId;
    }

    public String getName(){
        return name;
    }
    public void setName(String name) throws IllegalArgumentException{
        if (name != null && !name.isEmpty()){
            this.name = name;
        } else {
            throw new IllegalArgumentException("Invalid name, non-empty string needed");
        }
    }

    public String getNationality(){
        return nationality;
    }
    public void setNationality(String nationality) throws IllegalArgumentException{
        if (nationality != null && !nationality.isEmpty()){
            this.nationality = nationality;
        } else {
            throw new IllegalArgumentException("Invalid nationality, non-empty string needed");
        }
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age) throws IllegalArgumentException{
        if (age != 0 && age > 0){
            this.age = age;
        } else {
            throw new IllegalArgumentException("Invalid age, pls set a non-zero int");
        }
    }
    public int getIdOrForeignPass(){
        return idOrForeignPass;
    }

    public void setIdOrForeignPass(int idOrForeignPass) throws IllegalArgumentException{
        if (idOrForeignPass != 0 && idOrForeignPass > 0){
            this.idOrForeignPass= idOrForeignPass;
        } else {
            throw new IllegalArgumentException("invalid student id. Provide non-empty int");
        }
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address) throws IllegalArgumentException{
        if (address != null && !address.isEmpty()){
            this.address = address;
        } else {
            throw new IllegalArgumentException("invalid address. Provide non-empty string");
        }
    }

    public void displayStudentDetails(){
        System.out.println("Student Id: " + getStudentId());
        System.out.println("Name: " + getName());
        System.out.println("Nationality: " + getNationality());
        System.out.println("Age: " + getAge());
        System.out.println("IdOrForeignPass: " + getIdOrForeignPass());
        System.out.println("Address: " + getAddress());
    }

    public void editDetails(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter new Name: ");
        String newName = scanner.nextLine();
        this.setName(newName);

        System.out.println("Enter new nationality: ");
        String newNationality = scanner.nextLine();
        this.setNationality(newNationality);

        System.out.println("Enter new age: ");
        int newAge = scanner.nextInt();
        scanner.nextLine();
        this.setAge(newAge);

        System.out.println("Enter new IdOrForeignPass: ");
        int newIdOrForeignPass = scanner.nextInt();
        scanner.nextLine();
        this.setIdOrForeignPass(newIdOrForeignPass);

        System.out.println("Enter new address: ");
        String newAddress = scanner.nextLine();
        this.setAddress(newAddress);

    }



    public static void main(String[] args){

    }


}

import java.util.Scanner;

public class Student {
    
    private int studentId;
    private String name;
    private String nationality;
    private int age;
    private String highestEducation;
    private int idOrForeignPass;
    private String address;
    
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

    public Student(){
        studentId =0;        
        name ="";
        nationality = "";
        age = 0;
        highestEducation = "";
        idOrForeignPass = 0;
        address="";
    }

    public Student( int studentId,
                    String name,
                    String nationality,
                    int age,
                    String highestEducation,
                    int idOrForeignPass,
                    String address                   
                    ){
        setStudentId(studentId);
        setName(name);
        setNationality(nationality);
        setAge(age);
        setHighestEducation(highestEducation);
        setIdOrForeignPass(idOrForeignPass);
        setAddress(address);
    }




    public static void main(String[] args){

    }


}

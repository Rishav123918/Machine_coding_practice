package Prototype_pattern;
interface prototype{
    prototype clone();
}
class student implements prototype{
    int rollno;
    private String name;
    int age;

    student(){}

    public student(int rollno, String name, int age) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }
    public prototype clone(){
        return new student(rollno,name,age);
    }

    @Override
    public String toString() {
        return "student{" +
                "rollno=" + rollno +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class main {
    public static void main(String[] args) {
        student obj=new student(19,"Rohit",26);
        student obj1=(student) obj.clone();
        System.out.println(obj+" "+obj1);
    }
}

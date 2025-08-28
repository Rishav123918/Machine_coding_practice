package Composite_pattern_lld;

import java.util.ArrayList;
import java.util.List;

interface Employee{
    void showdetails();
}
class developer implements Employee{
    private String name;
    private String role;

    public developer(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public void showdetails() {
        System.out.println("Name is :"+name+" role is : "+role);
    }
}
class Tester implements Employee{
    private String name;
    private String role;

    public Tester(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public void showdetails() {
        System.out.println("Name is :"+name+" role is : "+role);
    }
}

class Manager implements Employee{
    private String name;
    private String role;
    List<Employee>employees=new ArrayList<>();


    public Manager(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void addEmployee(Employee e)
    {
        employees.add(e);
    }
    public void removeEmployee(Employee e)
    {
        employees.remove(e);
    }


    @Override
    public void showdetails() {
        System.out.println("Name is :"+name+" role is : "+role);
        for(Employee e:employees){
            e.showdetails();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Employee employee1=new developer("Alice","Developer");
        Employee employee2=new developer("Rohit","Developer");
        Employee Tester1=new Tester("John","Tester");
        Employee tester2=new Tester("Alex","Tester");


        Manager manager=new Manager("David", "Engineering");
        manager.addEmployee(employee1);
        manager.addEmployee(employee2);
        manager.addEmployee(Tester1);
        manager.addEmployee(tester2);
        Manager generalManager = new Manager("Eve", "General Management");
        generalManager.addEmployee(manager);
        generalManager.showdetails();

    }
}

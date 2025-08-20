package Collection_list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
class Employee{
    private int id;
    private String name;
    private int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }
}
class duplicate
{
    public List<Integer>duplicate1(List<Integer>list1)
    {
        List<Integer>st=new ArrayList<>();
        for(Integer it:list1)
        {
            if(!st.contains(it)){
                st.add(it);
            }
        }
        return st;
    }
    public List<Integer>duplicate2(List<Integer>list1,int k)
    {
        int ans=k%list1.size();
        List<Integer>st=new ArrayList<>();
        st.addAll(list1);
        Collections.reverse(st);
        Collections.reverse(st.subList(0,ans));
        Collections.reverse(st.subList(ans,list1.size()));
        return st;
    }
}
public class main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
        List<Integer>list=new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);
        list.add(2);
        duplicate d=new duplicate();
        List<Integer>output=d.duplicate1(list);
        Collections.sort(output);
        for(Integer it:output){
            System.out.println(it);
        }
        int k=sc.nextInt();
        List<Integer>output2=d.duplicate2(list,k);
        for(Integer it:output2){
            System.out.println(it);
        }
        List<Employee>employees=new ArrayList<>();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("employees entries"+" "+i+1+" : ");
            int id = sc.nextInt();
            String name = sc.next();
            int salary = sc.nextInt();
            employees.add(new Employee(id, name, salary));
        }
        Collections.sort(employees,(s1, s2)->{
            if(s1.getSalary()!= s2.getSalary()){
                return s2.getSalary()- s1.getSalary();
//                return Integer.compare(s2.getSalary(),s1.getSalary()); if salary is too bbig then use this
            }else{
                return s1.getName().compareTo(s2.getName());
            }
        });
        for(Employee e1:employees){
            System.out.println(e1.getId()+" "+e1.getName()+" "+e1.getSalary());
        }

    }
}

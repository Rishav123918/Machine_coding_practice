package Singleton_classes;
class lazy_intilization{
    private static lazy_intilization instance=null;
    private lazy_intilization(){
        System.out.println("Lazy initilizations");
    }
    public static lazy_intilization getInstance(){
        if(instance==null){
            instance=new lazy_intilization();
        }
        return instance;
    }
}
public class Lazy_intilizations {
    public static void main(String[] args) {
        lazy_intilization obj=lazy_intilization.getInstance();
        System.out.println(obj.hashCode());
    }
}

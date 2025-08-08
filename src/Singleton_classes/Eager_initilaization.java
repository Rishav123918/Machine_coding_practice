package Singleton_classes;
class eager_singleton{
    private static eager_singleton intances=new eager_singleton();
    private eager_singleton(){
        System.out.println("Eager initilization declared");
    }
    public static eager_singleton getintance(){
        return intances;
    }
}


public class Eager_initilaization {
    public static void main(String[] args) {
        eager_singleton obj=eager_singleton.getintance();
        System.out.println(obj.getClass());
    }
}

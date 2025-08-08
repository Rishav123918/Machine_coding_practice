package Singleton_classes;
class double_lock{
    private static volatile double_lock instance=null;
    private double_lock(){
        System.out.println("connection established");
    }

    public static double_lock getInstance() {
        if(instance==null)
        {
            synchronized (double_lock.class){
                if(instance==null){
                    instance=new double_lock();
                }
            }
        }
        return instance;
    }
}
public class Double_lock_singleton {
    public static void main(String[] args) {
      double_lock obj=double_lock.getInstance();
        System.out.println(obj.toString());
    }
}

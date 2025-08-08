package Singleton_classes;
class bill_pough_class{
    private bill_pough_class(){
        System.out.println("class intilization");
    }
    private static class bill_pough_ineer{
        private static final bill_pough_class instance=new bill_pough_class();
    }
    public  static bill_pough_class getInstance(){
       return bill_pough_ineer.instance;
    }
}

public class bill_pough {
    public static void main(String[] args) {
      bill_pough_class obj=bill_pough_class.getInstance();
        System.out.println(obj.toString());
    }
}

package Singleton_classes;
class synchronised_singleton{
    private static synchronised_singleton inntnces=null;
    private synchronised_singleton(){
        System.out.println("Sysnchronized method called");
    }

    public static synchronized synchronised_singleton getInstance(){
        if(inntnces==null){
            inntnces=new synchronised_singleton();
        }
        return inntnces;
    }
}


public class Synchrinized_singleton {
    public static void main(String[] args){
        synchronised_singleton obj=synchronised_singleton.getInstance();

        System.out.println(obj.hashCode());
    }
}

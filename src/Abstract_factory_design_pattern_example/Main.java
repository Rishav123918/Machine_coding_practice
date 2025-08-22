package Abstract_factory_design_pattern_example;
class economic_car1 implements Car{
    @Override
    public int getspeed() {
        return 50;
    }
}
class economic_car2 implements Car{
    @Override
    public int getspeed() {
        return 60;
    }
}
class luxury_car1 implements Car{
    @Override
    public int getspeed() {
        return 90;
    }
}
class luxury_car2 implements Car{
    @Override
    public int getspeed() {
        return 100;
    }
}


public class Main {
    public static void main(String[] args) {
        Abstract_product abstractProduct=new Abstract_product();
        Abstarctfactory abstarctfactory=abstractProduct.getfactoryinstance("Premium");
        Car carobj=abstarctfactory.getinstance(500000);
        System.out.println(carobj.getspeed());
    }


}

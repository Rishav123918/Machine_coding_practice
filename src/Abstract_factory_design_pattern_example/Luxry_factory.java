package Abstract_factory_design_pattern_example;

public class Luxry_factory implements Abstarctfactory{

    @Override
    public Car getinstance(int price) {
        if(price>500000){
            return new luxury_car1();
        }else{
            return new luxury_car2();
        }
    }
}

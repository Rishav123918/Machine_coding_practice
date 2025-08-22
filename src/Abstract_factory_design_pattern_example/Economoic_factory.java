package Abstract_factory_design_pattern_example;

public class Economoic_factory implements Abstarctfactory{


    @Override
    public Car getinstance(int price) {
        if(price<=300000){
            return new economic_car1();
        }else{
            return new economic_car2();
        }
    }
}

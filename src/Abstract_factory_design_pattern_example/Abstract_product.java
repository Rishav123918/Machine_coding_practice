package Abstract_factory_design_pattern_example;

public class Abstract_product {
    public Abstarctfactory getfactoryinstance(String value){
        if(value.equals("Economic")){
            return new Economoic_factory();
        }else if(value.equals("Luxury") || value.equals("Premium")){
            return new Luxry_factory();
        }
        return null;
    }
}

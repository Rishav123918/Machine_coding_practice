package Java_Billing_using_SOLID_principal;
class Biiling{
   private Double price;
    private String type;
    private String value;

    public Biiling(Double price,String type,String value)
    {
        this.price=price;
        this.type=type;
        this.value=value;
    }
    public Double getPrice() {
        return price;
    }
    public String getType() {
        return type;
    }
    public String getValue() {
        return value;
    }
}
interface Billingstrategy{
    public Double applydiscount(Biiling biiling);
}
class  PercentageDiscount implements Billingstrategy{
    @Override
    public Double applydiscount(Biiling biiling){
       Double discount= Double.parseDouble(biiling.getValue());
       return biiling.getPrice()-(1-discount/100);
    }
}
class  FlatDiscount implements Billingstrategy{
    @Override
    public Double applydiscount(Biiling biiling){
        Double dis=Double.parseDouble(biiling.getValue());
        return biiling.getPrice()-dis;
    }
}

class Biilingcase{

    public static Billingstrategy gettype(String type){
        switch(type.toLowerCase())
        {
            case "percentage" :
                return new PercentageDiscount();
            case  "flat" :
                return  new FlatDiscount();

            default:
                throw new IllegalArgumentException("Unknown discount type");
        }
    }
}




public class Main {
    public static void main(String args[]){
        Biiling b=new Biiling(1000.0,"Percentage","200");

        Billingstrategy bill=Biilingcase.gettype(b.getType());

        Double finalprice=bill.applydiscount(b);

        System.out.println("Final price after discount "+finalprice);
    }
}

/*
🧾 Input Example:
Product price: 1000.0
Discount type: "percentage" or "flat"
Discount value:
If percentage: 10 (means 10%)
If flat: 200 (means ₹200 off)
✅ Output Example:
Final price after applying discount:
If percentage 10% on ₹1000 → Output: 900.0
If flat ₹200 on ₹1000 → Output: 800.0
 */

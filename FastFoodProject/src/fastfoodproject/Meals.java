package fastfoodproject;

public class Meals extends Food{
private String contents ;

public Meals() {
super();
}

public Meals( String name, double price , String contents ) {
super(name, price);
this.contents = contents;
}

public  double calculatePrice(char size , int count )
{
    super.setQuantity(count);
    super.setSize(size);
double MealPrice = super.getPrice() ; 
if(size == 'M')
MealPrice += 8 ; 
else
if(size == 'L')
MealPrice += 12 ; 

MealPrice = MealPrice * count ; 
// add Vat 
MealPrice = MealPrice + ( MealPrice * Vat ) ; 
return MealPrice; 
}

@Override
public String toString() {
return "Meal {" + super.toString()+ " , contents  : " + contents + '}';
}

public String getContents() {
return contents;
}

public void setContents(String contents) {
this.contents = contents;
}

}

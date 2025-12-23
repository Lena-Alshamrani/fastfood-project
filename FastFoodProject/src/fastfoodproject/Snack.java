package fastfoodproject;


public class Snack extends Food {

    public Snack() {
    }

    public Snack(String n, double p) {
        super(n, p);
    }
 
public  double calculatePrice(char size , int count )
{
    super.setQuantity(count);
    super.setSize(size);
double MealPrice = super.getPrice() ; 
if( size == 'M')
    MealPrice += 8 ; 
else
if(size == 'L')
MealPrice += 15 ; 

MealPrice = MealPrice * count ; 
// add Vat 
MealPrice = MealPrice + ( MealPrice * Vat ) ; 
return MealPrice; 
}

@Override
public String toString() {
return "Snack {" + super.toString() + '}' ; 
} 
    
}

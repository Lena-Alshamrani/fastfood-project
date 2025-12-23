package fastfoodproject;

public class ColdDrinks extends Food {
    
 private boolean withIceCream ; 

    public ColdDrinks() {
        super(); 
    }

    public ColdDrinks( String name, double price , boolean withIceCream) {
        super(name , price );
        this.withIceCream = withIceCream;
    }
 
 
public  double calculatePrice(char size , int count )
{
    super.setQuantity(count);
    super.setSize(size);
double MealPrice = super.getPrice() ; 
if( size == 'S')
    MealPrice += 2 ; 
else
if(size == 'M')
MealPrice += 5 ; 
else
if(size == 'L')
MealPrice += 9 ; 

if( this.withIceCream == true )
    MealPrice += 3 ; 

MealPrice = MealPrice * count ; 
// add Vat 
MealPrice = MealPrice + ( MealPrice * Vat ) ; 

return MealPrice; 
}

@Override
public String toString() {
String str =  "ColdDrink {" + super.toString() ; 
if( withIceCream == true ) 
    str = str + " withIceCream " ;

return str; 
}

    public boolean isWithIceCream() {
        return withIceCream;
    }

    public void setWithIceCream(boolean withIceCream) {
        this.withIceCream = withIceCream;
    }


    
}

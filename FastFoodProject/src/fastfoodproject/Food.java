package fastfoodproject;

public abstract class Food implements Payment{

private String name;
private double price ; 
private char size ;
private int Quantity ; 

public abstract double calculatePrice(char size , int count );

public Food() {
name = "-" ; 
price = 0 ; 
}

public Food(String name, double p) {
this.name = name;
this.setPrice(p);
this.Quantity = 1; 
this.size = 'S' ; 

}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public double getPrice() {
return price;
}

public void setPrice(double p) {
if( p > 0 )
this.price = p;
else
{
    System.out.println("Error price , price will set 10 RS ");
    this.price = 10 ; 
}}

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int Quantity) {
        if( Quantity > 0 )
        this.Quantity = Quantity;
        else
            this.Quantity = 1 ; 
    }



@Override
public String toString() {
return  "name : " + name + ", price : " + price  ;
}
    
}

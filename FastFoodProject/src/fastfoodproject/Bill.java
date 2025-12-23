package fastfoodproject;

import java.util.ArrayList;

import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Bill {

private Food[]  menu = new Food[6] ; 

ArrayList<Food>  orderItems = new ArrayList<Food>() ; 
private double total ; 
private static int number = 1 ; 
private int BillNo ; 
private Person prson ; 
private Date date ; 
Scanner input = new Scanner(System.in) ; 

public Bill(){
BillNo  = number ; 
number++ ; 
Calendar current = Calendar.getInstance();
date =  current.getTime()  ; 
total = 0.0 ; 
FillMenu() ; 
}

public Bill(Person prson) {
this.prson = prson;
total = 0.0 ; 
BillNo  = number ; 
number++ ; 
Calendar current = Calendar.getInstance();
date =  current.getTime()  ;  
FillMenu(); 
}

public void FillMenu(){
menu[0] = new ColdDrinks("Orange Juce" , 11 , false)  ;
menu[1] = new ColdDrinks("Avocado with nuts" , 15 , true)  ;
menu[2] = new Meals("Burger" , 20 , " With cheese slices, tomatoes, cucumber pickles, and special sauce ") ; 
menu[3] = new Meals("IndianFood" , 20 , " Rice with spiced chicken tikka pieces ") ; 
menu[4] = new Snack("Crisp Botato" , 9 ) ; 
menu[5] = new Snack("Cookies" , 5 ) ; 

}

public void printMenu(){
    System.out.println("\n**** Menu**** \n");
for(int i = 0 ; i < menu.length ; i++)
System.out.println( i  + " ) " + menu[i].toString()   );

System.out.println("");
}

public void addItem(){
try{
printMenu() ;  // call method to print menu for customer
System.out.println("Enter number of item : ");
int num = input.nextInt(); 
Food item = menu[num] ; 
char size ;
do{
System.out.print("Enter size S , M , or L  in capital letter:  ");
 size = input.next().charAt(0) ;  
}while( size != 'S' && size != 'M' && size != 'L') ; 

System.out.println("Enter Quantity ");
int Qun = input.nextInt(); 
total = total + item.calculatePrice(size, Qun) ; 
orderItems.add( item) ; 
}
catch(InputMismatchException ex ){
    String garbage = input.next(); 
    System.out.println("you enter char insted of number , try again");
    
}
catch(Exception ex ){
System.out.println("An error occurred while adding the item, try again ");
}

}

public void cancelItem(){
try{
System.out.println("your Items : ");
int index = 0 ; 
for( Food F : orderItems ){
System.out.println(index + " ) " + F.toString() ) ; 
index++ ; 
}

System.out.println("\n >>> Enter number of item to remove from order : ");
int num = input.nextInt(); 

Food item = orderItems.get(num);
total = total - ( item.calculatePrice( item.getSize() , item.getQuantity() ));
orderItems.remove(num) ; 

System.out.println("cancel done");
return ; 
}
catch(Exception ex ){
System.out.println("An error occurred while remve the item, try again ");
}
    System.out.println("Can't remove item ");
}

public String toString()  {
String out = "Bill NO. " + this.BillNo + "\n"; 
out += "Total Price : " + String.format("%.2f",  total) + " - Date : " + date + "\n"; 
out  += "Person : " + prson.toString() + "\n"; 

out += " *** items *** \n" ; 
for( Food F : orderItems ){
out += F.toString()  ; 
out +=  " ,  size : " + F.getSize() + " , Quantity : " + F.getQuantity() + "\n" ; 
        }

out += "========================\n" ;
return out; 
}

    public Food[] getMenu() {
        return menu;
    }

    public void setMenu(Food[] menu) {
        this.menu = menu;
    }

    public ArrayList<Food> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(ArrayList<Food> orderItems) {
        this.orderItems = orderItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public static int getNumber() {
        return number;
    }

    public static void setNumber(int number) {
        Bill.number = number;
    }

    public int getBillNo() {
        return BillNo;
    }

    public void setBillNo(int BillNo) {
        this.BillNo = BillNo;
    }

    public Person getPrson() {
        return prson;
    }

    public void setPrson(Person prson) {
        this.prson = prson;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Scanner getInput() {
        return input;
    }

    public void setInput(Scanner input) {
        this.input = input;
    }


}

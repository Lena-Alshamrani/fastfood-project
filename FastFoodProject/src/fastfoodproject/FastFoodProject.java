package fastfoodproject;

import java.util.* ; 
import java.io.* ; 

public class FastFoodProject {
    
static ArrayList<Bill> allBills = new ArrayList<Bill>() ; 
static Scanner input = new Scanner(System.in) ; 

public static void main(String[] args) {

    System.out.println(" welcom in  FastFoodProject System \n ");
int choice  = 0 ;

do{
    try{
System.out.println("\n ---enter your choice :--- ");
System.out.println("1- add new order .");
System.out.println("2- cancel item from order");
System.out.println("3- print order");
System.out.println("4- save all Bill information to file ");
System.out.println("5- remove one Order ");
System.out.println("6- close program. ");
choice = input.nextInt(); 

switch( choice){
    case 1 : 
        addNewOrder() ;
        break;
        
    case 2 : 
        cancelItem(); 
        break; 
        
    case 3 : 
       printOrder();  
        
        break; 
        
    case 4 : 
        SaveToFile() ; 
      
        break; 
    case 5 : 
    removeOneOrder() ; 
    break; 
    case 6 : 
        System.out.println("**** Good by ***** ");
        break; 
    default : 
System.out.println("choice must be between 1 - 5 .") ; 
}// swtch
    } // end try 
    catch(InputMismatchException ex ){
    String garbage = input.next(); 
    System.out.println("you enter char insted of number , try again");
    
}
catch(Exception ex ){
System.out.println("An error occurred while adding the item, try again ");
}
}while( choice != 6 ) ; 

}// main 

//=======================
public static void addNewOrder(){
    System.out.print("Enter your Mobile : ");
    String MOB = input.next() ; 
    System.out.println("Enter the address to which the order is to be delivered :");
    input.nextLine(); 
    String address = input.nextLine(); 
    Person customer = new Person(MOB , address) ; 
    
    Bill bill = new Bill(customer) ; 
    String ansr = "yes" ; 
    do{
       bill.addItem(); 
       
        System.out.println("do you want to add more item : ( yes or no )");
        ansr = input.next(); 
    }while(ansr.equalsIgnoreCase("yes")) ; 
    
    System.out.println("Bill : \n" + bill.toString() );
    allBills.add(bill) ; 
}

//============================

public static void cancelItem(){
    System.out.println("Enter NO. of your Bill : ");
    int NO = input.nextInt(); 
    
    for( Bill bill  : allBills)
      if( bill.getBillNo() == NO ){
          bill.cancelItem(); 
          return ; 
      }
    
    System.out.println("Number of bill is not found");
    
}
//=======================
        
public static void printOrder(){
    System.out.println("Enter NO. of your Bill : ");
    int NO = input.nextInt(); 
    
    for( Bill bill  : allBills)
      if( bill.getBillNo() == NO ){
          System.out.println(bill.toString() );
          return ; 
      }
    
    System.out.println("Number of bill is not found");
    
}
//=======================

public static void SaveToFile(){
    System.out.println("Enter Name of file to save information of all Bill Ex>> ( info.txt ): ");
    String Name = input.next(); 
    try{
  
Formatter file = new Formatter(Name)  ;

for( Bill bill :  allBills )
{
file.format(bill.toString() + "%n");
}

file.close();
System.out.println("save all Bills to file will done.");
   
        
    }catch(IOException e){
        System.out.println(e.toString());
    }
}

//====================
public static void  removeOneOrder(){
     System.out.println("Enter NO. of your Bill to remove it from orders : ");
    int NO = input.nextInt(); 
    
    for( Bill bill  : allBills)
      if( bill.getBillNo() == NO ){
         allBills.remove(bill) ;
        System.out.println("remove don to bill No. " + NO );
          return ; 
      }
    
    System.out.println("Number of bill is not found");
}


}

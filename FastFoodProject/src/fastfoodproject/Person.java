package fastfoodproject;

import java.util.Scanner;

public class Person {
private String Mobile ; 
private String Address ; 

public Person() {
}

public Person(String Mobile, String Address) {
this.setMobile( Mobile ) ; 
this.Address = Address;
}

public String getMobile() {
return Mobile;
}

public void setMobile(String Mobile) {
Scanner input = new Scanner(System.in) ; 

while(Mobile.length() != 10 || Mobile.charAt(0) != '0'){
System.out.println("Error mobile number mobile must 10 numbe  and starts with zero");
Mobile = input.next(); 
}
this.Mobile = Mobile;
}

public String getAddress() {
return Address;
}

public void setAddress(String Address) {
this.Address = Address;
}

@Override
public String toString() {
return  " Mobile=" + Mobile + ", Address=" + Address  ;
}


}

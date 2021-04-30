public class WelcomeOffice  { 
private String greeting = "Hello";
private String who = 
			"People";
public static void main(String[] args) { 
WelcomeOffice office = new WelcomeOffice();
System.out.println(office.sayHello());
} 
public String sayHello() { 
String speech = greeting + " " +  who;
return speech;
} 

 } 

/*
Joshua Gao and Lawrence?
APCS
HW #12: On Elder Individuality and the Elimination of Radio Fuzz
2021-10-5

DISCOVERIES
I spent way more than 20 mintues and realized I don't know what I'm doing. 
UNRESOLVED QUESTIONS
I have no idea what the heck I'm doing. Especially with the greeting = rhcard.greet("freshman")
Also, I have no idea what BigSib richard = new BigSib(); means
*/

public class Greet {
    public static void main( String[] args ) {
      String greeting;
  
      BigSib richard = new BigSib();
      richard.setHelloMsg("Word up ");
  
      greeting = richard.greet("freshman");
      System.out.println(greeting);
    } //end main()
  } //end Greet

//creation of new class called Richard and new method called setHelloMsg
public class richard {
    public static void setHelloMsg(String name) {
        System.out.println(name); //new method prints out input string
    }
    public static void greet(String name) {
        System.out.print(name);
        System.out.println("Salutations Dr. Spaceman");
        System.out.println("Hey ya Kong Fooey");
        System.out.println("Sup mom");
    } //end of greeting method
}

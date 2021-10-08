/*
Joshua Gao & Batman
APCS
HW14- Customize Your Creation: Using Constructors
20201-10-07

DISCO
The declaration of an instance field must be outside the method, but inside the class.
The value of an objects uses the keyword new and the previously defined constructor.
Dot operator must be invoked to call instance field value. 

QCC
N/A
*/


public class Greet {
    //Creation of instance field
    String greeting;

    public static void main(String[] args) {
        //Default constructor   
        BigSib richard = new BigSib();
        BigSib grizz = new BigSib();
        Bigsib dotCom = new BigSib();
        BigSib tracy = new BigSib();
        //Arugment pass-through
        //Dot operator: object.instance-field
        //Must print immediately since no overloading constructor
        greeting = richard.greet('freshman loser');
        System.out.println(greeting);

        greeting = grizz.greet('Dr. Spaceman wow');
        System.out.println(greeting);

        greeting = dotCom.greet('Kong Fooey lol');
        System.out.println(greeting);

        greeting = tracy.greet('mom hi');
        System.out.println(greeting);
    }
}

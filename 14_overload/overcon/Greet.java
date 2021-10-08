/*
Joshua Gao & Batman
APCS
HW14- Customize Your Creation: Using Constructors
20201-10-07

DISCO
Overloaded constructors have the same class, but must have different arguments so Java
can differentiate between the constructors.

QCC
N/A
*/


public class Greet {
    //Creation of instance field
    String greeting;

    public static void main(String[] args) {
        //Default constructor   
        BigSib richard = new BigSib('Word up');
        BigSib grizz = new BigSib('Hey ya');
        Bigsib dotCom = new BigSib('Sup');
        BigSib tracy = new BigSib('Salutations');
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

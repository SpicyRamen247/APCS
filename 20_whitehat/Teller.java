/*
Edited by Joshua Gao, Jacclyn Chen, Kosta Dubovskiy
DISCO
    Can only run ba.[instVar] in BankAccount's main method, since their security is private. This is correct, since it makes the bank account more secure.
    For shorts to be passed in as parameters, we need to specify that its a short with (short) right before our pin, otherwise there is an error reading
    that there is possible information loss in the int->short conversion. 
    Java does not do sig figs with +- operations like those of our deposit/withdraw methods.
QCC
    N/A
*/

public class Teller {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        ba.setName("Kosta");
        ba.setPasswd("tacky");
        ba.setPin((short) 8224);
        ba.setAcctNum(563788956); 
        ba.setBalance(100.30);
        ba.deposit(10);
        ba.withdraw(10.000);
        ba.authenticate(563788956, "tacky");
        System.out.println(ba.toString());
    }
}
/*
DISCO
    Can't use print from inside method;
    Can't convert primitive int or float to String with toString, must use a copy-cat class named Integer/Float and their respective toString() methods;
QCC
    
Team Joshua, Kosta, Jaclyns’s Latest and Greatest Q2 Response:
    It initializes all instance variables as null;
Team Joshua, Kosta, Jaclyns’s Latest and Greatest Q3 Response:
    It would be worthy to test if it is possible to call .toString() on an Object who's parent class contains no such method, 
    such that the built-in .toString() method gets called.
*/

public class BankAccount {
    private static String holderName;
    private static String password;
    private static int pin;
    private static int accountNum;
    private static float balance;

    public static void main( String[] args) {
        BankAccount.setHolderName("Kosta");
        BankAccount.setPassword("08/23/2005");
        BankAccount.setPin(8224);
        BankAccount.setAccountNum(822485);
        BankAccount.setBalance(1);
        System.out.println(BankAccount.printInfo(8224, 822485));
        BankAccount.deposit(8224, 822485, 49);
        BankAccount.withdraw(8224, 822485, 1);
    }

    public static void setHolderName(String newName) {
        BankAccount.holderName = newName;
    }

    public static void setPassword(String newPass) {
        BankAccount.password = newPass;
    }

    public static void setPin(int newPin) {
        BankAccount.pin = newPin;
    }

    public static void setAccountNum(int newAccNum) {
        BankAccount.accountNum = newAccNum;
    }

    public static void setBalance(float newBal) {
        BankAccount.balance = newBal;
    }

    public static String printInfo(int reqPin, int reqAccountNum) {
        if (BankAccount.accountNum == reqAccountNum && BankAccount.pin == reqPin) {
            String result = "User Info:" + "\n" + BankAccount.holderName + "\n" + BankAccount.password + "\n" + Integer.toString(BankAccount.pin) + "\n" + Integer.toString(BankAccount.accountNum) + "\n" + Float.toString(BankAccount.balance) + "\n";
            return result;
        }
        return "Incorrect login info";
    }

    public static void deposit(int reqPin, int reqAccountNum, float amount) {
        if (BankAccount.accountNum == reqAccountNum && BankAccount.pin == reqPin) {
            BankAccount.balance += amount;
        }
    }

    public static void withdraw(int reqPin, int reqAccountNum, float amount) {
        if (BankAccount.accountNum == reqAccountNum && BankAccount.pin == reqPin) {
            BankAccount.balance -= amount;
        }
    }

}
import java.util.Scanner; 
import java.text.NumberFormat;
import javax.swing.JOptionPane;

public class Matrix{
    public static void main(String[] args) {
        //Prompts users to select of the following 3 options
        Scanner input = new Scanner (System.in);
        System.out.println("Choose an option: ");
        System.out.println("1. sum of row");
        System.out.println("2. average of row");
        System.out.println("3. largest row");
        System.out.println("Enter your operation:");
        int operation = input.nextInt();

        //Declare dimensions of 2D array
        System.out.println("Enter the number of rows");
        int ro = input.nextInt(); //row
        System.out.println("Enter the number of columns");
        int co = input.nextInt(); //column

        //Intialize array
        int[][] table = new int[ro][co];
        for(int i=0; i<table.length; i++) {
            for(int o=0; o<table[i].length; o++) {
                System.out.println("Enter values: ");
                int number = input.nextInt();
                table[i][o] = number;
            }
        }
        //Print to console the user's array 
        System.out.println("You entered: ");
        for(int rr=0; rr<table.length; rr++) {
            for(int col=0; col<table[rr].length; col++){
                System.out.print(table[rr][col] + "\t");
            }
            System.out.println();
        }

        //operations 
        if(operation==1) {
            System.out.println("Enter the row you want the sum of: ");
            int row = input.nextInt();
            System.out.println(sumofRow(table,row));
        }
        else if (operation==2) {
            System.out.println("Enter the row you want the average of: ");
            int row = input.nextInt();
            System.out.println(averageofRows(table,row));
        }
    }
    //operation 1
    public static int sumofRow(int[][] arr, int row) {
        int sum = 0;
        for(int col=0; col < arr[row].length; col++) {
            sum += arr[row][col];
        }
        return sum;
    }
    //operation 2
    public static int averageofRows(int[][] arr, int row) {
        // int column = arr[row].length;
        int sum = 0;
        for(int col=0; col < arr[row].length; col++) {
            sum += arr[row][col];
        }
        return sum;
        // int average = sum / column;
        // return average;
    }
 }


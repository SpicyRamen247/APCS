//
//MatrixMethods.java Author:Catherine Gao
//
import java.util.Scanner; 
import java.text.NumberFormat;
import javax.swing.JOptionPane;

public class MartixMethods
{ 
   public static void main(String[]args)
   { 
      int operations;
      Scanner scan = new Scanner (System.in);
      
      //numbering 
      int reverse = 1;
      int smallest = 2;
      int largest = 3; 
      String input;
      
      do
      {
       //asking what option they wanna choose
         System.out.println("Choose an option: ");
         System.out.println("1. sum of row");
         System.out.println("2. average of row");
         System.out.println("3. largest row");
         
         int size; 
         System.out.println("Enter your choices:");
         
         operations=scan.nextInt();
   
      //asking for size, rows, and columns
         int ro; 
         System.out.println("Enter the number of rows:");
         ro=scan.nextInt();
         
         int co; 
         System.out.println("Enter the number of columns:");
         co=scan.nextInt();
         
         //maske array, fill, 
         
         int[][]table= new int[ro][co];

         for(int i=0; i<table.length; i++)
         {
            for(int o=0; o<table[i].length;o++)
            {
               System.out.println("Enter values: ");
               int number=scan.nextInt();
               table[i][o]=number;
             }
         }
      //doing if statments for user choices
         if(operations==1)
         {
            System.out.println("You entered: ");
            
            for(int rr=0; rr<table.length; rr++)
            {
               for(int col=0; col<table[rr].length; col++)
               {
                  System.out.print(table[rr][col] + "\t");
               }
             System.out.println();
            }
            System.out.println("Enter the row you want the sum of: ");
            int row= scan.nextInt();
            
            System.out.println(sumOfRow(table,row));
         }
         else if (operations==2)
         {
            System.out.println("You entered: ");
            
            for(int rr=0; rr<table.length; rr++)
            {
               for(int col=0; col<table[rr].length; col++)
               {
                  System.out.print(table[rr][col] + "\t");
               }
             System.out.println();
            }
            System.out.println("Enter the row you want the average of: ");
            int row= scan.nextInt();           
           
            System.out.println(averageOfRows(table));
         }
         else if (operations == 3)
         {
             System.out.println("Largest row");
             System.out.println(largestRow(table));
         }
         
         System.out.println("Do you want to do it again?");
         input= scan.next();
      }
     //if yes do again if no say thanks
     while(input.equals("yes"));
     System.out.println("thanks!"); 
   }

      public static int sumOfRow(int[][] arr, int row)
      {
        int sum = 0; 
        for(int col = 0; col<arr[row].length; col++)
        {
           sum += arr[row][col];
        }
       return sum;
      }
      
    

      //
      public static double averageOfRows(int[][] arr) {
          int average = (int) sumofRow(table,row) / table.length();
          System.out.println(average);
      }
         
      /*
        for(int rr=0; rr<table.length; rr++)
            {
               for(int col=0; col<table[rr].length; col++)
               {
                  System.out.print(table[rr][col] + "\t");
               }
             System.out.println();
            }
            System.out.println("Enter the row you want the sum of: ");
            int row= scan.nextInt();
            
            System.out.println(sumOfRow(table,row));
         }
      */
      
      public static int largestRow(int[][] arr)
      {
         //add each row then compare 
         int largestrow = 0; 
         int largestsum = 0; 
         
         for(int i=0; i<arr.length; i++)
         {
            int sum = 0; 
            for(int m=0; m<arr[i].length; m++)
            {
               sum += arr[i][m];
            }
               
            if(sum>largestsum)
            {
              largestrow=i;
              largestsum=sum; 
            }
         }
       return largestrow;
      }
}


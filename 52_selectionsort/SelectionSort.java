// Team Watson vs The Final Project (Ruby Friedman, Anjini Katari, Joshua Gao)
// APCS pd07
// HW52 -- implementing selection sort
// 2022-01-05w
// time spent: 1.5 hrs

/******************************
// I was absent during this homework, but Anjini helped explain the code to me and I was able to replicate the code.
/*Takeaway from our Zoom session:
Selection sort is the process of finding the lowest value of each unsorted iterative sequence and immediately appending it at the index of the last sorted element + 1.

Sequence v0: 6, 2, 8, 7, 3
The intiial sequence is unsorted and the lowest value is 2. Therefore, we need to add it to the very beginning.

Sequence v1: 2, 6, 8, 7, 3
Then, the second smallest value is 3. The index of the first smallest value is 0, so we move 3 to index 1.

Sequence v2: 2, 3, 6, 8, 7
Then, the third smallest value is 6. It is already in the right position, so we don't move it. 

Sequence v3: 2, 3, 6, 8, 7
Then, the fourth smallest value is 7. The index of the third smallest value is 2, so we move 7 to index 3.

Sequence v4: 2, 3, 6, 7, 8
Then, the fifth smallest value is 8. The index the fourth smallest value is 3, so we move 8 to index 4. 
However, it is already at index 4 so we leave it be.

Now the sequence is completely sorted. Ta-Da!

*/
/******************************
 * class SelectionSort -- implements SelectionSort algorithm
 *
 * ALGO:
    Find the max val in arrayList and move it to the rightmost 
    position. Continue to repeat this for the second rightmost,
    third rightmost, and so on, until the array is in numerical 
    ascending order. 
 * DISCO
 * 'pass' in the skeleton was what we termed 'passCounter'
 * Cannot initalze a variable with the same name twice
 * The reason why the void and non void methods couldn't run 
   together was because of a namespace error between 'Glenn' 
   and "Coco". We fixed this by using the names 'Whoop' and "loco"
 * 
 * QCC
 * q0: How many passes to sort n elements?
 * a0: It takes n passes to sort n elements. 
 * q1: What do you know after pass p?
 * a1: After pass p, the rightmost p values are in the correct
       position. 
 * q2: How do you know if sorted?
 * a2: The array will have gone through its length amount of passes
       and it will be in ascending, numerical order. 
 * q3: What does a pass boil down to?
 * a3: A pass is a taking the next max value and moving it to the 
       correct position 
 ******************************/


import java.util.ArrayList;

public class SelectionSort {
    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
        ArrayList<Integer> retAL = new ArrayList<Integer>();
        while( size > 0 ) {
            //     offset + rand int on interval [lo,hi]
            retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
            size--;
        }
        return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
        int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
            //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
            //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) {
        //note: this version places greatest value at "rightmost" end
        //maxPos will point to position of SELECTION (greatest value)
        int maxPos = 0; //index of the max val
        Comparable maxVal = data.get(0);
        int len = data.size();
        int passCounter = 0;

        for (int i = 0; i < len; i++) {
            System.out.println( "\nbegin pass " + (data.size()- passCounter) );//diag
	        for (int j = 0; j < len - passCounter; j++) {
                if (data.get(j).compareTo(maxVal) > 0) {
                    maxVal = data.get(j);
                }
            }
            for (int pickaletter = 0; pickaletter < len; pickaletter++) {
                if (maxVal.compareTo(data.get(pickaletter)) == 0){
                    maxPos = pickaletter;
                }
            }
            data.remove(maxPos);
            data.add(len - passCounter - 1, maxVal);
            maxVal = 0;

            System.out.println( "maxVal: " + maxVal );

            System.out.println( "maxPos: " + maxPos );//diag
            System.out.println( data );//diag     
            System.out.println( "after swap: " +  data );//diag

            passCounter += 1;
        }

    }//end selectionSort


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input ) {
        //declare and initialize empty ArrayList for copying
        ArrayList<Comparable> data = new ArrayList<Comparable>();
        //copy input ArrayList into working ArrayList
        for( Comparable o : input )
           data.add( o );
        //sort working ArrayList
        selectionSortV( data );
        return data;
    }//end selectionSort


    public static void main( String [] args ) {
                 // /*===============for VOID methods=============

        ArrayList glen = new ArrayList<Integer>();
        glen.add(7);
        glen.add(1);
        glen.add(5);
        glen.add(12);
        glen.add(3);
        System.out.println( "ArrayList glen before sorting:\n" + glen );
        selectionSortV(glen);
        System.out.println( "ArrayList glen after sorting:\n" + glen );

        ArrayList coco = populate( 10, 1, 1000 );
        System.out.println( "ArrayList coco before sorting:\n" + coco );
        selectionSortV(coco);
        System.out.println( "ArrayList coco after sorting:\n" + coco );

        //  ============================================*/

        
        ArrayList whoop = new ArrayList<Integer>();
        whoop.add(7);
        whoop.add(1);
        whoop.add(5);
        whoop.add(12);
        whoop.add(3);
        System.out.println( "ArrayList whoop before sorting:\n" + whoop );
        ArrayList whoopSorted = selectionSort( whoop );
        System.out.println( "sorted version of ArrayList whoop:\n"
        + whoopSorted );
        System.out.println( "ArrayList whoop after sorting:\n" + whoop );

        ArrayList loco = populate( 10, 1, 1000 );
        System.out.println( "ArrayList loco before sorting:\n" + loco );
        ArrayList locoSorted = selectionSort( loco );
        System.out.println( "sorted version of ArrayList loco:\n"
        + locoSorted );
        System.out.println( "ArrayList loco after sorting:\n" + loco );
        System.out.println( loco );
        /*==========for AL-returning methods==========
        ============================================*/

    }//end main

}//end class SelectionSort
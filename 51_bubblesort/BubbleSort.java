// LYJ: Yat Long Chan, Lawrence Joa, Joshua Gao
// APCS pd0
// HW51 -- implementing bubblesort
// 2022-01-04t
// time spent:  0.3 hrs

/******************************
 * class BubbleSort -- implements bubblesort algorithm (vanilla)
 * ALGO: 
 * Start at the end of array. 
 * Compare 2 adjacent elements. Swap if former is larger than the latter.
 * Repeat with every possible pair.
 * Repeat entire process with one less element until no swaps are required.
 * 
 * DISCO
 * nothing new
 *
 * QCC
 * q0: If a pass requires no swaps, what do you know?
 * a0: the array is fully sorted
 * q1: After pass p, what do you know?
 * a1: p elements are in the correct order
 * q2: How many passes are necessary to completely sort?
 * a2: length of array - 1 passes
 * 
 ******************************/

import java.util.ArrayList;

public class BubbleSort
{

  //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
  //precond:  lo < hi && size > 0
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
  public static void shuffle( ArrayList al )
  {
    int randomIndex;
    //setup for traversal fr right to left
    for( int i = al.size()-1; i > 0; i-- ) {
      //pick an index at random
      randomIndex = (int)( (i+1) * Math.random() );
      //swap the values at position i and randomIndex
      al.set( i, al.set( randomIndex, al.get(i) ) );
    }
  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


  // VOID version of bubbleSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
  public static void bubbleSortV( ArrayList<Comparable> data )
  {
    for (int i = 0; i < data.size() - 1; i ++) {
        for (int j = data.size() - 1; j > i; j --) {
            Comparable leftVal = data.get(j - 1);
            Comparable rightVal = data.get(j);
            if (leftVal.compareTo(rightVal) > 0) {
                data.set(j, leftVal);
                data.set(j - 1, rightVal);
            }
        }
    }
  }


  // ArrayList-returning bubbleSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input )
  {
    ArrayList<Comparable> newData = new ArrayList<Comparable>();
    for(Comparable c: input) {
        newData.add(c);
    }
    bubbleSortV(newData);
    return newData;
  }


  public static void main( String [] args )
  {

    /*===============for VOID methods=============
    ============================================*/
    System.out.println("==========Testing VOID method==========");
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      bubbleSortV(glen);
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      bubbleSortV(coco);
      System.out.println( "ArrayList coco after sorting:\n" + coco );

    /*==========for AL-returning methods==========
    ============================================*/
      System.out.println("==========Testing AL-returning method==========");
      glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "ArrayList glen before sorting:\n" + glen );
      ArrayList glenSorted = bubbleSort( glen );
      System.out.println( "sorted version of ArrayList glen:\n" 
      + glenSorted );
      System.out.println( "ArrayList glen after sorting:\n" + glen );

      coco = populate( 10, 1, 1000 );
      System.out.println( "ArrayList coco before sorting:\n" + coco );
      ArrayList cocoSorted = bubbleSort( coco );
      System.out.println( "sorted version of ArrayList coco:\n" 
      + cocoSorted );
      System.out.println( "ArrayList coco after sorting:\n" + coco );

  }//end main

}//end class BubbleSort
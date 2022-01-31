// TNPG: Watson vs The Final Project (Anjini Katari, Ruby Friedman, Joshua Gao)
// APCS pd07
// HW53 -- implementing insertion sort
// 2022-01-06r
// time spent: 1.8 hrs

/******************************
/* I was absent during this homework, but Anjini helped explain the code to me and I was able to replicate the code.

Our nickname for Insertion Sort is the "Invisible Wall of Parition." 
The partition doesn't actuallly take up an index since it is invisible. 
We sort all the elements to the left of (including itself) the index of the invisible partition. 
Then, repeat this process until the partition is to the right of the rightmost element.

Sequence v0: 6, 2, 8, 7, 3 

Sequence v1: 6| 2, 8 , 7 , 3 = 6, 2, 8, 7, 3 
The first partition would at index 0, since the first element is at index 0. We sort everything to the left of index 0 (including itself)
which is just 6. 

Sequence v2: 6, 2 | 8, 7 ,3 = 2, 6, 8, 7, 3
The second partition would be at index 1, because the second element is at index 1. Now, we sort elements 6, 2 
in increasing order because indices 0 and 1 are to the left of (including itself) index 1.

Sequence v3: 2, 6, 8| 7, 3 = 2, 6, 8, 7, 3
The third partition would be at index 2, because the third element is at index 2. Now, we sort elements 2, 6, 8
in increasing order which remains the same.

Sequence v4: 2, 6, 8, 7| 3 = 2, 6, 7, 8, 3
The fourth partition would be at index 3, because the fourth element is at index 3. Now, we sort elements 2, 6, 8, 7
in increasing order which becomes 2, 6, 7, 8

Sequence v5: 2, 6, 7, 8, 3 | = 2, 3, 6, 7, 8
The fifth partition would be at index 4, because the fifth element is at index 4. Now, we sort elements 2,6,7,8, 3
in increasing order which becomes 2, 3, 6, 7, 8.

Because the partition is to the right of the rightmost element (in this case, it's 3), 
we know that this is the last sort it needs to do. 

*/
/******************************
 * class InsertionSort -- implements InsertionSort algorithm
 *
 * ALGO:
 * Created a partition starting at one, and sorted the elements
   before that partition, after the first partition elements were
   sorted, we added 1 to the partition and then sorted the next
   element added into place. This repeats until the entire array
   is sorted!
 * DISCO
 * Taking the time to properly indent is helpful for finding braces errors
 * Think SIMPLE, if code seems to complicated it PROBABLY IS, comment what you
   have out and try starting from scratch.
 *
 * QCC
 * q0: How many passes to sort n elements?
 * a0: n passes
 * q1: What do you know after pass p?
 * a1: The p+1 leftmost values will be sorted
 * q2: How will you know when sorted?
 * a2: When number of passes is equal to the number of elements
 * q3: What constitues a pass?
 * a3: When the partition moves over to the right 1
 * q4: What must you track?
 * a4: Where the partition is in the array
 ******************************/


import java.util.ArrayList;

public class InsertionSort
{
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
  // VOID version of InsertionSort
  // Rearranges elements of input ArrayList
  // postcondition: data's elements sorted in ascending order
	public static void insertionSortV( ArrayList<Comparable> data ) {
		int len = data.size();
		Comparable placeholder = data.get(0);
		for(int partition = 1; partition < len; partition++ ) {
		//partition marks first item in unsorted region

			System.out.println( "\npartition: " + partition + "\tdataset:"); //diag
			System.out.println( data );

			//traverse sorted region from right to left
			for( int i = partition; i > 0 && i < len; i--) {
				// "walk" the current item to where it belongs
				// by swapping adjacent items
				if (data.get(i).compareTo(data.get(i-1)) < 0) {
					System.out.println( "swap indices "+(i-1)+" & "+i+"..." ); //diag
					placeholder = data.get(i);
					System.out.println("Placeholder val: " + placeholder);
					data.set(i, data.get(i-1));
					data.set(i-1, placeholder);
				}
				else {
					break;
				}
			}
		}
	}//end insertionSortV


  // ArrayList-returning insertionSort
  // postcondition: order of input ArrayList's elements unchanged
  //                Returns sorted copy of input ArrayList.
  public static ArrayList<Comparable>
    insertionSort( ArrayList<Comparable> input )
  {
    //declare and initialize empty ArrayList for copying
    ArrayList<Comparable> data = new ArrayList<Comparable>();

    //copy input ArrayList into working ArrayList
    for( Comparable o : input )
      data.add( o );

    //sort working ArrayList
    insertionSortV( data );

    //return working ArrayList
    return data;
  }//end insertionSort

  public static void main( String [] args )
  {
      System.out.println("\n*** Testing sort-in-place (void) version... *** ");
      ArrayList glen = new ArrayList<Integer>();
      glen.add(7);
      glen.add(1);
      glen.add(5);
      glen.add(12);
      glen.add(3);
      System.out.println( "\nArrayList glen before sorting:\n" + glen );
      insertionSortV(glen);
      System.out.println( "\nArrayList glen after sorting:\n" + glen );

      ArrayList coco = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList coco before sorting:\n" + coco );
      insertionSortV(coco);
      System.out.println( "\nArrayList coco after sorting:\n" + coco );

      System.out.println( "*** Testing non-void version... *** " );
      ArrayList gwen = new ArrayList<Integer>();
      gwen.add(7);
      gwen.add(1);
      gwen.add(5);
      gwen.add(12);
      gwen.add(3);
      System.out.println( "\nArrayList gwen before sorting:\n" + gwen );
      ArrayList gwenSorted = insertionSort( gwen );
      System.out.println( "\nsorted version of ArrayList gwen:\n"
      + gwenSorted );
      System.out.println( "\nArrayList gwen after sorting:\n" + gwen );

      ArrayList roco = populate( 10, 1, 1000 );
      System.out.println( "\nArrayList roco before sorting:\n" + roco );
      ArrayList rocoSorted = insertionSort( roco );
      System.out.println( "\nsorted version of ArrayList roco:\n"
      + rocoSorted );
      System.out.println( "\nArrayList roco after sorting:\n" + roco );
      System.out.println( roco );

  }//end main

}//end class InsertionSort
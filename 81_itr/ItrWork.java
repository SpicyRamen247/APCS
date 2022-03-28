// Team McDonalds$24MScam: Prattay Dey, Joshua Gao, Faiza Huda
// Ducks : Winnie, Batman, Truthful Tom, Huebert
// APCS pd08
// HW81 -- Thank You, Next
// 2022-03-24
// time spent: 0.5 hr
// KtS consumed: 1


/***
 * class ItrWork
 *  SKELETON
 * Facilitates familiarization with iterators
 **/

/***
    DISCO
    - When using iterator and traversing a list, it is necessary to typecast the Integer object to an int first. Else an error with incompatible types will appear.

    QCC
    - When removing evens, why can't we remove from List L directly instead of the iterator?
      Throws a "ConcurrentModificationException"

    SUMMARY THE FIRST:
    hasNext(): checks to see if there is a next element in the list
    next(): returns the next element in the list
    remove(): removes the last element in the list

    SUMMARY THE SECOND:
    hasNext(): returns true if iteration has more elements after the current index
    next(): returns the next element in the list
    remove(): removes the current index or element that iterator is on, then calls next()
**/



import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork
{

  //using FOREACH loop
  //returns a boolean to indicate whether key is present in L
  public static boolean foundA( Integer key,
                                List<Integer> L )
  {
    for ( int n : L ){
      if (n == key){
        return true;
      }
    }
    return false;
  }

  //explicitly usin  Integer n = it.next(); // traversg an iterator
  //returns a boolean to indicate whether key is present in L
  public static boolean foundB( Integer key,
                                List<Integer> L )
  {
    Iterator it = L.iterator(); // creates Iterator Object for given List

    while ( it.hasNext() ){
      int n = (int) it.next(); // typecast Integer Object into int value

      if (n == key){
        return true;
      }
    }
    return false;
  }

  //using FOREACH loop
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsA( List<Integer> L )
  {
    List<Integer> result = new ArrayList();

    for ( int n : L ){
      if (n % 2 == 1){
        result.add(n);
      }
    }
    return result;
  }

  //explicitly using an iterator
  //returns a list containing the odd numbers in L
  public static List<Integer> oddsB( List<Integer> L )
  {
    List<Integer> result = new ArrayList<Integer>();

    Iterator it = L.iterator(); // creates Iterator Object for given List

    while ( it.hasNext() ){
      Integer n = it.next();
      if (n % 2 == 1){
        result.add(n);
      }
    }
    return result;
  }


  //explicitly using an iterator
  //modifies L s.t. it contains no evens
  public static void removeEvens( List<Integer> L )
  {
    Iterator it = L.iterator(); // creates Iterator Object for given List

    while ( it.hasNext() ){
      int n = (int) it.next(); // traverses list

      if (n % 2 == 0){
        it.remove();
      }
    }
  }


  public static void main( String [] args )
  {

    //var type: List   obj type: ?
    List<Integer> L = new ArrayList();

    for ( int i = 0; i < 10; i++ )
      L.add(i);


    // TASK: write code to print the contents of L...

    // a) using a FOREACH loop


    // b) explicitly using an iterator


    System.out.println("\nTesting foundA...");
    System.out.println("9 in L? -> " + foundA(9,L) );
    System.out.println("13 in L? -> " + foundA(13,L) );

    System.out.println("\nTesting foundB...");
    System.out.println("9 in L? -> " + foundB(9,L) );
    System.out.println("13 in L? -> " + foundB(13,L) );

    System.out.println("\nTesting oddsA...");
    List<Integer> A = oddsA(L);
    for( int n : A ) System.out.println(n);

    System.out.println("\nTesting oddsB...");
    List<Integer> B = oddsB(L);
    for( int n : B ) System.out.println(n);

    System.out.println("\nTesting removeEvens...");
    removeEvens(L);
    for( int n : L ) System.out.println(n);
    /*~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class ItrWork
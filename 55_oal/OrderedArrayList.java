/**
TNPG: Watson vs The Final Project (Anjini Katari, Ruby Friedman, Joshua Gao)
APCS pd07
HW55: Never Fear, Big Oh Is Here!
2022-01-12w
time spent: 1.0 hrs

DISCO:
 * Using the graphical representation of time-complexity helps us find out what methods
   are the BIG OH of.
 * The BIG OH of methods appears in the second paragraph of the API

QCC:
 * How does size work, does it look at the amount of memory the ArrayList takes up
   or do something else?
 * In what instance would we have n!, where would that show up?
 * When would O(nlogn) show up? How would we be able to tell it was that specific function?
*/

import java.util.ArrayList;

public class OrderedArrayList
{

  // instance of class ArrayList, holding objects of type Integer
  // (i.e., objects of a class that implements interface Integer)
  private ArrayList<Integer> _data;


  // default constructor
  // initializes instance variables
  public OrderedArrayList()
  {
    _data = new ArrayList<Integer>();
  }


  //pass-tru functionality
  public String toString()
  {
    return _data.toString();
  }

  /** The best case scenerio is that the index that is being removed is 0
      The worst case is that the index being removed is the last index. This
      is because remove is O(n) and uses linear search*/
  //pass-tru functionality
  public Integer remove( int index )
  {
    return _data.remove(index);
  }

  /** size is O(1) which means that it looks at the memory storage and returns
      the size, the point is moot. */
  //pass-tru functionality
  public int size()
  {
    return _data.size();
  }

  /** get is O(1) which means the point is moot. */
  //pass-tru functionality
  public Integer get( int index )
  {
    return _data.get(index);
  }

  /** add is O(n) because you must traverse through the entire array, there IS
      no worst case scenerio because you will always add the newVal to the end*/
  //modified functionality
  //insert at appropriate location to maintain sortedness
  public boolean add( Integer newVal )
  {
    //call exactly 1 of the helper methods below...  your favorite?

    addLinear(newVal);
    //addBinary(newVal);
    return true;
  }

  /** addLinear is generally O(n) because you will possibly traverse the entire array.
      the worst case scenerio is that the newVal is the new greatest value,
      because it would have to traverse the entire array to get to the correct
      index. The best case scenerio is that the new value is the new smallest
      value because the method will only have to traverse it one time, the best
      case is O(1), and the worst case is O(n)*/
  // inserts newVal at the appropriate index
  // maintains ascending order of elements
  // uses a linear search to find appropriate index
  public void addLinear(Integer newVal)
  {
    for( int p = 0; p < _data.size(); p++ ) {
      if ( newVal.compareTo( _data.get(p) ) < 0 ) {
        //newVal < oal[p]
        _data.add( p, newVal );
        return; //Q:why not break?
      }
    }
    _data.add( newVal ); //newVal > every item, so add to end
  }

  /** addBinary is generally O(logbase2 of n) because Binary Search uses
      logbase2 number of guesses for the worst case scenerio (which is the 
      beginning or end element) except for the best case scenerio which is the middle
      index is O(1) */
  // inserts newVal at the appropriate index
  // maintains ascending order of elements
  // uses a binary search to find appropriate index
  public void addBinary(Integer newVal)
  {
    //initialize high, low, midpt indices
    int lo = 0;
    int med = 0;
    int hi = _data.size()-1;

    while ( lo <= hi ) { //running until target is found or bounds cross

      med = (lo + hi) / 2;
      int x = _data.get(med).compareTo( newVal );

      if ( x == 0 ) {
        //equal value found, insert here
        _data.add( med, newVal );
        return;
      }
      else if ( x > 0 )
        //newVal < med, so look at lower half of data
        hi = med - 1;
      else
        //newVal > med, so look at upper half of data
        lo = med + 1;
    }
    // If you made it this far, newVal is not present.
    // So insert at lo.
    _data.add( lo, newVal );
    //Q: How do you know lo is correct insertion index?
  }


  // main method solely for testing purposes
  public static void main( String[] args )
  {

    OrderedArrayList franz = new OrderedArrayList();

    // testing linear search
    for( int i = 0; i < 15; i++ )
      franz.addLinear( (int)( 50 * Math.random() ) );
    System.out.println( franz );

    // testing binary search
    franz = new OrderedArrayList();
    for( int i = 0; i < 15; i++ )
      franz.addBinary( (int)( 50 * Math.random() ) );
    System.out.println( franz );

    /*-----v-------move-me-down-----------------v--------
      =====^====================================^=========*/

  }//end main()

}//end class OrderedArrayList
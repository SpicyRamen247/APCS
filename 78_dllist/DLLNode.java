// Team McDonalds$24MScam: Prattay Dey, Joshua Gao, Faiza Huda
// Ducks : Winnie, Batman, Truthful Tom, Huebert
// APCS pd08
// HW78 -- Double Up
// 2022-03-16
// time spent: 1.5 hrs
// KtS consumed: 2

/***
 * class DLLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class DLLNode
{
  //instance vars
  private DLLNode _prevNode;
  private String _cargo;
  private DLLNode _nextNode;

  // constructor
  public DLLNode( String value, DLLNode next, DLLNode prev)
  {
    _prevNode = prev;
    _cargo = value;
    _nextNode = next;
  }


  //--------------v  ACCESSORS  v--------------
  public DLLNode getPrev()
  {
    return _prevNode;
  }

  public String getCargo()
  {
    return _cargo;
  }

  public DLLNode getNext()
  {
    return _nextNode;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public DLLNode setPrev( DLLNode newPrev )
  {
    DLLNode foo = getPrev();
    _prevNode = newPrev;
    return foo;
  }


  public String setCargo( String newCargo )
  {
    String foo = getCargo();
    _cargo = newCargo;
    return foo;
  }

  public DLLNode setNext( DLLNode newNext )
  {
    DLLNode foo = getNext();
    _nextNode = newNext;
    return foo;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    return _cargo;
  }


  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    DLLNode first = new DLLNode( "cat", null, null );

    //Create a new node after the first
    first.setNext( new DLLNode( "dog", null, null ) );

    //Create a third node after the second
    first.getNext().setNext( new DLLNode( "cow", null, null ) );

    /* A naive list traversal, has side effects.... ??
       while( first != null ) {
       System.out.println( first );
       first = first.getNext();
       }
    */

    //Q: when head ptr moves to next node in list, what happens to the node it just left?
    //A: garbage collector reclaims that memory

    //  so, better: (w/o moving first)
    /*
    LLNode temp = first;
    while( temp != null ) {
      System.out.println( temp );
      temp = temp.getNext();
    }
    */

  }//end main

}//end class LLNode
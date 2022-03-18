// Team McDonalds$24MScam: Prattay Dey, Joshua Gao, Faiza Huda
// Ducks : Winnie, Batman, Truthful Tom, Huebert
// APCS pd08
// HW75 -- Nodal Recall
// 2022-03-13
// time spent: 1.0 hrs

/***
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 **/

public class LLNode
{
  //instance vars
  private String cargo;
  private LLNode node;

  // constructor
  public LLNode( String value, LLNode next )
  {
    cargo = value;
    node = next;
  }


  //--------------v  ACCESSORS  v--------------
  public String getCargo()
  {
    return cargo;
  }

  public LLNode getNext()
  {
    return node;
  }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  public String setCargo( String newCargo )
  {
    String temp = cargo;
    cargo = newCargo;
    return temp;
  }

  public LLNode setNext( LLNode newNext )
  {
    LLNode temp = node;
    node = newNext;
    return temp;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString()
  {
    String result = cargo;
    result += "[" + node + "]";
    return result;
  }


  //main method for testing
  public static void main( String[] args )
  {

    //Below is an exercise in creating a linked list...

    //Create a node
    LLNode first = new LLNode( "cat", null );

    //Create a new node after the first
    first.setNext( new LLNode( "dog", null ) );

    //Create a third node after the second
    first.getNext().setNext( new LLNode( "cow", null ) );

    /* A naive list traversal, has side effects.... ??
    */
       // while( first != null ) {
       // System.out.println( first );
       // first = first.getNext();
       // }

    //Q: when head ptr moves to next node in list, what happens to the node it just left?
    //A: The node it just left is no longer assigned to first, as seen when you print the value of first after moving to each next node

    //...so better: ?
    LLNode temp = first;
    while ( temp != null ){
      System.out.println(temp);
      temp = temp.getNext();
    }

  }//end main

}//end class LLNode
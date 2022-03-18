// Team McDonalds$24MScam: Prattay Dey, Joshua Gao, Faiza Huda
// Ducks : Winnie, Batman, Truthful Tom, Huebert
// APCS pd08
// HW78 -- Double Up
// 2022-03-16
// time spent: 1.5 hrs
// KtS consumed: 2

/*
DISCO:
- "Tail pointer" refers to pointing to the last node in the linked list, similar to _head pointing to the first node.

QCC
- DLLists seem much more convenient than LLists, as you can traverse nodes in both directions.
- In what situations would regular LLists be preferable over DLLists?

ALGO ADD
- If _size is 0, add the newVal as the first cargo.
- Else, traverse a copy of the original linked list until you reach the desired index.
- Save the cargo and nextNode in a DLLNode object before making any changes.
- Change the cargo of the node to newVal, point it to the node you just saved. Essentially shifts the nodes after index one to the right.
- Increment _size by 1 after new addition.

ALGO REM
- If index is 0, move _head pointer one place to the right.
- Traverse a copy of the original linked list until you reach the desired index-1.
- Save the original cargo value of index-1.
- Set the cargo of the node to the next's node's cargo.
- Point the node to the node after the next one (2 nodes down)
- Return original cargo value that was stored.
*/

public class LList implements List //your List interface must be in same dir
{

  //instance vars
  private DLLNode _head;
  private DLLNode _tail;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _tail = null;
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    DLLNode tmp = new DLLNode( newVal, _head, null );
    _head = tmp;
    if (tmp.getNext() != null){
      tmp.getNext().setPrev(tmp);
    }
    else{
      _tail = tmp;
    }
    _size++;
    return true;
  }


  public String get( int index )
  {
    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    String retVal;
    DLLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    DLLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

    //store target node's cargo
    String oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }


  //return number of nodes in list
  public int size() { return _size; }


  //insert a node containing newVal at position index
  public void add( int index, String newVal ) {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    DLLNode tmp = _head;

    //if empty, insert node before head node
    if ( _size == 0 )
	    add( newVal );
    else {

	    //traverse to node before desired index
	    for( int i=0; i < index; i++ )
      {
        tmp = tmp.getNext();
      }

      // saves original node, with prevNode pointing to tmp
      DLLNode original = new DLLNode(tmp.getCargo(), tmp.getNext(), tmp);

	    //insert new node and point it to original
	    tmp.setCargo( newVal );
	    tmp.setNext( original );

	    //increment size attribute
	    _size++;
    }
  }


  //remove node at pos index, return its cargo
  public String remove( int index ) {

    if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

    String retVal;

    DLLNode tmp = _head; //create alias to head

    //if index==0, remove head node
    if ( index == 0 ) {
	    //check target node's cargo hold
	    retVal = _head.getCargo();

	    //remove target node
	    _head = _head.getNext();
    }

    else {
	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ ) {
        tmp = tmp.getNext();
      }

	    //save target's cargo to return later
	    retVal = tmp.getNext().getCargo();

	    //remove target node and adjusts pointer
	    tmp.setNext( tmp.getNext().getNext() );
    }

    //decrement size attribute
    _size--;

    return retVal;
  }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    DLLNode tmp = _head; //init tr
    while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {

    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
    System.out.println( james );

    james.add(0,"whut");
    System.out.println( "...after add(0,whut): " );
    System.out.println( james );

    james.add(4,"phat");
    System.out.println( "...after add(4,phat): " );
    System.out.println( james );

    System.out.println( "...after remove last: "
                        + james.remove( james._size-1) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );

    System.out.println( "...after remove(0): " + james.remove(0) );
    System.out.println( james );
  }

}//end class LList
// Team Spanish Inquisition : Prattay Dey, Joshua Gao, Faiza Huda
// Ducks : Winnie, Batman, Truthful Tom, Huebert
// APCS pd08
// HW87 -- The English Do Not Wait In Line for Soup
// 2022-04-02
// time spent: 0.5 hr

/*
  DISCOS:
  - We can use LLNode as a nested class to access its methods.
  - We used a _front and a _back, which LList did not have.
  - Queue's are FIFO instead of FILO like stacks.

  QCCs:
  - It is important to maintain variable types. Ex: QUASAR
  - Is there a doubly-linked version of Queue?
*/

public class NodeQueue<QUASAR> implements Queue<QUASAR> {

  LLNode<QUASAR> _front, _back;
  int _size;

  //~~~~~~~~~~~~~~~~~~begin AP subset~~~~~~~~~~~~~~~~~~
   public NodeQueue(){
     _front = null;
     _back = null;
     _size = 0;
   }

   //means of removing an element from collection:
   //Dequeues and returns the first element of the queue.
   public QUASAR dequeue() {
     LLNode<QUASAR> tmp = _front;
     _front = _front.getNext();
     _size--;
     return tmp.getCargo();
   }

   //means of adding an element to collection:
   //Enqueue an element onto the back of this queue.
   public void enqueue( QUASAR x ) {
     LLNode<QUASAR> tmp = new LLNode<QUASAR>(x, null);
     if (_size == 0){
       _front = tmp;
       _back = tmp;
     }
     else{
       _back.setNext(tmp);
       _back = tmp;
     }
     _size++;
   }

   //Returns true if this queue is empty, otherwise returns false.
   public boolean isEmpty() {
       return _size == 0;
   }

   //Returns the first element of the queue without dequeuing it.
   public QUASAR peekFront() {
       return _front.getCargo();
   }

   //~~~~~~~~~~~~~~~~~~~end AP subset~~~~~~~~~~~~~~~~~~~

   //inner class
   private class LLNode<QUASAR>
   {
     //instance vars
     private QUASAR _cargo;
     private LLNode _nextNode;

     // constructor
     public LLNode( QUASAR value, LLNode next )
     {
       _cargo = value;
       _nextNode = next;
     }


     //--------------v  ACCESSORS  v--------------
     public QUASAR getCargo()
     {
       return _cargo;
     }

     public LLNode getNext()
     {
       return _nextNode;
     }
     //--------------^  ACCESSORS  ^--------------


     //--------------v  MUTATORS  v--------------
     public QUASAR setCargo( QUASAR newCargo )
     {
       QUASAR foo = getCargo();
       _cargo = newCargo;
       return foo;
     }

     public LLNode setNext( LLNode newNext )
     {
       LLNode foo = getNext();
       _nextNode = newNext;
       return foo;
     }
     //--------------^  MUTATORS  ^--------------


     // override inherited toString
     public String toString()
     {
       return _cargo.toString();
     }
   }

   public static void main(String[] args){
     NodeQueue<String> m = new NodeQueue<String>();
     m.enqueue("monke");
     m.enqueue("banana");
     m.enqueue("panda");
     System.out.println( m.peekFront() );
     m.dequeue();
     System.out.println( m.peekFront() );
   }
}
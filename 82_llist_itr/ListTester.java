public class ListTester
{
  public static void main( String[] args )
  {

    //instantiate... var type List, obj type LList
    List<String> wu = new LList<String>();

    System.out.println(wu);
    wu.add("RZA");

    System.out.println(wu);
    wu.add("GZA");

    System.out.println(wu);
    wu.add("ODB");

    System.out.println(wu);
    wu.add("Inspectah Deck");

    System.out.println(wu);
    wu.add("Raekwon the Chef");

    System.out.println(wu);
    wu.add("U-God");

    System.out.println(wu);
    wu.add("Ghostface");

    System.out.println(wu);
    wu.add("Method Man");

    System.out.println(wu);

    for( int i=0; i<7; i++ ) {
      int n = (int)( wu.size() * Math.random() );
      String imposter = "@";
      System.out.println("adding imposter at index " + n + "...");
      wu.add( n, imposter );
      System.out.println("Updated list: " + wu);
    }

    while( wu.size() > 0 ) {
      int n = (int)( wu.size() * Math.random() );
      System.out.println("deleting node "+ n + "...");
      wu.remove(n);
      System.out.println("Updated list: " + wu);
    }


    List<Integer> zu = new LList<Integer>();

    System.out.println(zu);
    zu.add(1);

    System.out.println(zu);
    zu.add(2);

    System.out.println(zu);
    zu.add(3);

    System.out.println(zu);
    zu.add(4);

    System.out.println(zu);
    zu.add(5);

    System.out.println(zu);
    zu.add(6);

    System.out.println(zu);
    zu.add(7);

    System.out.println(zu);
    zu.add(8);

    System.out.println(zu);
    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class

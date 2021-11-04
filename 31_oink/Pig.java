/***
 * /***
 * Joshua Gao 
 * APCS
 * HW31 -- Pig Latin
 * 2021-11-02
 * Time spent: 0.7
 * QCC
 * DISCO
 *
 * class Pig
 * a Pig Latin translator
 * ~~~~~~~~~~~~~~~~~~~ SKELETON ~~~~~~~~~~~~~~~~~~~
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]
 *      PROTIP: Make this class compilable first,
 *      then develop and test one method at a time.
 *      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
 ***/

public class Pig
{
  //Q: How does this initialization make your life easier?
  private static final String VOWELS = "aeiou";


  /*=====================================
    boolean hasA(String,String) -- checks for a letter in a String
    pre:  w != null, letter.length() == 1
    post: hasA("cat", "a") -> true
    hasA("cat", "p")       -> false
    =====================================*/
  public static boolean hasA( String w, String letter ) 
  {
    /* YOUR IMPLEMENTATION HERE */
    for (int i = 0; i < w.length(); i++) {
        if (w.substring(i, i+1).equals(letter)) {
            return true;
        }
    }
    return false;
  }//end hasA()


  /*=====================================
    boolean isAVowel(String) -- tells whether a letter is a vowel
    precondition: letter.length() == 1
    =====================================*/
  public static boolean isAVowel( String letter ) 
  {
    /* YOUR IMPLEMENTATION HERE */
    for (int i = 0; i < VOWELS.length(); i++) {
        if (VOWELS.substring(i, i + 1).equals(letter)) {
            return true;
        }
    }
    return false;
  }


  /*=====================================
    int countVowels(String) -- counts vowels in a String
    pre:  w != null
    post: countVowels("meatball") -> 3
    =====================================*/
  public static int countVowels( String w ) 
  {
    /* YOUR IMPLEMENTATION HERE */
    int counter = 0;
    for (int i = 0; i < w.length(); i++) {
        if (isAVowel(w.substring(i, i + 1))) {
            counter++;
        }
    }
    return counter;
  }


  /*=====================================
    boolean hasAVowel(String) -- tells whether a String has a vowel
    pre:  w != null
    post: hasAVowel("cat") -> true
    hasAVowel("zzz")       -> false
    =====================================*/
  public static boolean hasAVowel( String w ) 
  {
    /* YOUR IMPLEMENTATION HERE */
    if (countVowels(w) > 0) {
        return true;
    } else {
        return false;
    }
  }


  /*=====================================
    String allVowels(String) -- returns vowels in a String
    pre:  w != null
    post: allVowels("meatball") -> "eaa"
    =====================================*/
  public static String allVowels( String w ) 
  {
    /* YOUR IMPLEMENTATION HERE */
    String result = "";
    for (int i = 0; i < w.length(); i++) {
        if (isAVowel(w.substring(i, i + 1))) {
            result += w.substring(i, i + 1);
        }
    }
    return result;
  }


  public static void main( String[] args ) 
  {
    /* YOUR TEST CALLS HERE */
    System.out.println(hasA("abc", "c"));
    System.out.println(isAVowel("e"));
    System.out.println(countVowels("euiwajwou"));
    System.out.println(hasAVowel("bcdfgha"));
    System.out.println(allVowels("abecieutvduifgha"));
  }//end main()

}//end class Pig
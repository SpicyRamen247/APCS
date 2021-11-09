    /***
 * Ethay Eethray Edray Wsay (Ruby Friedman, Anjini Katari, Joshua Gao)
 * APCS
 * L00 -- Etterbay Odingcay Oughthray Ollaborationcay
 * 2021-11-09
 * time spent: 01.0 hrs
 *
 * class Pig
 * a Pig Latin translator
 *           9
 *     ,--.-'-,--.
 *     \  /-~-\  /
 *    / )' a a `( \
 *   ( (  ,---.  ) )
 *    \ `(_o_o_)' /
 *     \   `-'   /
 *      | |---| |
 *      [_]   [_]

DISCO:
 * Methods for finding number of spaces and number of vowels are very similar
 * If you have punctuation in your input but don't adjust your method to
   accomadate it, it will be treated like a consonant.


QCC:
 * How do you get a word after a space to go through the PL translator?
 * Can we create a pig latin translator without the use of the many helper
   methods we have?
 ***/


public class Pig {

	private static final String VOWELS = "aeiouyAEIOUY";
	private static final String space = " ";

	/**
	boolean hasA(String,String) -- checks for a letter in a String
	pre:  w != null, letter.length() == 1
	post: hasA("cat", "a") -> true
	hasA("cat", "p") -> false
	**/
	public static boolean hasA( String w, String letter ) {
		return w.indexOf(letter) != -1;
	}//end hasA()


	/**
	boolean isAVowel(String) -- tells whether a letter is a vowel
	precondition: letter.length() == 1
	**/
	public static boolean isAVowel( String letter ) {
		return VOWELS.indexOf( letter ) != -1;
	}


	/**
	int countVowels(String) -- counts vowels in a String
	pre:  w != null
	post: countVowels("meatball") -> 3
	**/
	public static int countVowels( String w ) {
		return allVowels(w).length();
	}

	/**
	boolean hasAVowel(String) -- tells whether a String has a vowel
	pre:  w != null
	post: hasAVowel("cat") -> true
	hasAVowel("zzz") -> false
	**/
  public static boolean hasAVowel( String w ) {
		if (countVowels(w) > 0) {
			return true;
		}
		else {
			return false;
		}
	}

	/**
	String allVowels(String) -- returns vowels in a String
	pre:  w != null
	post: allVowels("meatball") -> "eaa"
	**/
	public static String allVowels( String w ) {
		int counter = 0;
		String results = "";
		while (counter < w.length()) {
			if (isAVowel(w.substring(counter, counter+1)) == true) {
				results += w.substring(counter, counter+1);
			}
			counter += 1;
		}
		return results;
	}

	/**
	String firstVowel(String) -- returns first vowel in a String
	pre:  w != null
	post: firstVowel("") --> ""
	firstVowel("zzz") --> ""
	firstVowel("meatball") --> "e"
	**/
	public static String firstVowel( String w ) {
		String ans = "";
		if ( hasAVowel(w) ) //Q: Why this necess?
			ans = allVowels(w).substring(0,1);
		return ans;
	}


	/**
	boolean beginsWithVowel(String) -- tells whether a String begins with a vowel
	pre:  w != null and w.length() > 0
	post: beginsWithVowel("apple")  --> true
	beginsWithVowel("strong") --> false
	**/
	public static boolean beginsWithVowel( String w ) {
		return isAVowel( w.substring(0,1) );
	}


	/**
	String engToPig(String) -- converts an English word to Pig Latin
	pre:  w.length() > 0
	post: engToPig("apple")  --> "appleway"
	engToPig("strong") --> "ongstray"
	engToPig("java")   --> "avajay"
	**/
	public static String engToPigWord( String w ) {
		String ans = "";
		if ( beginsWithVowel(w) )
			ans = w + "way";
		else {
			int vPos = w.indexOf( firstVowel(w) );
			ans = w.substring(vPos) + w.substring(0,vPos) + "ay";
		}
		return ans;
	}
/**	public static String engToPigPhrase( String w ) {
		String ans = "";
		int spaceNumber = countSpaces(w);
		for (int i=0; i<spaceNumber+1; i++) {
			String word = w.substring(0, w.indexOf(" "));
			ans += engToPigWord(word);
                        if (w.indexOf(" ") != -1) {
				w = w.substring(w.indexOf(" ") +1);
				ans += " ";
			}
		}
		return ans;
	}

        public static int countSpaces( String w ) {
		int counter = 0;
                int results = 0;
                while (counter < w.length()) {
                        if (" ".equals((w.substring(counter, counter+1)))) {
                                results += 1;
                        }
                        counter += 1;
                }
                return results;
        }

*/
	public static void main( String[] args ) {
		for( String word : args ) {
			System.out.println( "allVowels \t" + allVowels(word) );
			System.out.println( "firstVowels \t" + firstVowel(word) );
			System.out.println( "countVowels \t" + countVowels(word) );
			System.out.println( "engToPig \t" + engToPigWord(word) );
//			System.out.println( "engToPig \t" + engToPigPhrase(word) );
			System.out.println( "---------------------" );
		}

	}//end main()

}//end class Pig
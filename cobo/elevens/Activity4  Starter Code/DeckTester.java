//KAFFEINE CIDS: ANJINI KATARI, YUKI FENG, JOSHUA GAO, DIANA AKHMEDOVA
//LAB07: ELEVENS!!
//APCS PD08
//2021-03-20
//time spent: 3.0 hrs

/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] ranks = {"jack", "queen", "king"};
		String[] suits = {"blue", "red"};
		int[] pointValues = {11, 12, 13};
		Deck d = new Deck(ranks, suits, pointValues);

		System.out.println("**** Original Deck Methods ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After 1 Card Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal Remaining 5 Cards ****");
		for (int i = 0; i < 5; i++) {
			System.out.println("  deal: " + d.deal());
		}
		System.out.println();
		System.out.println();

		System.out.println("**** Deck Methods After All Cards Dealt ****");
		System.out.println("  toString:\n" + d.toString());
		System.out.println("  isEmpty: " + d.isEmpty());
		System.out.println("  size: " + d.size());
		System.out.println();
		System.out.println();

		System.out.println("**** Deal a Card From Empty Deck ****");
		System.out.println("  deal: " + d.deal());
		System.out.println();
		System.out.println();

		String[] r = new String[52]; // ace = 1, jack = 11, queen = 12, king = 13 | rest are pv 
		String[] s = new String[52]; // first 13 = spades, hearts, diamonds, clubs
		int[] pv = new int[52]; //nums 1(ace) - 13(king) 

		for (int i=0; i<=51; i++) {
			String rank = "";
			String suit = "";
			//ace = 1
			if ( (i+1) % 13 ==1) {
				rank = "Ace"; 
			}
			//jack(11), queen(12), king(13)
			else if ( (i+1) % 13 ==11) {
				rank = "Jack"; 
			}

			else if ( (i+1) % 13 ==12) {
				rank = "Queen"; 
			}

			else if ( (i+1) % 13 ==0) {
				rank = "King"; 
			}
			//all the normal cards
			else {
				rank = Integer.toString((i+1) % 13);
			}

			//String []s
			if (i < 13) {
				suit = "Spades";
			}

			if (i < 26) {
				suit = "Hearts";
			}

			if (i < 39) {
				suit = "Diamonds";
			}

			else  {
				suit = "Clubs";
			}

			//update the deck
			r[i] = rank;
			s[i] = suit;
			pv[i] = ((i+1) % 13);

			//Create new deck
			Deck edith = new Deck (r, s, pv);
			System.out.println(edith);
	}
}

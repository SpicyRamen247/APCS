/**
<<<<<<< HEAD
TNPG: Watson vs The Final Project (Anjini Katari, Ruby Friedman, Joshua Gao)
APCS
HW56 -- Turing Training Wheels
2022-01-13
time spent: 1.5
 * It prioritizes the responses based on order it is written in the code.
   Since we defined 'black' before 'geese', no matter what order the two 
   words are in, we will always get the response to black.
 * 
 * When a keyword is found in another word, it will return with that 
   response. To fix this, you can be more specific, for example adding 
   spaces around the keyword.
 * 
=======
>>>>>>> 503b6b846f875a4d27a32df6aee9609627b4b68b
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		String response = "";
		if (statement.indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
<<<<<<< HEAD
		else if (statement.indexOf("dog") >= 0
				|| statement.indexOf("cat") >= 0)
		{
			response = "Tell me more about your pets.";
		}
		else if (statement.indexOf("Mykolyk") >= 0)		{
			response = "Omg, he's my favorite teacher!";
		}
		else if ((statement.trim()).length() == 0)		{
			response = "Say something, please";
		}
		else if (statement.indexOf("fun") >= 0)		{
			response = "That's kinda funny";
		}
		else if (statement.indexOf("black") >= 0)		{
			response = "Black like my soul";
		}
		else if (statement.indexOf("geese") >= 0)		{
			response = "Look at all those chickens!";
		}
=======
>>>>>>> 503b6b846f875a4d27a32df6aee9609627b4b68b
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 4;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
<<<<<<< HEAD
		else if (whichResponse == 4)
		{
			response = "That's cray.";
		}
		else if (whichResponse == 5)
		{
			response = "Bananas.";
		}
=======
>>>>>>> 503b6b846f875a4d27a32df6aee9609627b4b68b

		return response;
	}
}

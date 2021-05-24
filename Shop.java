// import classes
import java.util.ArrayList;

public class Shop extends Room
{

	private ArrayList<String> shopItems;

	// Constructor
	public Shop(String roomName, int locX, int locY, String description, ArrayList<String> items, ArrayList<String> shopItems)
	{
		super(roomName, locX, locY, description, items);
		this.shopItems = shopItems;
	}

	// getter
	public ArrayList<String> getShopItems()
	{
		return shopItems;
	}

	// setter
	public void setShopItems(ArrayList<String> shopItems)
	{
		this.shopItems = shopItems;
	}

	/* COPIED FUNCTIONS FROM ITEMS.JAVA */

	// thanks to StackOverflow
	private String checkVowel(String word)
	{
		if(Character.isLetter(word.charAt(0))) // check if char is a letter
		{
			if("AEIOUaeiou".indexOf(word.charAt(0)) != -1) // check if word has any vowels
			{
				return "an "; // return an is true
			}
			else
			{
				return "a "; // return a if false
			}
		}
		else // check if char is a number
		{
			return "";
		}
	} // end of checkVowel

	// output shop items to string, complete with punctuation 
	// and grammar
	public String toString()
	{
		// create variables for method
		ArrayList<String> convert = new ArrayList<String>();
		convert = shopItems;
		String output = checkVowel(convert.get(0)); // get a or an

		if(convert.size() > 1) // if we have multiple items
		{
			for(int i = 0; i < convert.size() - 1; i++)
			{
				output += convert.get(i) + ", "; // add commas between each item
			}

			// add an "and" for the last item in the list
			String lastWord = convert.get(convert.size() - 1);
			output += "and " + checkVowel(lastWord) + lastWord;
		}
		else // if we only have 1 item
		{
			output += "" + convert.get(0);
		}

		return output + " for sale here.";
	} // end of toString
} // end of class
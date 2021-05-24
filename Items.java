// import classes
import java.util.ArrayList;

/* 
   This class will enable the creation of items
   without having to create an entire ArrayList.

   IMPORTANT!!!
   In order to create multiple items, make sure 
   to separate the items with a comma and space!! (, )
*/

class Items
{
	// create variables
	private String name;
	private String items;

	// create constructor
	Items(String name, String items)
	{
		this.name = name;
		this.items = items;
	}

	// setters
	public void setName(String name) // set name
	{
		this.name = name;
	}

	public void setItems(String items) // set items
	{
		this.items = items;
	}

	// getters
	public String name() // get name
	{
		return name;
	}

	public ArrayList items() // get items
	{
		return _items(items);
	}

	// Convert String of items to ArrayList
	private ArrayList<String> _items(String items)
	{
		// create ArrayList 
		ArrayList<String> list = new ArrayList<String>(); // return ArrayList
		int startIndex = 0;  // starting index
		int endIndex = 0;    // ending index


		for(int i = 0; i < items.length() - 1; i++) // iterate through entire String
		{
			endIndex = i; // set ending index to current i
			if(items.charAt(i + 1) == ',') // check if i is separator
			{
				endIndex = i + 1; // set endIndex to char before separator
				list.add(items.substring(startIndex, endIndex)); // add item to ArrayList
				startIndex = i + 3; // set starting index to char after separator and continue
			}
			else if(i == items.length() - 2) // check if item is last
			{
				list.add(items.substring(startIndex)); // add last item
			}
		}

		return list; // return ArrayList
	}

	// thanks to StackOverflow
	private String checkVowel(String word)
	{
		if("AEIOUaeiou".indexOf(word.charAt(0)) != -1) // check if word has any vowels
		{
			return "an "; // return an is true
		}
		else
		{
			return "a "; // return a if false
		}
	} // end of checkVowel

	// output items list to string, complete with punctuation 
	// and grammar
	public String toString()
	{
		// create variables for method
		ArrayList<String> convert = new ArrayList<String>();
		convert = _items(items);
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

		return output + ".";
	} // end of toString
} // end of class
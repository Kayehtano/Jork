// import classes
import java.util.ArrayList;

/* 
   IMPORTANT!!!
   In order to list multiple items, make sure 
   to separate the items with a comma and space!! (, )
*/

public class Items
{
	// create variables
	private String items;

	// create constructor
	Items(String items)
	{
		this.items = items;
	}

	// setter
	public void setItems(String items) // set items
	{
		this.items = items;
	}

	// getter
	public ArrayList<String> items() // get items
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
	} // end of conversion method
} // end of class
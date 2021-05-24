// import classes
import java.util.ArrayList;

public class Room
{
	// create class variables
	private String roomName; // name
	
	// X and Y coordinates on the 2d array
	private int locX;
	private int locY;
	
	private String description;
	private ArrayList<String> items; // items

	// Construct room
	public Room(String roomName, int locX, int locY, String description, ArrayList<String> items)
	{
		this.roomName = roomName;
		this.locX = locX;
		this.locY = locY;
		this.description = description;
		this.items = items;
	}

	// Getters - get class values
	public String getName()
	{
		return roomName;
	}

	public String getDescription()
	{
		return description;
	}

	public String getLocation()
	{
		return "" + locX + ", " + locY;
	}
	
	public ArrayList<String> getItems()
	{
		return items;
	}

	// setters
	public void setName(String roomName)
	{
		this.roomName = roomName;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public void setLocation(int locX, int locY)
	{
		this.locX = locX;
		this.locY = locY;
	}

	public void setItems(ArrayList<String> items)
	{
		this.items = items;
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
		convert = items; // convert is set to ArrayList of items
		String output = this.roomName + "\n\n" + 
						this.description + "\n" + 
						"There is " + 
						checkVowel(convert.get(0)) + "\n";

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
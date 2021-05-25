// import classes
import java.util.ArrayList;

public class Room
{
	// create class variables
	private String roomName; // name
	
	private String description; // description
	private ArrayList<String> items; // items

	private String adjacentRooms; // parseable to get access to other rooms

	// Construct room
	public Room(String roomName, String description, ArrayList<String> items, String adjacentRooms)
	{
		this.roomName = roomName;
		this.description = description;
		this.items = items;
		this.adjacentRooms = adjacentRooms;
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
	
	public ArrayList<String> getItems()
	{
		return items;
	}

	// Setters
	public void setName(String roomName)
	{
		this.roomName = roomName;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public void setItems(ArrayList<String> items)
	{
		this.items = items;
	}

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

	// output items list to string, complete with punctuation 
	// and grammar
	public String toString()
	{
		// create variables for method
		ArrayList<String> convert = new ArrayList<String>();
		convert = items; // convert is set to ArrayList of items
		String output = this.roomName + "\n\n" + 
						this.description + "\n";

		if(!convert.get(0).equals("none"))
		{
			if(convert.size() > 1) // if we have multiple items
			{
				for(int i = 0; i < convert.size() - 1; i++)
				{
					output += convert.get(i) + ", "; // add commas between each item
				}

				// add an "and" for the last item in the list
				String lastWord = convert.get(convert.size() - 1);
				output += "and " + checkVowel(lastWord) + lastWord + ".";
			}
			else // if we only have 1 item
			{
				output += "" + convert.get(0) + ".";
			}
		}

		// add possible locations to move to
		// output += ;

		return output;
	} // end of toString
} // end of class
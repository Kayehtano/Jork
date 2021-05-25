// import classes
import java.util.ArrayList;

public class Room
{
	// create class variables
	private String roomName; // name
	
	private String description; // description
	private ArrayList<String> items; // items

	private String adjacentRooms; // parseable to get access to other rooms
	private String[][] roomData;

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

	// parse room (e.g. roomName, direction - )
	// direction is N, W, E, or S, and - separates rooms
	public void ParseRooms()
	{
		String parse = this.adjacentRooms;
		int startIndex = 0;
		int endIndex = 0;
		int counter = 0;
		
		for(int i = 0; i < parse.length(); i++) // find # of rooms
		{
			if(parse.charAt(i) == '|')
			{
				counter++;
			}
		}

		// System.out.println(counter); debug to find that the counter works
		// initialize data
		roomData = new String[2][counter + 1];
		int dataCounter = 0;

		for(int i = 0; i < parse.length() - 1; i++)
		{
			if(parse.charAt(i + 1) == ',') // get room name
			{
				endIndex = i + 1;
				roomData[0][dataCounter] = parse.substring(startIndex, endIndex);
				startIndex = i + 3;
			}
			else if(parse.charAt(i + 1) == '|') // get direction
			{
				endIndex = i + 1;
				roomData[1][dataCounter] = parse.substring(startIndex, endIndex);
				dataCounter++;
				startIndex = i + 3;
			}
			else if(i == parse.length() - 2) // if item is last in list
			{
				roomData[1][dataCounter] = parse.substring(startIndex);
				dataCounter++;
				startIndex = i + 3;
			}
		} // end for loop

		/* 
			Room data debug
			System.out.println(roomData[0][2]);
			System.out.println(roomData[1][2]);
		*/
	} // end function

	private String getRoomDirection(String e)
	{
		if(e.charAt(0) == 'N')
		{
			return "North";
		}
		else if(e.charAt(0) == 'S')
		{
			return "South";
		}
		else if(e.charAt(0) == 'W')
		{
			return "West";
		}
		else if(e.charAt(0) == 'E')
		{
			return "East";
		}
		return "null";
	}

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

		output += "\n\nThere is " + checkVowel(roomData[0][0]);

		// add possible locations to move to
		int numOfColumns = roomData[0].length;
		if(numOfColumns > 1) // check if we have more than one room
		{
			for(int i = 0; i < numOfColumns - 1; i++)
			{
				output += roomData[0][i] + " to the " + getRoomDirection(roomData[1][i]) + ", ";
			}

			output += "and " + checkVowel(roomData[0][numOfColumns - 1]) + roomData[0][numOfColumns - 1] + " to the " + getRoomDirection(roomData[1][numOfColumns - 1]) + ".";
		}
		else // if we only have 1 item
		{
			output += roomData[0][0] + " to the " + checkVowel(roomData[1][0]) + ".";
		}

		return output;
	} // end of toString
} // end of class
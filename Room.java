// import classes
import java.util.ArrayList;

public class Room
{
	// create class variables
	private String roomName; // name
	
	private String description; // description
	private ArrayList<String> items; // items

	// location
	private int locX;
	private int locY;

	// room code
	private String adjacentRooms;
	private String[][] roomData;

	// Construct room
	public Room(String roomName, String description, String adjacentRooms, int locX, int locY)
	{
		this.roomName = roomName;
		this.description = description;
		this.adjacentRooms = adjacentRooms;
		this.locX = locX;
		this.locY = locY;
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

	public String getAdjacentRooms()
	{
		return adjacentRooms;
	}

	public int getX()
	{
		return locX;
	}
	
	public int getY()
	{
		return locY;
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

	public void addItemToParent(String name)
	{
		this.items.add(name);
	}

	public void removeItemFromParent(String name)
	{
		this.items.remove(name);
	}

	public void clearItems()
	{
		this.items.clear();
	}

	// thanks to StackOverflow
	private String checkVowel(String word)
	{
		if(Character.isLetter(word.charAt(0))) // check if char is a letter
		{
			if(word.charAt(word.length() - 1) != 's') // check if word is not plural
			{
				if("AEIOUaeiou".indexOf(word.charAt(0)) != -1) // check if word has any vowels
				{
					return "is an "; // return an is true
				}
				else
				{
					return "is a "; // return a if false
				}
			}
			else
			{
				return "are ";
			}
		}
		else // check if char is a number
		{
			return "";
		}
	} // end of checkVowel

	// parse room (e.g. roomName, direction - )
	// direction is N, W, E, or S, and - separates rooms
	// convert String to 2d array
	public void ParseRooms()
	{
		// create parsing variables
		String parse = this.adjacentRooms;
		int startIndex = 0;
		int endIndex = 0;
		int counter = 0;
		
		// find # of rooms
		for(int i = 0; i < parse.length(); i++)
		{
			if(parse.charAt(i) == '|') // check for separator
			{
				// increase counter by 1
				counter++;
			}
		}

		// System.out.println(counter); debug to find that the counter works

		// initialize data
		roomData = new String[2][counter + 1];

		// initialize position couner
		int dataCounter = 0;

		// parse through String
		for(int i = 0; i < parse.length() - 1; i++)
		{
			if(parse.charAt(i + 1) == ',') // get room name
			{
				// set ending index to comma
				endIndex = i + 1;
				
				// grab name
				roomData[0][dataCounter] = parse.substring(startIndex, endIndex);

				// put start index after comma
				startIndex = i + 3;
			}
			else if(parse.charAt(i + 1) == '|') // get direction
			{
				// set end index to separator
				endIndex = i + 1;

				// grab direction
				roomData[1][dataCounter] = parse.substring(startIndex, endIndex);

				// increase column pos by 1
				dataCounter++;

				// put start index after separator
				startIndex = i + 3;
			}
			else if(i == parse.length() - 2) // if item is last in list
			{
				// grab last item direction
				roomData[1][dataCounter] = parse.substring(startIndex);

				// increase count by 1
				dataCounter++;
			}
		} // end for loop

		/* 
			Room data debug
			System.out.println(roomData[0][2]);
			System.out.println(roomData[1][2]);
		*/
	} // end function

	// private function to convert direction characters to full name
	private String getRoomDirection(String e)
	{
		if(e.charAt(0) == 'N')
		{
			return "north";
		}
		else if(e.charAt(0) == 'S')
		{
			return "south";
		}
		else if(e.charAt(0) == 'W')
		{
			return "west";
		}
		else if(e.charAt(0) == 'E')
		{
			return "east";
		}

		// if for whatever reason there is no direction
		return "null";
	}

	// output items list to string, complete with punctuation 
	// and grammar
	public String toString()
	{
		// item info
		// create variables for method
		ArrayList<String> convert = new ArrayList<String>();
		convert = items; // convert is set to ArrayList of items
		String output = this.roomName + "\n\n" + 
						this.description + "\n";

		if(convert != null && !convert.isEmpty())
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

		ParseRooms();

		// location info
		output += "\n\nThere " + checkVowel(roomData[0][0]);

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
			output += roomData[0][0] + " to the " + getRoomDirection(roomData[1][0]) + ".";
		}

		return output;
	} // end of toString
} // end of class
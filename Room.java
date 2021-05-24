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
} // end of class
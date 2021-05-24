import java.util.ArrayList;

class Room
{
	// create class variables
	private String roomName; // name
	private String location; // location
	private String description;
	private ArrayList items; // items

	// Construct room
	Room(String roomName, String location, String description, ArrayList<String> items)
	{
		this.roomName = roomName;
		this.location = location;
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
		return location;
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

	public void setLocation(String location)
	{
		this.location = location;
	}

	public void setItems(ArrayList<String> items)
	{
		this.items = items;
	}
}
// import
import java.util.ArrayList;

class Shop extends Room
{
	// variables
	ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	ArrayList<Armor> armor = new ArrayList<Armor>();

	public Shop(String roomName, String description, String adjacentRooms, int locX, int locY)
	{
		super(roomName, description, adjacentRooms, locX, locY);
	}
}
import java.util.ArrayList;

public class Alleyway extends Room
{
	private ArrayList<Item> potions = new ArrayList<Item>();

	public Alleyway(String roomName, String description, String adjacentRooms, int locX, int locY)
	{
		super(roomName, description, adjacentRooms, locX, locY);
	}
}
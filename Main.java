/*
░░░░░██╗░█████╗░██████╗░██╗░░██╗
░░░░░██║██╔══██╗██╔══██╗██║░██╔╝
░░░░░██║██║░░██║██████╔╝█████═╝░
██╗░░██║██║░░██║██╔══██╗██╔═██╗░
╚█████╔╝╚█████╔╝██║░░██║██║░╚██╗
░╚════╝░░╚════╝░╚═╝░░╚═╝╚═╝░░╚═╝

Welcome to Jork!

*/

// import classes
import java.util.ArrayList;

import javax.swing.*;

class Main
{
	public static Player Joe = new Player();

	public static String InGameName = "Joe"; // instantiate public name variable

	// map
	public static int mapSize = 10;
	public static Room[][] map = new Room[mapSize][mapSize];
	
	// player location
	public static int pLocX = 0;
	public static int pLocY = 0;

	public static Room currentRoom;

	public static void main(String[] args)
	{
		InitiateRooms();
		GetPlayerName();
		// OutputMap();

		Joe.AnalysePlayerInput("");
		Joe.setName(InGameName);
	}

	public static void GetPlayerName()
	{
		InGameName = JOptionPane.showInputDialog("What is your name, fellow adventurer?");

		if(InGameName == null || InGameName.isEmpty())
		{
			InGameName = "Joe"; // default name
		}
	} // end of GetPlayerName func

	// INIT ALL ITEMS
	public static void InitiateItems()
	{
		String instructions = "The Guide to Jork\n\n" + 
		"Welcome to Jork! Your end goal is to collect the  hidden treasure. Input only takes in a verb + noun (e.g. take book)";
	}

	// INIT ALL ROOMS
	public static void InitiateRooms()
	{
		// INITIALIZE ROOMS
		Room playerInv = new Room("Inventory", "", "", 9, 9);
		AddRoomToMap(playerInv);

		Room startingRoom = new Room("Room 1120", "A small room with a bed, table, and chair. On the table is a nameplate that reads: " + InGameName, "hallway, S", 0, 0);
		AddRoomToMap(startingRoom);
		
		currentRoom = startingRoom;
		
		Room southHallway = new Room("South Hallway", "A long, narrow hallway that connects the inn rooms to the other rooms. A bit of light creeps in from one side, probably from the lobby downstairs.", "Room 1120, N | lobby, E", 1, 0);
		AddRoomToMap(southHallway);

		Room lobby = new Room("The Vine Inn", "The lobby level of the inn. The inn also doubles as an adventurer's guild. You can find quests to do at the front desk, or you can walk around the city.", "stairs, W | exit, S", 1, 1);
		AddRoomToMap(lobby);

		Room innEntrance = new Room("Front of the Inn", "In front of you stands the famous inn and adventurer's guild named 'The Vine Inn'. It is famous for being backed by high-level adventurers. Around you, people are walking happily with rows of shops lined up in front of the buildings.", "guild/inn, N | street, W | street, E | street, S", 2, 1);
		AddRoomToMap(innEntrance);
		
		Room streetEnd1 = new Room("Street", "Buildings and various races of people surround you. It is loud as people walk around you trying to get by in life. The west end of the street is blocked by the city walls.", "inn entrance, E", 2, 0);
		AddRoomToMap(streetEnd1);

		Room street1 = new Room("Street", "Buildings and various races of people surround you. ", "inn entrance, W | street, E", 2, 2);
		AddRoomToMap(street1);

		Room street2 = new Room("Street", "Buildings and various races of people surround you. ", "street, W | equipment shop, N | street, E", 2, 3);
		AddRoomToMap(street2);

		Room streetEnd2 = new Room("Street", "Buildings and various races of people surround you. It is loud as people walk around you trying to get by in life. The east end of the street is blocked by the city walls.", "street, W | alleyway, S", 2, 4);
		AddRoomToMap(streetEnd2);

		Room street3 = new Room("Street", "Buildings and various races of people surround you.", "inn entrance, N | city gate, S", 3, 1);
		AddRoomToMap(street3);

		// INITIALIZE ACCESS
		startingRoom.addAccessibleRoom(southHallway);

		southHallway.addAccessibleRoom(startingRoom);
		southHallway.addAccessibleRoom(lobby);

		lobby.addAccessibleRoom(southHallway);
		lobby.addAccessibleRoom(innEntrance);

		innEntrance.addAccessibleRoom(lobby);
		innEntrance.addAccessibleRoom(streetEnd1);
		innEntrance.addAccessibleRoom(street1);
		innEntrance.addAccessibleRoom(street3);

		streetEnd1.addAccessibleRoom(innEntrance);

		street1.addAccessibleRoom(innEntrance);
		street1.addAccessibleRoom(street2);

		street2.addAccessibleRoom(street1);
		street2.addAccessibleRoom(streetEnd2);
		// street2.addAccessibleRoom(shop);

		streetEnd2.addAccessibleRoom(street2);
		// streetEnd2.addAccessibleRoom(alleyway);

		street3.addAccessibleRoom(innEntrance);
		// street3.addAccessibleRoom(cityGate);

		InitiateItems();

		// end init and begin game
		System.out.println("\n\n\n" + currentRoom.toString());
		Joe.setRoom(currentRoom);
	}

	// add room to map
	public static void AddRoomToMap(Room room)
	{
		if(map[room.getX()][room.getY()] == null)
		{
			map[room.getX()][room.getY()] = room;
			System.out.println("Added room " + room.getName() + " successfully!");
		}
		else
		{
			// debug if room is already full
			System.out.println("Couldn't add room " + room.getName() + ": Taken\n");
		}
	}

	// the player moves by switching between rooms on the 2d array
	public static void moveRooms(char direction)
	{
		// below is a chunk of code that works and i dont really know how
		int expectedX = 0;
		int expectedY = 0;
		switch(direction)
		{
			case('n'):
				expectedX = pLocX - 1;
				expectedY = pLocY;
				if(expectedX >= 0 && map[expectedX][expectedY] != null && currentRoom.getAccessibleRooms().contains(map[expectedX][expectedY]))
				{
					currentRoom = map[expectedX][expectedY];
					System.out.println(currentRoom.toString());
					pLocX = expectedX;
					pLocY = expectedY;
					Joe.setRoom(currentRoom);
				}
				else
				{
					System.out.println("You cannot go there.");
				}
				break;
			case('e'):
				expectedX = pLocX;
				expectedY = pLocY + 1;
				if(expectedY <= mapSize && map[expectedX][expectedY] != null && currentRoom.getAccessibleRooms().contains(map[expectedX][expectedY]))
				{
					currentRoom = map[expectedX][expectedY];
					System.out.println(currentRoom.toString());
					pLocX = expectedX;
					pLocY = expectedY;
					Joe.setRoom(currentRoom);
				}
				else
				{
					System.out.println("You cannot go there.");
				}
				break;
			case('s'):
				expectedX = pLocX + 1;
				expectedY = pLocY;
				if(expectedX <= mapSize && map[expectedX][expectedY] != null && currentRoom.getAccessibleRooms().contains(map[expectedX][expectedY]))
				{
					currentRoom = map[expectedX][expectedY];
					System.out.println(currentRoom.toString());
					pLocX = expectedX;
					pLocY = expectedY;
					Joe.setRoom(currentRoom);
				}
				else
				{
					System.out.println("You cannot go there.");
				}
				break;
			case('w'):
				expectedX = pLocX;
				expectedY = pLocY - 1;
				if(expectedY >= 0 && map[expectedX][expectedY] != null && currentRoom.getAccessibleRooms().contains(map[expectedX][expectedY]))
				{
					currentRoom = map[expectedX][expectedY];
					System.out.println(currentRoom.toString());
					pLocX = expectedX;
					pLocY = expectedY;
					Joe.setRoom(currentRoom);
				}
				else
				{
					System.out.println("You cannot go there.");
				}
				break;
		}
	}

	// map debugging purposes
	public static void OutputMap()
	{
		// IF ROOM IS TAKEN OUTPUT 'TAKEN'
		// IF ROOM IS NULL OUTPUT 'EMPTY'

		for(int i = 0; i < mapSize; i++)
		{
			for(int j = 0; j < mapSize; j++)
			{
				if(map[i][j] != null)
					System.out.print("taken ");
				else
					System.out.print("empty ");
			}
			System.out.println();
		}
	}
} // end of class
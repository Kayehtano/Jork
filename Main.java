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

	public static String InGameName = ""; // instantiate public name variable

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
		// GetPlayerName();
		Player Joe = new Player();
		Joe.AnalysePlayerInput("");
	}

	public static void GetPlayerName()
	{
		InGameName = JOptionPane.showInputDialog("What is your name, fellow adventurer?");

		if(InGameName == null || InGameName.isEmpty())
		{
			InGameName = "Joe"; // default name
		}
	} // end of GetPlayerName func

	// INIT ALL ROOMS
	public static void InitiateRooms()
	{
		// INITIALIZE ROOMS
		Room startingRoom = new Room("Room 1120", "A small room with a bed, table, and chair. On the table is a nameplate that reads: " + InGameName, "hallway, S", 0, 0);
		RefreshMap(startingRoom);
		
		currentRoom = startingRoom;
		
		Room southHallway = new Room("South Hallway", "A long, narrow hallway that connects the inn rooms to the other rooms. A bit of light creeps in from one side, probably from the tavern downstairs.", "Room 1120, N | lobby, E", 1, 0);
		RefreshMap(southHallway);

		Room lobby = new Room("The Vine Inn", "The lobby level of the inn. The inn also doubles as an adventurer's guild. You can find quests to do at the front desk, or you can walk around the city.", "stairs, W | exit, S", 1, 1);
		RefreshMap(lobby);

		Room innEntrance = new Room("Front of the Inn", "In front of you stands the famous inn and adventurer's guild named 'The Vine Inn'. It is famous for being backed by high-level adventurers. Around you, people are walking happily with rows of shops lined up in front of the buildings.", "guild/inn, N | street, W | street, E", 2, 1);
		RefreshMap(innEntrance);

		// INITIALIZE ACCESS
		startingRoom.addAccessibleRoom(southHallway);
		southHallway.addAccessibleRoom(startingRoom);
		southHallway.addAccessibleRoom(lobby);
		lobby.addAccessibleRoom(southHallway);
		lobby.addAccessibleRoom(innEntrance);
		innEntrance.addAccessibleRoom(lobby);

		// end init and begin game
		System.out.println(currentRoom.toString());
	}

	// add room to map
	public static void RefreshMap(Room room)
	{
		map[room.getX()][room.getY()] = room;
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
				}
				else
				{
					System.out.println("You cannot go there.");
				}
				break;
		}
	}
} // end of class
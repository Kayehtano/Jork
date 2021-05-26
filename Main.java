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
		Room startingRoom = new Room("Room 1120", "A small room with a bed, table, and chair. On the table is a nameplate that reads: " + InGameName, "hallway, S", 0, 0);
		RefreshMap(startingRoom);
		currentRoom = startingRoom;
		
		Room southHallway = new Room("South Hallway", "A long, narrow hallway that connects the inn rooms to the other rooms. A bit of light creeps in from one side, probably from the tavern downstairs.", "Room 1120, N | tavern, E", 1, 0);
		RefreshMap(southHallway);

		Room tavern = new Room("The Vine Inn", "A long, narrow hallway that connects the inn rooms to the other rooms. A bit of light creeps in from one side, probably from the tavern downstairs.", "stairs, W | exit, S", 1, 1);
		RefreshMap(tavern);

		System.out.println(currentRoom.toString());
	}

	public static void RefreshMap(Room room)
	{
		System.out.println();
		map[room.getX()][room.getY()] = room;

		// for(int i = 0; i < map.length; i++)
		// {
		// 	for(int j = 0; j < map[i].length; j++)
		// 	{
		// 		if(map[i][j] != null)
		// 			System.out.print(map[i][j].getName() + " ");
		// 		else
		// 			System.out.print("null ");
		// 	}
		// 	System.out.println();
		// }
	}

	// the player moves by switching between rooms on the 2d array
	public static void moveRooms(char direction)
	{
		int expectedX = 0;
		int expectedY = 0;
		switch(direction)
		{
			case('n'):
				expectedX = pLocX - 1;
				expectedY = pLocY;
				if(expectedX >= 0 && map[expectedX][expectedY] != null)
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
				if(expectedY <= mapSize && map[expectedX][expectedY] != null)
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
				if(expectedX <= mapSize && map[expectedX][expectedY] != null)
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
				if(expectedY >= 0 && map[expectedX][expectedY] != null)
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
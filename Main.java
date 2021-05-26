/*
░░░░░██╗░█████╗░██████╗░██╗░░██╗
░░░░░██║██╔══██╗██╔══██╗██║░██╔╝
░░░░░██║██║░░██║██████╔╝█████═╝░
██╗░░██║██║░░██║██╔══██╗██╔═██╗░
╚█████╔╝╚█████╔╝██║░░██║██║░╚██╗
░╚════╝░░╚════╝░╚═╝░░╚═╝╚═╝░░╚═╝

Welcome to Jork!

Things to know:
When creating rooms, make sure to instantiate items BEFORE the room.
If the room has no items, enter 'none'.

*/
// import classes
import java.util.ArrayList;

import javax.swing.*;

class Main
{

	public static String InGameName = ""; // instantiate public name variable

	// map
	public static int mapSize = 10;
	public static int[][] map = new int[mapSize][mapSize];
	
	// player location
	public static int pLocX;
	public static int pLocY;

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

		Room southHallway = new Room("South Hallway", "A long, narrow hallway that connects the inn rooms to the other rooms. A bit of light creeps in from one side, probably from the tavern downstairs.", "Room 1120, N | tavern, E", 1, 0);
		RefreshMap(southHallway);
	}

	public static void RefreshMap(Room room)
	{
		System.out.println();
		map[room.getX()][room.getY()] = 1;

		// for(int i = 0; i < map.length; i++)
		// {
		// 	for(int j = 0; j < map[i].length; j++)
		// 	{
		// 		System.out.print(map[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
	}

	public static void moveRooms(char direction)
	{
		int expectedX = 0;
		int expectedY = 0;
		switch(direction)
		{
			case('n'):
				expectedX = pLocX - 1;
				expectedY = pLocY;
				if(expectedY > -1 && map[expectedX][expectedY] != 0)
				{
					System.out.println("Can move");
				}
				else
				{
					System.out.println("You cannot go there.");
				}
				break;
			case('e'):
				expectedX = pLocX;
				expectedY = pLocY + 1;
				if(expectedY <= mapSize - 1 && map[expectedX][expectedY] != 0)
				{
					System.out.println("Can move");
				}
				else
				{
					System.out.println("You cannot go there.");
				}
				break;
			case('s'):
				expectedX = pLocX + 1;
				expectedY = pLocY;
				if(expectedX <= mapSize - 1 && map[expectedX][expectedY] != 0)
				{
					System.out.println("Can move");
				}
				else
				{
					System.out.println("You cannot go there.");
				}
				break;
			case('w'):
				expectedX = pLocX;
				expectedY = pLocY - 1;
				if(expectedY > -1 && map[expectedX][expectedY] != 0)
				{
					System.out.println("Can move");
				}
				else
				{
					System.out.println("You cannot go there.");
				}
				break;
		}
	}
} // end of class
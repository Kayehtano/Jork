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

	public static void main(String[] args)
	{
		InitiateItemsAndRooms();
		GetPlayerName();

		getPlayerInput("TEST");
	}

	public static void GetPlayerName()
	{
		InGameName = JOptionPane.showInputDialog("What is your name, fellow adventurer?");

		if(InGameName == null || InGameName.isEmpty())
		{
			InGameName = "Joe"; // default name
		}
	} // end of GetPlayerName func

	// INIT ALL ITEMS AND ROOMS
	public static void InitiateItemsAndRooms()
	{
		Items _PlayerRoom = new Items("rusty knife, cloak of disguise, 50 gold coins");
		Room PlayerRoom = new Room("Room 1120", "A small, decrepit room with a hard bed, wooden chair, and a dripping ceiling.", _PlayerRoom.items(), "Inn Hallway, S");
		PlayerRoom.ParseRooms();

		Items _InnHallway = new Items("none");
		Room InnHallway = new Room("Hallway", "A long hallway that connects all of the tenants'. The floor here is surprisingly kept clean. A door that reads, '" + InGameName + "'", _InnHallway.items(), "Room 1120, N | Stairs, W");
		InnHallway.ParseRooms();
	}

	// Get player input
	public static void getPlayerInput(String question)
	{
		// contain answer into String
		String answer = JOptionPane.showInputDialog(question);

		// make array list and variables that will contain the words
		ArrayList<String> words = new ArrayList<String>();
		int startIndex = 0;
		int endIndex = 0;
		
		// parse answer 
		// iterate through answer to get words
		for(int i = 0; i < answer.length() - 1; i++)
		{
			if(answer.charAt(i + 1) == ' ') // finds space
			{
				// set end index
				endIndex = i + 1;

				// add to words ArrayList
				words.add(answer.substring(startIndex, endIndex));

				// set start index
				startIndex = i + 2;
			}
			else if(i == answer.length() - 2) // if its the last word
			{
				words.add(answer.substring(startIndex));
			}
		}

		// analyse
		String action = words.get(0); // first word is action
		switch(action)
		{
			case "move":
				MoveRooms();
			case "look":
				LookAround();
			case "inventory":
				OpenInventory();
			case "attack":
				Attack();
			case "speak":
				SpeakTo();
		}
	}
} // end of class
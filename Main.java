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
import javax.swing.*;

class Main
{
	public static void main(String[] args)
	{
		GetPlayerName();

		Items _PlayerRoom = new Items("rusty knife, cloak of disguise, 50 gold coins");
		Room PlayerRoom = new Room("Inn of Cavv, Room 1120", 2, 2, "A small, decrepit room with a hard bed, wooden chair, and a dripping ceiling.", _PlayerRoom.items());

		System.out.println(PlayerRoom.toString());
	}

	public static void GetPlayerName()
	{
		String InGameName = ""; // instantiate name variable

		InGameName = JOptionPane.showInputDialog("What is your name, adventurer?");
		if(InGameName == null || InGameName.isEmpty())
		{
			InGameName = "Joe"; // default name
		}
	} // end of GetPlayerName func

	public static void makeMap()
	{
		int[][] TownOfCavv = new int[][]
		{
			{0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0},
			{0, 0, 1, 0, 0},
			{0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0},
		};
	}
} // end of class
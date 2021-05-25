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

	// analyser will split input into 3 variables
	public static String verb;
	public static String directObject;
	public static String indirectObject;

	public static void main(String[] args)
	{
		// InitiateItemsAndRooms();
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

	// INIT ALL ITEMS AND ROOMS
	public static void InitiateItemsAndRooms()
	{
		
	}
} // end of class
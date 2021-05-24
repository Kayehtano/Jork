import javax.swing.*;

class Main
{
	public static void main(String[] args)
	{
		GetPlayerName();
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
} // end of class
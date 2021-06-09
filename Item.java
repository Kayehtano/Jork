// import classes
import java.util.ArrayList;
import javax.swing.*;

public class Item
{
	// object name
	private String name;

	// the description of the object
	private String description;

	// constructor
	public Item(String name, String description)
	{
		this.name = name;
		this.description = description;
	}

	// getters
	public String getName()
	{
		return name;
	}

	public String getDescription()
	{
		return description;
	}

	public boolean canPickup()
	{
		return pickup;
	}

	// setters
	public void setName(String name)
	{
		this.name = name;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}
// import classes
import java.util.ArrayList;
import javax.swing.*;

public class Item
{
	// object name
	private String name;

	// parent object
	private Room parent;

	// synonyms for object (object can be referenced by these words too)
	private String synonyms;

	// the description of the object
	private String description;

	// can you pick this item up
	private boolean pickup;

	// constructor
	public Item(String name, Room parent, String synonyms, String description, boolean pickup)
	{
		this.name = name;
		this.parent = parent;
		this.synonyms = synonyms;
		this.description = description;
		this.pickup = pickup;
	}

	// getters
	public String getName()
	{
		return name;
	}

	public Object getParent()
	{
		return parent;
	}

	public String getSynonyms()
	{
		return synonyms;
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

	public void setParent(Room parent)
	{
		this.parent = parent;
	}

	public void setSynonyms(String synonyms)
	{
		this.synonyms = synonyms;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public void setPickup(boolean pickup)
	{
		this.pickup = pickup;
	}
}
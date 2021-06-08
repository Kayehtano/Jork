// import classes
import java.util.ArrayList;
import javax.swing.*;

public class Item
{
	// object name
	private String name;

	// parent object
	private Object parent;

	// synonyms for object (object can be referenced by these words too)
	private String synonyms;

	// the description of the object
	private String description;

	// can you pick this item up
	private boolean pickup;

	// can you move this item
	private boolean moveable;

	// constructor
	public Item(String name, Object parent, String synonyms, String description, boolean pickup, boolean moveable)
	{
		this.name = name;
		this.parent = parent;
		this.synonyms = synonyms;
		this.description = description;
		this.pickup = pickup;
		this.moveable = moveable;
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

	public boolean canMove()
	{
		return moveable;
	}

	// setters
	public void setName(String name)
	{
		this.name = name;
	}

	public void setParent(Object parent)
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

	public void setMove(boolean move)
	{
		this.moveable = move;
	}

	private boolean isParentPlayer()
	{
		// check if parent is player
		if(parent instanceof Player)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	
}
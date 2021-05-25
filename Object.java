// import classes
import java.util.ArrayList;
import javax.swing.*;

public class Object
{
	// object name
	private String name;

	// parent object/room
	private String parent;

	// synonyms for object
	private ArrayList<String> synonyms;

	// adjectives for object (object can be referenced with these words as well)
	private String adjectives;

	// the description of the object
	private String description;

	// can you pick this item up
	private boolean pickup;

	// can you move this item
	private boolean moveable;

	// weapon attributes
	private boolean isWeapon;
	private float damage;

	public Object(String name, String parent, ArrayList<String> synonyms, String adjectives, String description, boolean pickup, boolean moveable)
	{
		this.name = name;
		this.parent = parent;
		this.synonyms = synonyms;
		this.adjectives = adjectives;
		this.description = description;
		this.pickup = pickup;
		this.moveable = moveable;
	}

	// getters
	public String getName()
	{
		return name;
	}

	public String getParent()
	{
		return parent;
	}

	public ArrayList<String> getSynonyms()
	{
		return synonyms;
	}

	public String getAdjectives()
	{
		return adjectives;
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

	public void setParent(String parent)
	{
		this.parent = parent;
	}

	public void setSynonyms(ArrayList<String> synonyms)
	{
		this.synonyms = synonyms;
	}
	
	public void setAdjectives(String adjectives)
	{
		this.adjectives = adjectives;
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
}
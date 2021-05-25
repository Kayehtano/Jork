// import classes
import java.util.ArrayList;
import javax.swing.*;

class Player
{
	private int health = 100;
	private int level = 1;
	private double weightLimit = 10.0;
	private ArrayList<String> inventory;
	private float damage = 5.0f; // 5.0 is base damage
	private String status = "";
	private Object currentWeapon;

	// essential words
	public static String verb;
	public static String directObject;
	public static String indirectObject;

	public Player()
	{
		this.health = 100;
		this.level = 1;
		this.weightLimit = 10.0;
		this.inventory = null;
		this.damage = 5.0f;
		this.status = "";
		this.currentWeapon = null;
	}

	public Player(int health, int level, double weightLimit, ArrayList<String> inventory, float damage, String status, Object currentWeapon)
	{
		this.health = health;
		this.level = level;
		this.weightLimit = weightLimit;
		this.inventory = inventory;
		this.damage = damage;
		this.status = status;
		this.currentWeapon = currentWeapon;
	}

	// GETTERS
	public int getHP()
	{
		return health;
	}

	public int getLevel()
	{
		return level;
	}

	public double getWeightLimit()
	{
		return weightLimit;
	}

	public ArrayList<String> getInventory()
	{
		return inventory;
	}

	public float getDamage()
	{
		return damage;
	}

	public String getStatus()
	{
		return status;
	}

	public String getCurrentWeapon()
	{
		return currentWeapon.getName();
	}

	// SETTERS
	public void setHP(int health)
	{
		this.health = health;
	}

	public void setLevel(int level)
	{
		this.level = level;
	}

	public void setWeightLimit(double weightLimit)
	{
		this.weightLimit = weightLimit;
	}

	public void setInventory(ArrayList<String> inventory)
	{
		this.inventory = inventory;
	}

	public void setDamage(float damage)
	{
		this.damage = damage;
	}
	
	/* ----- PARSER CODE ----- */

	// Analyse player input
	public void AnalysePlayerInput(String question)
	{
		// contain answer into String
		String answer = "";
		while(answer == null || answer.isEmpty())
			answer = JOptionPane.showInputDialog(question);

		// make variables that will contain the words
		ArrayList<String> list = new ArrayList<String>();
		int startIndex = 0;
		int endIndex = 0;



		// --- ACCEPTED WORDS --- //
		ArrayList<String> verbs = new ArrayList<String>();
		// offensive verbs
		verbs.add("attack");
		verbs.add("slash");
		verbs.add("burn");

		// environment verbs
		verbs.add("look");
		verbs.add("inventory");
		verbs.add("buy");
		verbs.add("get");
		verbs.add("take");
		verbs.add("drop");
		verbs.add("throw");

		// move
		verbs.add("move");
		verbs.add("go");

		// extra
		verbs.add("read");
		verbs.add("diagnose");

		// parse answer 
		for(int i = 0; i < answer.length() - 1; i++)
		{
			endIndex = i;
			if(answer.charAt(i + 1) == ' ')
			{
				endIndex = i + 1;
				list.add(answer.substring(startIndex, endIndex));
				startIndex = i + 2;
			}
			else if(i == answer.length() - 2) 
			{
				list.add(answer.substring(startIndex));
			}
		}

		// analyse words
		for(int i = 0; i < list.size(); i++)
		{
			System.out.println(list.get(i));
		}

		if(verbs.contains(list.get(0)))
		{
			verb = list.get(0); // verb is first word
			switch(verb)
			{
				case("move"):
				case("go"):
					// Move();
				case("attack"):
				case("slash"):
					// Attack();
				case("burn"):
					// burn?
				case("look"):
					// LookAround();
				case("inventory"):
					openInventory();
					break;
				case("get"):
				case("take"):
					// takeObject();
				case("drop"):
				case("throw"):
					// dropObject();
				case("read"):
					// readObject();
				case("buy"):
					// shop
				case("diagnose"):
					if(list.size() == 1)
						refreshStatus();
						break;
			}
			System.out.println("\n\n");
			AnalysePlayerInput(" ");
		}
		else
		{
			System.out.println("I do not recognize that verb.");
			AnalysePlayerInput(" ");
		}

		//System.out.println(verb + ", " + directObject + ", " + indirectObject);
	} // end of parser

	public void moveTo(String destination)
	{

	}

	public void openInventory()
	{
		if(inventory != null && inventory.size() > 0)
		{
			System.out.println("You are holding: \n");
			for(String item : inventory)
			{
				System.out.println(item);
			}
		}
		else
		{
			System.out.println("You currently have nothing. You won't get anywhere like this.");
		}
	}

	public void refreshStatus()
	{
		if(health >= 90)
		{
			this.status = "You are healthy.\nYou can be killed by a well-placed hit.";
		}
		else if(health >= 70)
		{
			this.status = "You are hurt.\nYou have some bruises and cuts, but I think you should not take any more damage.";
		}
		else if(health >= 40)
		{
			this.status = "Your condition is serious.\nI recommend seeing a doctor as soon as possible.";
		}
		else if(health >= 20)
		{
			this.status = "You are close to death.\nYour future is grim, you have a slim chance of surviving.";
		}
		else if(health >= 1)
		{
			this.status = "You are at death's door.";
		}
		else
		{
			this.status = "You are dead.";
		}
		System.out.println("Current status:\n" + status);
	}
}
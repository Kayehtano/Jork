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
	private String status;
	private Object currentWeapon;

	// essential words
	public static String verb;
	public static String directObject;
	public static String indirectObject;

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

	public void setStatus()
	{
		if(health >= 90)
		{
			this.status = "You are healthy.\nYou can be killed by a well-placed hit.";
		}
		else if(health >= 70)
		{
			this.status = "You are hurt.\nYou have some bruises and cuts, but I think you should not take any more damage.";
		}
	}
	
	/* ----- PARSER CODE ----- */

	// Analyse player input
	public static void AnalysePlayerInput(String question)
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

		// move
		verbs.add("move");
		verbs.add("go");

		// extra
		verbs.add("read");

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


		System.out.println(verb + ", " + directObject + ", " + indirectObject);
	}
}
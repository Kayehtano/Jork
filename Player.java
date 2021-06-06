// import classes
import java.util.ArrayList;
import javax.swing.*;

class Player
{
	private String name;
	private int health = 100;
	private int level = 1;
	private double weightLimit = 10.0;
	private ArrayList<Item> inventory;
	private float damage = 5.0f; // 5.0 is base damage
	private String status = "";
	private Item currentWeapon;
	private Room currentRoom;

	// essential variables
	public static String verb;
	public static String directObject;
	public static String indirectObject;
	public ArrayList<String> list = new ArrayList<String>();

	private int dumdummeter = 0;

	// constructors
	public Player()
	{
		this.name = "Joe";
		this.health = 100;
		this.level = 1;
		this.weightLimit = 10.0;
		this.inventory = null;
		this.damage = 5.0f;
		this.status = "";
		this.currentWeapon = null;
	}

	public Player(String name, int health, int level, double weightLimit, ArrayList<Item> inventory, float damage, String status, Item currentWeapon)
	{
		this.name = name;
		this.health = health;
		this.level = level;
		this.weightLimit = weightLimit;
		this.inventory = inventory;
		this.damage = damage;
		this.status = status;
		this.currentWeapon = currentWeapon;
	}

	// GETTERS
	public String getName()
	{
		return name;
	}

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

	public ArrayList<Item> getInventory()
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

	public Room getRoom()
	{
		return currentRoom;
	}

	// SETTERS
	public void setName(String name)
	{
		this.name = name;
	}

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

	public void addToInventory(Item item)
	{
		this.inventory.add(item);
	}

	public void setDamage(float damage)
	{
		this.damage = damage;
	}

	public void setRoom(Room room)
	{
		this.currentRoom = room;
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
		int startIndex = 0;
		int endIndex = 0;
		list.clear();

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

		// --- ACCEPTED PREPOSITIOS --- //
		ArrayList<String> preps = new ArrayList<String>();

		preps.add()

		// letter
		if(answer.length() < 2)
		{
			System.out.println(answer);
			System.out.println("... What?\n\n");
			AnalysePlayerInput("");
		}

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
			System.out.print(list.get(i) + " ");
		}
		
		System.out.println();

		// return if there's only one word
		if(list.size() < 2)
		{
			System.out.println("... What?\n\n");
			AnalysePlayerInput("");
		}
		
		// get indirect object
		if(list.size() > 2 && list.get(1).equals("the") || list.get(1).equals("to"))
		{
			// second word is considered preposition
			indirectObject = list.get(2);
		}
		else
		{
			indirectObject = list.get(1);
		}


		if(verbs.contains(list.get(0)))
		{
			dumdummeter = 0;
			verb = list.get(0); // verb is first word
			switch(verb)
			{
				case("move"):
				case("go"):
					moveTo();
				case("attack"):
				case("slash"):
					// Attack();
					break;
				case("burn"):
					// burn?
					break;
				case("look"):
					if(list.size() == 1 || list.get(1).equals("around"))
					{
						System.out.println(currentRoom.toString());
					}
					else
					{
						System.out.println("I only understood as far as having to look somewhere.");
						break;
					}
					break;
				case("inventory"):
					openInventory();
					break;
				case("get"):
				case("take"):
					// takeObject();
					break;
				case("drop"):
				case("throw"):
					// dropObject();
					break;
				case("read"):
					// readObject();
					break;
				case("buy"):
					// shop
					break;
				case("diagnose"):
					if(list.size() == 1)
					{
						refreshStatus();
						break;
					}
					else
					{
						System.out.println("I only understand myself.");
						break;
					}
			}
		}
		else
		{
			// had some funny
			if(dumdummeter > 14)
			{
				System.out.println("Ok, bro that's not funny anymore pls stop. >:(");
			}
			else if(dumdummeter > 9)
			{
				System.out.println("If you need help, why don't you read the manual?");
			}
			else if(dumdummeter > 4)
			{
				System.out.println("Oi, oi, do you know what to do?");
			}
			else
			{
				System.out.println("I do not recognize that verb.");
			}
			dumdummeter++;
		}
		System.out.println("\n\n");
		AnalysePlayerInput("");
		//System.out.println(verb + ", " + directObject + ", " + indirectObject);
	} // end of parser

	public void moveTo()
	{
		if(list.size() == 2)
		{
			String destination = list.get(1);
			switch(destination)
			{
				case("west"):
				case("w"):
					Main.moveRooms('w');
					break;
				case("south"):
				case("s"):
					Main.moveRooms('s');
					break;
				case("north"):
				case("n"):
					Main.moveRooms('n');
					break;
				case("east"):
				case("e"):
					Main.moveRooms('e');
					break;
				default:
					System.out.println("... where now?");
			}
		}
		else if(list.size() > 2)
		{
			System.out.println("I only understand 'move' or 'go' to a specific direction.");
		}
		else
		{
			System.out.println("I could not understand what you are trying to say.");
		}
	}

	public void openInventory()
	{
		if(inventory != null && inventory.size() > 0)
		{
			System.out.println("You are holding: \n");
			for(Item item : inventory)
			{
				System.out.println(item.getName());
			}
		}
		else
		{
			System.out.println("You currently have nothing. At least have a sword or something.");
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
		System.out.println("Current status:\n\n" + 
						   "Name: " + name + "\n" +
						   "Level: " + this.level +
						   "\n\n" + status);
	}
}
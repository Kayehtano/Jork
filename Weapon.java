public class Weapon extends Item
{
	private double damageMultiplier;
	private int durability;

	// constructors
	public Weapon(String name, Room parent, String synonyms, String adjectives, String description, boolean pickup, boolean moveable, double damageMultiplier, int durability)
	{
		super(name, parent, synonyms, description, pickup, moveable);
		this.damageMultiplier = damageMultiplier;
		this.durability = durability;
	}

	// getter
	public double getMultiplier()
	{
		return damageMultiplier;
	}

	public int getDurability()
	{
		return durability;
	}

	// setter
	public void setMultiplier(double multiplier)
	{
		this.damageMultiplier = multiplier;
	}

	public void setDurability(int durability)
	{
		this.durability = durability;
	}
}
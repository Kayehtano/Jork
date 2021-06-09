class Weapon extends Item
{
	// variables
	private float damage;
	private int cost;

	public Weapon(String name, String description, float damage, int cost)
	{
		super(name, description);
		this.damage = damage;
		this.cost = cost;
	}

	// getters/setters
	public float getDamage()
	{
		return damage;
	}

	public int getCost()
	{
		return cost;
	}

	public void setDamage(float damage)
	{
		this.damage = damage;
	}

	public void setCost(int cost)
	{
		this.cost = cost;
	}
}
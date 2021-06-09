class Weapon extends Item
{
	// variables
	private float damage;

	public Weapon(String name, Room parent, String synonyms, String description, boolean pickup, float damage)
	{
		super(name, parent, synonyms, description, pickup);
		this.damage = damage;
	}

	// getters/setters
	public float getDamage()
	{
		return damage;
	}

	public void setDamage(float damage)
	{
		this.damage = damage;
	}
}
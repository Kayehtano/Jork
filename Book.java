class Book extends Item
{
	private String contents;

	public Book(String name, Room parent, String synonyms, String description, boolean pickup, boolean moveable, String contents)
	{
		super(name, parent, synonyms, description, pickup, moveable);
		this.contents = contents;
	}

	// getter
	public String getContents()
	{
		return contents;
	}

	// setter
	public void setContents(String newContents)
	{
		
	}
}
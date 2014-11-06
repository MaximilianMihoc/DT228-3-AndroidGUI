package ie.dit.maximilian.mihoc;

public class Item 
{
	private String name;
	private float price;
	private String description;
	private int imageSrc;
	private int quantity; //number in stock
	

	/*public Item(String name, float price, String desc, int imageSrc)
	{
		this.name = name;
		this.price = price;
		this.description = desc;
		this.imageSrc = imageSrc;
	}*/
	
	public Item(String name, float price, String desc, int quantity)
	{
		this.name = name;
		this.price = price;
		this.description = desc;
		this.quantity = quantity;
	}
	
	public Item()
	{
		
	}
	
	public void setImageSrc(int src)
	{
		this.imageSrc = src;
	}
	
	public int getImageSrc()
	{
		return imageSrc;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setPrice(float price)
	{
		this.price = price;
	}
	
	public float getPrice()
	{
		return price;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public String getDescription()
	{
		return description;
	}
	

	public int getquantity() {
		return quantity;
	}

	public void setquantity(int quantity) {
		this.quantity = quantity;
	}
	
}

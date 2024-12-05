package inventory.model;

public class HospitalPatient
{
	private String name;
	private String eyeColor;
	private boolean isMale;
	private int age;
	private int roomNumber;
	private double priceOfStay;
	
	public HospitalPatient()
	{
		this.name = "John";
		this.eyeColor = "Brown";
		this.isMale = false;
		this.age = 20;
		this.roomNumber = 100;
		this.priceOfStay = 99999;
	}
	
	public HospitalPatient(String name, String eyeColor, boolean isMale, int age, int roomNumber, double priceOfStay)
	{
		this.name = name;
		this.eyeColor = eyeColor;
		this.isMale = isMale;
		this.age = age;
		this.roomNumber = roomNumber;
		this.priceOfStay = priceOfStay;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getEyeColor()
	{
		return this.eyeColor;
	}
	
	public boolean getIsMale()
	{
		return this.isMale;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public int getRoomNumber()
	{
		return this.roomNumber;
	}
	
	public double getPriceOfStay()
	{
		return this.priceOfStay;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setEyeColor(String eyeColor)
	{
		this.eyeColor = eyeColor;
	}
	
	public void setIsMale(boolean isMale)
	{
		this.isMale = isMale;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	public void setRoomNumber(int roomNumber)
	{
		this.roomNumber = roomNumber;
	}
	
	public void setPriceOfStay(double priceOfStay)
	{
		this.priceOfStay = priceOfStay;
	}
	
	
	@Override
	public String toString()
	{
		String description = "This is patient : " + name + "." + "\n";
		description += "they have" + eyeColor + "eyes." + "\n";
		description += "it is " + isMale + "that they are male." + "\n";
		description += "They are " + age + "years old." + "\n";
		description += "their room number is " + roomNumber + "." + "\n";
		description += "the price of thir stay is " + priceOfStay + "." + "\n";
		
		return description;
	}
	
	
	
	
	
	
	
}

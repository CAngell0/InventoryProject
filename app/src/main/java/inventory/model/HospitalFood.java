package inventory.model;

public class HospitalFood
{
	private String foodName = "";
	private String ingredients = "";
	private int calories = 0;
	private boolean isVegan = false;
	private double price = 0.0;
	
	public HospitalFood()
	{
		this.foodName = "Spaghetti";
		this.ingredients = "flour, water, eggs";
		this.calories = 100;
		this.isVegan = false;
		this.price = 10.99;
	}
	
	public HospitalFood(String foodName, String ingredients, int calories, boolean isVegan, double price)
	{
		this.foodName = foodName;
		this.ingredients = ingredients;
		this.calories = calories;
		this.isVegan = isVegan;
		this.price = price;
	}
	
	public String getFoodName()
	{
		return this.foodName ;
	}
	public String getIngredients()
	{
		return this.ingredients;
	}
	public int getCalories()
	{
		return this.calories;
	}
	public boolean getIsVegan()
	{
		return this.isVegan;
	}
	public double getPrice()
	{
		return this.price;
	}
	
	public void setFoodName (String foodName)
	{
		this.foodName = foodName;
	}
	public void setIngredients (String ingredients)
	{
		this.ingredients = ingredients;
	}
	public void setCalories (int calories)
	{
		this.calories = calories;
	}
	public void setIsVegan (boolean isVegan)
	{
		this.isVegan = isVegan;
	}
	public void setPrice (double price)
	{
		this.price = price;
	}
	
	@Override
	public String toString()
	{
		String description = "";
		description += "The ingredients of " + foodName + " are: " + ingredients;
		description += foodName + " has " + calories + " calories.";
		description += "it is " + isVegan + " that your food is vegan.";
		description += "This will cost you " + price + " dollars.";
		
		return description;
	}
}
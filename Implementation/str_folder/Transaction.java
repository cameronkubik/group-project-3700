import java.util.EnumSet;

//Transaction class
public class Transaction {
	private int account;
	private Float amount;
	private String name;
	private String date;
	private String type;
	private Category category;
	
	public Transaction (String data) {
		String[] splitData = data.split(",");
		
		this.account = Integer.parseInt(splitData[0]);
		this.amount = Float.parseFloat(splitData[1]);
		this.name = splitData[2];
		this.date = splitData[3];
		this.type = splitData[4];
		
		for (Category c : EnumSet.allOf(Category.class)) {
    		if (c.id() == Integer.parseInt(splitData[5])) {
    			category = c;
    		}
    	}
	}
	public Transaction(int _account, Float _amount, String _name, String _date, String _type, Category _category) {
		this.account = _account;
		this.amount = _amount;
		this.name = _name;
		this.date = _date;
		this.type = _type;
		this.category = _category;
	}
	public int getAccount()       { return this.account; }
	public double getAmount() 	  { return this.amount; }
	public String getName()  	  { return this.name; }
	public String getDate()  	  { return this.date; }
	public String getType()       { return this.type; }
	public Category getCategory() { return this.category; }
	
	public String toCSV() {
		return this.account + "," + this.amount + "," + this.name + "," + this.date + "," + this.type + "," + this.category.id() + "\n";
	}
}
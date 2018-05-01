import java.util.EnumSet;
import java.util.ArrayList;

//Transaction Controller class

public class TransactionControl {
    // Member variables
    private static ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    private static EnumSet<Category> categories = EnumSet.allOf(Category.class);
    
    public static Transaction createTransaction() {
    	Printer.newlines(1);
    	Printer.pr("********** Enter Transaction Details **********", 1);
    	String name =    Printer.query("Name: ", 0);
    	Float amount =   Float.parseFloat(Printer.query("Amount: ",  0));
    	String date =    Printer.query("Date: ", 0);
    	String type =    Printer.query("Transaction Type: ", 0);    	
    	int categoryID = 0;
    	
    	Printer.newlines(1);
    	for (Category c : categories) {
    		Printer.pr(c.id() + ") " + c.title() + "\t", 0);
    	}
    	Printer.newlines(1);
    	
    	while (categoryID < 1 || categoryID > 5) {
    		categoryID = Integer.parseInt(Printer.query("Choose a category for this transaction: ", 0));
    	}    	    	
    	
    	Category category = null;
    	for (Category c : categories) {
    		if (c.id() == categoryID) {
    			category = c;
    		}
    	}
    	
    	Transaction t = new Transaction(AccountControl.getUser().getID(), amount, name, date, type, category);
    	transactions.add(t);
    	DatabaseManager.saveTransaction(t.toCSV());
    	return t;
    }
    public static ArrayList<Transaction> getTransactions() {
    	return transactions;
    }
    public static void loadTransactions(int userID) {
    	ArrayList<String> StringData = DatabaseManager.loadTransactions(userID);
    	for (String t : StringData) {
    		transactions.add(new Transaction(t));
    	}
    }
}


public class DataControl {
	
    public static boolean openMenu() {    	
    	String response = "0";
    	do {
        	Printer.newlines(1);
        	Printer.pr("********** Data Menu Options **********", 1);
        	Printer.pr("1) Refresh Data", 1);
        	Printer.pr("2) Print Data", 1);
        	Printer.pr("3) Export Data", 1);
        	Printer.pr("4) Return to Main Menu", 1);        	
        	response = Printer.query("Choose a menu option: ", 0);
        	
        	switch (response) {
	        	case "1":
	        		refreshData();
	        		break;
	        	case "2":
	        		printData();
	        		break;
	        	case "3":
	        		exportData();
	        		break;
	        	case "4":
	        		Printer.newlines(1);
	        		break;
        	}
    		
    	} while (!response.equals("4"));
    	
    	return true;
    }
    
    private static void refreshData() {
    	
    }
    
    private static void printData() {
    	Printer.newlines(1);
    	for (Transaction t : TransactionControl.getTransactions()) {
    		Printer.pr("Name: " + t.getName() + "\tAmount: $" + String.format("%.2f", t.getAmount()) + "\tDate: " + t.getDate()+ "\tType: " + t.getType()+ "\tCategory: " + t.getCategory().title(), 1);
    	}
    }
    
    private static void exportData() {
    	
    }
}

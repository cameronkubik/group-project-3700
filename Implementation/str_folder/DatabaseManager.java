import java.io.*;
import java.util.ArrayList;
import java.util.EnumSet;
import java.net.URL;
import java.nio.file.Files;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class DatabaseManager {
	private static File AccountsDB = null;
	private static File TransactionsDB = null;	
	private static FileInputStream in = null;
	private static FileOutputStream out = null;
	
	private static void openAccountsDB() {
		try {
			in = new FileInputStream(AccountsDB);
			out = new FileOutputStream(AccountsDB, true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static void openTransactionsDB() {
		try {
			in = new FileInputStream(TransactionsDB);
			out = new FileOutputStream(TransactionsDB, true);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	private static void closeDB() {
		try {
			in.close();
			out.close();
		} catch (IOException e) { }
	}
	
	public static boolean setupDBManager() {	
		try {
			AccountsDB = new File(System.getProperty("user.home") + File.separator + "AccountsDB.txt");
			TransactionsDB = new File(System.getProperty("user.home") + File.separator + "TransactionsDB.txt");
			AccountsDB.createNewFile();
			TransactionsDB.createNewFile();
		} catch (IOException e) { }		
		
		if (!AccountsDB.exists() || !TransactionsDB.exists()) {
			return false;
		}
		else {
			setAccountIDIndex();
			return true;
		}
	}	
	
	private static void setAccountIDIndex() {
		try (BufferedReader br = new BufferedReader(new FileReader(AccountsDB))) {
		    String line;
		    int max = AccountControl.getAccountIDIndex();
		    
		    while ((line = br.readLine()) != null) {		    	
		       String[] data = line.split(",");
		       int id = Integer.parseInt(data[0]);
		       
		       if (id > max) { max = id; }		      
		    }	
		    
		    AccountControl.setAccountIDIndex(max + 1);		    
		} catch (IOException e) { } 			
	}
	
	public static ArrayList<String> loadTransactions(int userID) {
		ArrayList<String> transactions = new ArrayList<String>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(TransactionsDB))) {
		    String line;		 
		    
		    while ((line = br.readLine()) != null) {		    	
		       String[] data = line.split(",");
		       int id = Integer.parseInt(data[0]);

		       if (id == userID) {
		    	   transactions.add(line);
		       }
		    }	
		    
		    return transactions;
		} catch (IOException e) {
			return transactions;
		} 
	}
	
	public static void saveAccount(String data) {
		openAccountsDB();
		try {
			out.write(data.getBytes());
			closeDB();
		}
		catch (IOException e) { }
	}

	public static boolean findAccount(String username) {
		try (BufferedReader br = new BufferedReader(new FileReader(AccountsDB))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       String[] data = line.split(",");
		       if (data[1].equals(username)) {
		    	   return true;
		       }
		    }		  
		    
		    return false;
		} catch (IOException e) { 
			//Decided to make this true so if it fails then it still won't allow a dupliate username
			return true;
		}	
	}
	public static String findAccount(String username, String password) {
		try (BufferedReader br = new BufferedReader(new FileReader(AccountsDB))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       String[] data = line.split(",");
		       if (data[1].equals(username) && data[2].equals(password)) {
		    	   return line;
		       }
		    }		  
		    
		    return "";
		} catch (IOException e) { 
			return "";
		}
	}
	public static void deleteAccount(int id) {
		try (BufferedReader br = new BufferedReader(new FileReader(AccountsDB))) {
			String line;
			String[] splitData;
			String newData = "";
			while ((line = br.readLine()) != null) {
				splitData = line.split(",");
				if (Integer.parseInt(splitData[0]) != id) {
					newData += line;
				}
			}
			new FileOutputStream(AccountsDB).write(newData.getBytes());
		} catch (IOException e) { }
	}
	
	public static void saveTransaction(String data) {
		openTransactionsDB();
		try {
			out.write(data.getBytes());
			closeDB();
		} catch (IOException e) { }
	}
	
	public static String exportData(int userID) {
		ArrayList<String> data = loadTransactions(userID);
		
		Workbook wb = new HSSFWorkbook();
        CreationHelper helper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("Transactions");

        Row row = sheet.createRow((short) 0);
        row.createCell(0).setCellValue(helper.createRichTextString("AMOUNT"));
        row.createCell(1).setCellValue(helper.createRichTextString("NAME"));
        row.createCell(2).setCellValue(helper.createRichTextString("DATE"));
        row.createCell(3).setCellValue(helper.createRichTextString("TYPE"));
        row.createCell(4).setCellValue(helper.createRichTextString("CATEGORY"));
        
        int r = 1;
        for (int i = 0; i < data.size(); i++) {
        	Row row2 = sheet.createRow((short) r++);
        	String[] transaction = data.get(i).split(",");
        	
        	for (int j = 1; j < transaction.length; j++) {
        		if (j == transaction.length - 1) {
        			String category = transaction[j];
        			
        			for (Category c : EnumSet.allOf(Category.class)) {
        	    		if (c.id() == Integer.parseInt(category)) {
        	    			transaction[j] = c.title();
        	    		}
        	    	}
        		}
        		
        		row2.createCell(j-1)
                	.setCellValue(helper.createRichTextString(transaction[j]));
        	}
        }

        try {
	        File excelFile = new File(System.getProperty("user.home") + File.separator + "Cash Stash Data.xls");
	        excelFile.createNewFile();
	        FileOutputStream fileOut = new FileOutputStream(excelFile);
	        wb.write(fileOut);
	        fileOut.close();
	        
	        return excelFile.getPath();
        } catch (IOException e) { 
        	return "ERROR: Please make sure the file isn't currently open and try again!";
        }
	}
	
}

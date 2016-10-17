package package1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class system {

	/**
	 * Gets the inventory data and stores it into an arraylist Creates a cashier
	 * object and sends the arraylist in the parameter
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> itemList = new ArrayList();

		String filename = "C:\\Users\\User\\Desktop\\inventory.txt"; //Inventory format = 101	Candy	$1.00
		String line = null;

		try { // reading file
			FileReader fr = new FileReader(filename);
			BufferedReader bufferedReader = new BufferedReader(fr);
			while ((line = bufferedReader.readLine()) != null) {
				itemList.add(line);
			}
			bufferedReader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("unable to open file");
		}

		try {
			if (itemList.size() == 0) { // checking to see if the database is
										// empty
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("Database is empty");
		}
		Cashier cashier = new Cashier(itemList); // cashier object is created
		cashier.ScanItems();
	}
}

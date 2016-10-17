package package1;

import java.util.ArrayList;
import java.util.Scanner;

public class Cashier {
	private static ArrayList<String> newList = new ArrayList();
	private static int UPC_code = 0;

	Cashier(ArrayList<String> list) {
		newList = list;
	}

	/**
	 * Gets the UPC code from terminal and matches it with the UPC code in
	 * database
	 */
	public static void ScanItems() {
		String input = null;
		String item = null;
		String itemcode = null;
		int itemNumber = 0;
		System.out.println("Enter UPC code");
		System.out.println("Press 'Q' when done entering all items");
		Scanner scan = new Scanner(System.in);
		int counter = -1;

		CashRegister cr = new CashRegister(); // creates a cash register object

		while (scan.hasNextLine()) { // scans the items one by one
			input = scan.nextLine();
			if (input.equals("Q") || input.equals("q")) { //once finished scanning, Cash register is used

				cr.addTotal();                           		
				cr.getMoney();
				cr.DisplayReciept();
				break;                    
			}
			try {
				UPC_code = Integer.parseInt(input);
				for (int i = 0; i < newList.size(); i++) { // strips the UPC										
					counter = -1;
					item = newList.get(i);
					itemcode = item.substring(0, 3);
					itemNumber = Integer.parseInt(itemcode);

					if (UPC_code == itemNumber) { // matches the upc code
						cr.Display(item);
						counter++;
						break;
					}
				}
				if (counter == -1) {
					System.out.println("Item not in inventory");
				}
			} catch (NumberFormatException e) {
				System.out.println("invalid input");
			}
		}
	}

}

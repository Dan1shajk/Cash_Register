package package1;

import java.util.ArrayList;
import java.util.Scanner;

public class CashRegister {

	private static ArrayList<String> list = new ArrayList();
	private static ArrayList<Double> Pricelist = new ArrayList();
	private static double getPrice = 0;
	private static double total = 0;
	private static String iteml = null;
	private static double money = 0;
	private static double change = 0;

	CashRegister() {

	}
	/**
	 * displays the item scanned on the terminal calls storeitem with the item
	 * being passed
	 * 
	 * @param item
	 */
	public static void Display(String item) {
		System.out.println(item);
		storeItem(item);
	}

	/**
	 * store the whole string into an array and strips the price from the string
	 * and stores that seperately
	 * 
	 * @param item
	 */
	public static void storeItem(String item) {
		list.add(item);
		iteml = item.substring(item.indexOf("$") + 1, item.length());
		getPrice = Double.parseDouble(iteml);
		Pricelist.add(getPrice);
	}

	/**
	 * calculates the total price
	 */
	public static void addTotal() {
		for (double x : Pricelist) {
			total = total + x;
		}
		System.out.println("Total is: $" + total);
	}

	/**
	 * gets the payment and handels the payment
	 */
	public static void getMoney() {
		System.out.println("Enter Payment");
		Scanner scan = new Scanner(System.in);
		money = scan.nextDouble();

		if (money < total) {
			while (money < total) {
				System.out.println("You owe $" + (total - money));
				money = money + scan.nextDouble();
			}
		}
		if (money > total) {
			change = money - total;
			System.out.println("Amount paid in full");
		} else
			System.out.println("Amount paid in full");

	}

	/**
	 * once the payment is made the reciept, displays the reciept
	 */
	public static void DisplayReciept() {
		System.out.println("                       Shopping Store Recipet");
		for (String x : list) {
			System.out.println(x);
		}
		System.out.println("Total: $" + total);
		System.out.println("Paid: $" + money);
		System.out.println("Change: $" + change);
	}
}

import java.util.Scanner;
public class keyChainStore {

	public static int add(int keys){
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("How many keychians would you like to add? ");
		keys = keys + keyboard.nextInt();
		System.out.println();
		
		return keys;
	}
	public static int remove(int keys){
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("How many keychians would you like to remove? ");
		keys = keys - keyboard.nextInt();
		System.out.println();
		
		if (keys < 0){
			keys = 0;
			System.out.println("All keychains have been removed from your order\n");
		}
		
		return keys;
	}
	public static void review (int keys, double cost, double shippingOrder, double shippingKey, double tax){
		
		double shipping = (keys * shippingKey + shippingOrder);
		double totalTax = (shipping + keys * cost) * tax;
		
		System.out.println("There are " +  keys + " keychains in your order");
		System.out.println("Keychain cost $" + cost+ " each. \nKeys- $" + (keys * cost));
		System.out.println("Shiping- $" + shipping);
		System.out.println("Tax- $" + totalTax );
		System.out.println("Total- $" + ((keys * cost) + shipping + totalTax));
		System.out.println();
		return;
	}
	
	public static boolean checkout(int keys, double cost, double shippingOrder, double shippingKey, double tax){
		Scanner keyboard = new Scanner(System.in);
		String name;
		double shipping = (keys * shippingKey + shippingOrder);
		double totalTax = (shipping + keys * cost) * tax;
		
		System.out.println("What is your name? ");
		name = keyboard.next();
		
		System.out.println("There are " +  keys + " keychains in your order");
		System.out.println("Keychain cost $" + cost+ " each. \nKeys- $" + (keys * cost));
		System.out.println("Shiping- $" + shipping);
		System.out.println("Tax- $" + totalTax );
		System.out.println("Total- $" + ((keys * cost) + shipping + totalTax));
		System.out.println("Thanks for your order, " + name + "!");
		
		return true;
	}
	public static void main(String[] args) {

		System.out.println("Welcome to Jack's key shop\n");
		
		Scanner keyboard = new Scanner(System.in);
		boolean checkout = false;
		int action;
		double cost = 10;
		double shipingOrder = 5;
		double shipingKey = 1;
		double tax = 0.085;
		int keys = 0;
		
		while (!checkout){
			
			System.out.println("1. Add Keychain to Order");
			System.out.println("2. Remove Keychains from Order");
			System.out.println("3. View Current Order");
			System.out.println("4. Checkout\n");
			System.out.print("Please enter your choice: ");
			action = keyboard.nextInt();
			
			if (action == 1){
				keys = add(keys);
			}
			else if (action == 2){
				keys = remove(keys);
			}
			else if(action == 3){
				review(keys, cost, shipingOrder, shipingKey, tax);
			}
			else if (action == 4){
				checkout = checkout(keys, cost, shipingOrder, shipingKey, tax);
			}
			else{
				System.out.println("That was no a valid choice\n");
			}
		}	
	}
}

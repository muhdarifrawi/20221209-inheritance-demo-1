package mini_project_20221207;

import java.util.Scanner;

class WelcomePrompt{
	String customer;
	
	void getName() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Hotel Rainyday");
		System.out.println("Your name please:");
		customer = scan.next();
		System.out.println("Welcome, " + customer);
	}
	
	void displayMenu() {
		System.out.println("Here is the menu");
		System.out.format(" _______________________________________%n");
		System.out.format(" ItemID       ItemName         ItemPrice %n");
		System.out.format(" _______________________________________%n");
		System.out.format(" 1            Tea              2 %n");
		System.out.format(" 2            Coffee           3 %n");
		System.out.format(" 3            Hot Choc         5 %n");
		System.out.format(" 4            Toast            3 %n");
		System.out.format(" 5            Omelette         7 %n");
		System.out.format(" _______________________________________%n");
	}
}

class Calculate{
	String itemName[] = {"Tea", "Coffee", "Hot Choc", "Toast", "Omelette"};
	int itemPrice[] = {2,3,5,3,7};
	int itemQty[] = {0,0,0,0,0};
	int itemSub[] = {0,0,0,0,0};
	
	void Selection() {
		int selection;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Item ID:");
		selection = scan.nextInt();
		
		if(selection == 1) {
			ProcessSelection(selection);
		}
		else if(selection == 2) {
			ProcessSelection(selection);
			}
		else if(selection == 3) {
			ProcessSelection(selection);
		}
		else if(selection == 4) {
			ProcessSelection(selection);
		}
		else if(selection == 5) {
			ProcessSelection(selection);
		}
		else {
			System.out.println("Selection not recognised.");
		}
	}
	
	void ProcessSelection(int selection) {
		int quantity;
		System.out.println("Enter quantity:");
		Scanner scan = new Scanner(System.in);
		quantity = scan.nextInt();
		itemQty[selection - 1] += quantity;
		int subtotal = quantity * itemPrice[selection -1];
		itemSub[selection - 1] += subtotal;
		System.out.println("Item Name: "+ itemName[selection - 1] +"	Item Price: " + itemPrice[selection -1]+ "	Quantity: " + quantity + " Subtotal: " + subtotal);
	}
	
	void DisplayTotal() {
		int sum = 0;
		System.out.format("%nYour receipt:%n");
		System.out.format(" _____________________________________________________%n");
		System.out.format(" ItemID       ItemName         ItemQty		Subtotal %n");
		System.out.format(" _____________________________________________________%n");
		for(int i=0; i<itemName.length; i++) {
			sum += itemSub[i];
			System.out.format(" "+(i+1)+"            "+itemName[i]+"		"+itemQty[i]+" 		"+itemSub[i]+"%n");
		}
		System.out.format(" ____________________________________________________%n");
		System.out.format("				Total	" + sum +"%n");
	}
}

class Manage{
	
	boolean MenuFlag;
	
	void runSys(){
		WelcomePrompt wp = new WelcomePrompt();
		Calculate cl = new Calculate();
		wp.getName();
		MenuFlag = true;
		
		while (MenuFlag) {
			wp.displayMenu();
			cl.Selection();
			System.out.println("Would you like to order more? (y/n):");
			Scanner scan = new Scanner(System.in);
			String reply = scan.next();
			if(reply.equalsIgnoreCase("n")) {
				MenuFlag = false;
				cl.DisplayTotal();
				System.out.format("%nThank you for your patronage. (= u =)/");
			}
			else if (!reply.equalsIgnoreCase("y")) {
				System.out.println("Please key in y or n only.");
				String replyPersist = scan.next();
				while(!replyPersist.equalsIgnoreCase("n") && !replyPersist.equalsIgnoreCase("y")) {
					System.out.println("Please key in y or n only.");
					replyPersist = scan.next();
				}
			}
		}
		
	}
}



public class BillingSystem {
	static public void main(String [] args) {
		Manage mg = new Manage();
		mg.runSys();
	}
}

package inheritenceAssignment;

import java.util.Scanner;

class Vehicle{
	void Model() {
		
	}
	
	
	void ABS() {
		System.out.println("ABS is working");
	}
	
	void Oil() {
		System.out.println("Oil is full");
	}
	
	void Electronics() {
		System.out.println("Electronics working");
	}
}

class Car extends Vehicle{
	void Model() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Car Model:");
		String name = scan.next();
		System.out.println("Car Model: " + name);
	}
}

class Motorbike extends Vehicle{
	void Model() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Car Model:");
		String name = scan.next();
		System.out.println("Motorbike Model: " + name);
	}
}

class Truck extends Vehicle{
	void Model() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Car Model:");
		String name = scan.next();
		System.out.println("Truck Model: " + name);
	}
}

class Garage{
	void permit(Vehicle ref) {
		ref.Model();
		ref.ABS();
		ref.Oil();
		ref.Electronics();
	}
}

class SysManager {
	void RunCar() {
		Car cr = new Car();
		
		Garage gr = new Garage();
		gr.permit(cr);
	}
	
	void RunMotorbike() {
		Motorbike mb = new Motorbike();
		
		Garage gr = new Garage();
		gr.permit(mb);
	}
	
	void RunTruck() {
		Truck tk = new Truck();
		
		Garage gr = new Garage();
		gr.permit(tk);
	}
	
	void MainSys() {
		Boolean flag = true;
		while(flag) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Choose vehicle type (Car, Motorbike, Truck) or Exit: ");
			String vehType = scan.next().toUpperCase();
			System.out.println(vehType + " selected");
			
			switch(vehType) {
				case "CAR":
					RunCar();
					break;
				case "MOTORBIKE":
					RunMotorbike();
					break;
				case "TRUCK":
					RunTruck();
					break;
				case "EXIT":
					flag = false;
					System.out.println("Thank you for choosing us.");
					break;
				default:
					System.out.println("Please only select given choices");
					break;
				
			}
			
		}
	}
}


public class LaunchShopData {
	public static void main(String [] args) {
		SysManager sm = new SysManager();
		sm.MainSys();
	}
}

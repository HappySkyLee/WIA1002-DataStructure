package Tutorial.Tut3.Q1;

import java.util.Scanner;

public class CandyMachine {
	private final Dispenser candy;
	private final Dispenser chips;
	private final Dispenser gum;
	private final Dispenser cookies;
	private final CashRegister register;

	public CandyMachine() {
		candy = new Dispenser("Candies", 2, 10);
		chips = new Dispenser("Chips", 3, 8);
		gum = new Dispenser("Gum", 1, 12);
		cookies = new Dispenser("Cookies", 4, 6);
		register = new CashRegister(100);
	}

	public void showSelection() {
		System.out.println("\n=== Candy Machine ===");
		System.out.println("1. " + candy.getProductName() + " - RM" + candy.getItemCost() + " (Stock: " + candy.getCount() + ")");
		System.out.println("2. " + chips.getProductName() + " - RM" + chips.getItemCost() + " (Stock: " + chips.getCount() + ")");
		System.out.println("3. " + gum.getProductName() + " - RM" + gum.getItemCost() + " (Stock: " + gum.getCount() + ")");
		System.out.println("4. " + cookies.getProductName() + " - RM" + cookies.getItemCost() + " (Stock: " + cookies.getCount() + ")");
		System.out.println("5. Exit");
		System.out.print("Enter your choice: ");
	}

	public Dispenser getProduct(int choice) {
		switch (choice) {
			case 1:
				return candy;
			case 2:
				return chips;
			case 3:
				return gum;
			case 4:
				return cookies;
			default:
				return null;
		}
	}

	public void sellProduct(Dispenser dispenser, int money) {
		if (dispenser.isEmpty()) {
			System.out.println("Sorry, " + dispenser.getProductName() + " is out of stock.");
			System.out.println("Money returned: RM" + money);
			return;
		}

		int cost = dispenser.getItemCost();
		if (money < cost) {
			System.out.println("Insufficient money. Item costs RM" + cost + ".");
			System.out.println("Money returned: RM" + money);
			return;
		}

		register.acceptAmount(cost);
		dispenser.makeSale();
		int change = money - cost;

		System.out.println("Dispensing " + dispenser.getProductName() + "...");
		System.out.println("Change returned: RM" + change);
		System.out.println("Thank you for your purchase.");
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		boolean running = true;

		while (running) {
			showSelection();

			if (!scanner.hasNextInt()) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.next();
				continue;
			}

			int choice = scanner.nextInt();

			if (choice == 5) {
				running = false;
				System.out.println("Machine closed.");
				continue;
			}

			Dispenser selected = getProduct(choice);
			if (selected == null) {
				System.out.println("Invalid choice. Please select 1 to 5.");
				continue;
			}

			System.out.println("Selected: " + selected.getProductName());
			System.out.println("Cost: RM" + selected.getItemCost());
			System.out.print("Insert money (RM): ");

			if (!scanner.hasNextInt()) {
				System.out.println("Invalid amount. Transaction cancelled.");
				scanner.next();
				continue;
			}

			int money = scanner.nextInt();
			sellProduct(selected, money);
		}
		scanner.close();
	}

	public static void main(String[] args) {
		CandyMachine machine = new CandyMachine();
		machine.run();
	}
}

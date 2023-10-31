
package edu.food.tabrezsir;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Bank {
	static boolean b = true;
	static FileWriter fw;
	static LocalDate CurrentDate;

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("\t\t\tWelcome to JavaBank!!!!");
		System.out.print("Enter your name: ");
		String name = scanner.nextLine();
		System.out.print("Enter your initial balance: ");
		double balance = scanner.nextDouble();
		scanner.nextLine();
		do {
			System.out.println();
			System.out.println("Choose an option:");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Enter deposit amount: ");
				double depositAmount = scanner.nextDouble();
				scanner.nextLine();
				balance += depositAmount;

				Passbook(name, "Deposit", depositAmount, balance);
				break;
			case 2:
				System.out.print("Enter withdrawal amount: ");
				double withdrawalAmount = scanner.nextDouble();
				scanner.nextLine();
				if (withdrawalAmount > balance) {
					System.out.println("Insufficient balance!");
				} else {
					balance -= withdrawalAmount;
					Passbook(name, "Withdrawal", withdrawalAmount, balance);
				}
				break;
			case 3:
				System.out.println("Thank you for using JavaBank!!!");
				scanner.close();
				b = false;
				break;
			default:
				System.out.println("Invalid choice.... Please try again.");
			}
		} while (b);
	}

	public static void Passbook(String name, String type, double amount, double balance) throws IOException {
		File file = new File("D://" + name + "_passbook.txt");
		try {
			CurrentDate = LocalDate.now();
			if (file.createNewFile())
				System.out.println("passbook printing done!!!!");
		} catch (IOException e) {
			System.out.println("Failed to write to passbook file: ");
		}

		fw = new FileWriter(file, true);
		// fw.write("\t\t\t******passbook details of " + name + " *******\n");
		fw.write(CurrentDate + "  " + type + "    " + " Amount " + amount + "   " + balance + "\n");

		fw.flush();

	}
}
Bank.java
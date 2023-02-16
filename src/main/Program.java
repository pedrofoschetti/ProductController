package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Product> list = new ArrayList<>();
		
		System.out.println("Enter the number of products: ");
		int n = sc.nextInt();
		for (int i = 1; i<=n; i++) {
			System.out.println("Product #" + i + " data");
			System.out.println("Common, used or imported? (c/u/i)");
			char choice = sc.next().charAt(0);
			System.out.println("Name: ");
			String name = sc.next();
			System.out.println("Price: ");
			int price = sc.nextInt();
			if (choice == 'c') {
				list.add(new Product(name, price));
			}
			else if (choice == 'i') {
				System.out.println("Customs fee: ");
				double feeCost = sc.nextDouble();
				list.add(new ImportedProduct(name, price, feeCost));
			} else if (choice == 'u') {
				System.out.println("Manufactured date (DD/MM/YYYY): ");
				LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				list.add(new UsedProduct(name, price, date));
			} else { 
				System.out.println("One of the chosen options is invalid.");
			}
			
		}
		
		System.out.println("");
		System.out.println("Prices: ");
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		
		
		
		
		sc.close();
	}

}

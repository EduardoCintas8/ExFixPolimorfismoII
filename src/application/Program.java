package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {
	public static final DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		System.out.print("Enter the number of products:");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			char type;

			do {
				System.out.println("Product #" + (i + 1) + " data:");
				System.out.print("Commom, used or imported (c/u/i)? ");
				type = sc.next().toUpperCase().charAt(0);
				if (!valid(type)) {
					System.out.println("invalid digit, enter again!");
				}
			} while (!valid(type));

			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();

			if (type == 'C') {
				list.add(new Product(name, price));
			} else if (type == 'U') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				String dat = sc.next();
				LocalDate date = LocalDate.parse(dat, fmt2);
				list.add(new UsedProduct(name, price, date));
			} else if (type == 'I') {
				System.out.print("Customs fee: ");
				Double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
		}

		System.out.println();
		for (Product product : list) {
			System.out.println(product.priceTag());

		}
		sc.close();
	}

	public static boolean valid(char type) {
		boolean valid = true;
		if (type == 'C' || type == 'U' || type == 'I') {
			valid = true;
		} else {
			valid = false;
		}
		return valid;
	}
}

package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UsedProduct extends Product {

	public static final DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate manufactureDate;

	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, Double price, LocalDate manufactureDate) {
		super(name, price);
		this.manufactureDate = manufactureDate;
	}

	public LocalDate getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(LocalDate manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	@Override
	public String priceTag() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName() + " (used)");
		sb.append(" $ " + String.format("%.2f", getPrice()));
		sb.append(" (Manufacture date: " + getManufactureDate().format(fmt2) + ")");

		return sb.toString();

	}
}

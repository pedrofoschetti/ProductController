package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import entities.Product;

public class UsedProduct extends Product{
	LocalDate manuDate;
	
	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, double price, LocalDate manuDate) {
		super(name, price);
		this.manuDate = manuDate;
	}

	public LocalDate getManuDate() {
		return manuDate;
	}

	public void setManuDate(LocalDate manuDate) {
		this.manuDate = manuDate;
	}
	
	@Override
	public String priceTag() {
		return getName() + " $" + price + " (Manufactured date: " + manuDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ")"; 
	}
	
	
}

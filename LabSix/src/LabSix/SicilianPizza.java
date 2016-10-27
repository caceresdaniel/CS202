package LabSix;

public class SicilianPizza extends Pizza {

	private double length;
	private double width;

	public SicilianPizza() {
	}

	public SicilianPizza(double lengthIn, double widthIn, double weightIn) {
		super(weightIn);
		length = lengthIn;
		width = widthIn;
	}

	@Override
	public double getCurrentArea() {
		super.area = length * width;
		return area;
	}

	public String toString() {
		String emptee = "";

		for (int i = 0; i < toppings.size(); i++) {
			emptee += toppings.get(i);
			emptee += " ";
		}

		return "Sicilian Pizza of length " + length + " and width " + width + " comes out to an area of "
				+ getCurrentArea() + " and has a weight of " + weight + " and toppings " + emptee;
	}

}
package LabSix;

public class NeapolitanPizza extends Pizza {

	private double radius;

	public NeapolitanPizza() {

	}

	public NeapolitanPizza(double radiusIn, double weightIn) {
		super(weightIn);
		radius = radiusIn;
	}

	@Override
	public double getCurrentArea() {
		this.area = 3.14 * (radius * radius);
		return area;
	}

	public String toString() {
		String emptee = "";

		for (int i = 0; i < toppings.size(); i++) {
			emptee += toppings.get(i);
			emptee += " ";
		}

		return "Neapolitan Pizza of Radius " + radius + " with an area of " + getCurrentArea() + " and a weight of "
				+ weight + " with toppings " + emptee;
	}
}

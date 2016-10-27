package LabSix;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza implements Comparable<Pizza>{
	protected Double area;
	protected Double weight;
	protected double slice = 8;
	protected List<String> toppings;

	public Pizza() {
	}

	public Pizza(double weightIn) {
		weight = weightIn;
		toppings = new ArrayList<String>();
	}

	public boolean checkTopping(String t) {
		boolean answer = false;
		for (int i = 0; i < toppings.size(); i++) {
			if (toppings.get(i).equals(t))
				return true;
		}
		return answer;
	}

	public abstract double getCurrentArea();

	public double getCurrentWeight() {
		return weight;
	}

	public void addTopping(String t) {
		toppings.add(t);
	}

	public void setCurrentArea(double area) {
		this.area = area;
	}

	public void setCurrentWeight(double weight) {
		this.weight = weight;
	}

	public double eatSlice() {
		double sliceArea =0;
		double sliceWeight = 0;
		double area = getCurrentArea();
		if (slice <= 8 && slice > 0) {
			sliceArea = area * (.125);
			sliceWeight = (.125) * getCurrentWeight();
			setCurrentArea(getCurrentArea() - sliceArea);
			setCurrentWeight(getCurrentWeight() - sliceWeight);
			slice--;
		}
		return sliceArea;
	}
	
	@Override
	public int compareTo(Pizza p){
		return this.weight.compareTo(p.weight);
				
	}
}
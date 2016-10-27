package LabSix;

import java.util.ArrayList;
import java.util.List;

public class Driver {
	private List<NeapolitanPizza> neo = new ArrayList<NeapolitanPizza>();
	private List<SicilianPizza> sic = new ArrayList<SicilianPizza>();

	public static void main(String[] args) {

		Driver pleaseRun = new Driver();
		pleaseRun.monitor();

	}

	public void monitor() {
		neo.add(new NeapolitanPizza(3, 1));
		sic.add(new SicilianPizza(5, 4, 2));
		sic.get(0).addTopping("cheese");
		sic.get(0).addTopping("pepperonie");
		neo.get(0).addTopping("sausage");
		neo.get(0).addTopping("bacon");

		for (int i = 0; i < sic.size(); i++) {
			System.out.println(sic.get(i));
		}

		for (int i = 0; i < neo.size(); i++) {
			System.out.println(neo.get(i));
		}

		System.out.println("Ate a slice with area of " + sic.get(0).eatSlice());
		System.out.println("Ate a slice with area of " + sic.get(0).eatSlice());
		System.out.println("Current area after eating slices " + sic.get(0).area);
		System.out.println("Ate a slice with area of " + neo.get(0).eatSlice());
		System.out.println("Checking if sicilian has cheese " + sic.get(0).checkTopping("cheese"));
		System.out.println("Checking if sicilian has tomato " + sic.get(0).checkTopping("tomato"));
		System.out.println("Checking if neopolitan has sausage " + neo.get(0).checkTopping("sausage"));
		System.out.println("Checking if neopolitan has tomato " + neo.get(0).checkTopping("tomato"));
		
		neo.get(0).setCurrentWeight(1.53125);
		System.out.println(sic.get(0).weight);	
		System.out.println(neo.get(0).weight);
		
		System.out.println("Comparing: " + sic.get(0).compareTo(neo.get(0)));
	}
	

}
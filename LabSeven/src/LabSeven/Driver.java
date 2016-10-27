package LabSeven;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		Driver run = new Driver();
		run.monitor();
	}

	public void monitor() {
		final List<MyFraction> fracs = new ArrayList<MyFraction>();
		final List<MySet> sets = new ArrayList<MySet>();
		
		
		fracs.add(new MyFraction(1, 2, '+')); // 2/2
		fracs.add(new MyFraction(1, 2, '+'));
		
		int[] numsOne = { 9, 10, 11, 6, 0 };
		int[] numsTwo = { 25, 9, 10, 8, 3, 2, 98 };
		
		sets.add(new MySet(numsOne));
		sets.add(new MySet(numsTwo));
		
		//sets.get(0).add(sets.get(1));
		System.out.println(sets.get(0).add(sets.get(1)));
		//fracs.add(new MyFraction(4, 9, '+'));
		//fracs.add(new MyFraction(4, 10, '+'));

		//fracs.get(2).add(fracs.get(3));

		fracs.get(0).subtract(fracs.get(1));
		
		System.out.println(fracs.get(0));

		//fracs.get(2).multiply(fracs.get(3));

		//fracs.get(2).divide(fracs.get(3));

	}

}

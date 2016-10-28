package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import LabSeven.MySet;

public class MySetTest {

	List<MySet> set = new ArrayList<MySet>();

	@Test
	public void testSubtractMethod() {

		int[] numsOne = { 9, 10, 11, 6, 0 };
		int[] numsTwo = { 25, 9, 10, 8, 3, 2, 98 };
		MySet setOne = new MySet(numsOne);
		MySet setTwo = new MySet(numsTwo);
		assertNotNull(setOne.subtract(setTwo));
	}

	@Test
	public void testMultiplicationMethod() {

		int[] numsOne = { 9, 10, 11, 6, 0 };
		int[] numsTwo = { 25, 9, 10, 8, 3, 2, 98 };
		MySet setOne = new MySet(numsOne);
		MySet setTwo = new MySet(numsTwo);
		assertNotNull(setOne.multiply(setTwo));
	}

	@Test
	public void testDivisionMethod() {

		int[] numsOne = { 9, 10, 11, 6, 0 };
		int[] numsTwo = { 25, 9, 10, 8, 3, 2 };
		MySet setOne = new MySet(numsOne);
		MySet setTwo = new MySet(numsTwo);
		assertNotNull(setOne.divide(setTwo));
	}

	@Test
	public void testAddMethod() {

		int[] numsOne = { 9, 10, 11, 6, 0 };
		int[] numsTwo = { 25, 9, 10, 8, 3, 2 };
		MySet setOne = new MySet(numsOne);
		MySet setTwo = new MySet(numsTwo);
		assertNotNull(setOne.add(setTwo));
	}

	@Test
	public void testAddAnswer()
	{
		int[] numsOne = { 9, 10, 11, 6, 0 };
		int[] numsTwo = { 25, 9, 10, 8, 3, 2, 98 };
		int[] numsThree = {25, 9, 10, 8, 3, 2, 98, 11, 6};
		set.add(new MySet(numsOne));
		set.add(new MySet(numsTwo));
		MySet answer = set.get(0).add(set.get(1));
		set.add(new MySet(numsThree));
		assertSame("Not Same", set.get(2), answer);
	}

	@Test
	public void testLengthForAdd() {
		int[] numsOne = { 9, 10, 11, 6, 0 };
		int[] numsTwo = { 25, 9, 10, 8, 3, 2, 98 };
		set.add(new MySet(numsOne));
		set.add(new MySet(numsTwo));
		MySet answer = set.get(0).add(set.get(1));

		assertSame("Not Same", 9, (answer.getReference().length));

	}

	@Test
	public void testLengthForSubtraction() {
		int[] numsOne = { 9, 10, 11, 6, 0 };
		int[] numsTwo = { 25, 9, 10, 8, 3, 2, 98 };
		set.add(new MySet(numsOne));
		set.add(new MySet(numsTwo));
		MySet answer = set.get(0).subtract(set.get(1));

		assertSame("Not Same", 3, (answer.getReference().length));

	}

	@Test
	public void testLengthForMultiplication() {
		int[] numsOne = { 9, 10, 11, 6, 0 };
		int[] numsTwo = { 25, 9, 10, 8, 3, 2, 98 };
		set.add(new MySet(numsOne));
		set.add(new MySet(numsTwo));
		MySet answer = set.get(0).multiply(set.get(1));

		assertSame("Not Same", 3, (answer.getReference().length));

	}

	@Test
	public void testLengthForDivision() {
		int[] numsOne = { 9, 10, 11, 6, 0 };
		int[] numsTwo = { 2, 10, 8, 3, 2, 98 };
		set.add(new MySet(numsOne));
		set.add(new MySet(numsTwo));
		MySet answer = set.get(0).divide(set.get(1));

		assertSame("Not Same", 2, (answer.getReference().length));

	}

}

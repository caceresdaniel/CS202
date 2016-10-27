package test;

import LabSeven.MySet;

import static org.junit.Assert.*;

import org.junit.Test;

public class MySetTest {

	@Test
	public void testAddMethod() {

		int[] numsOne = { 9, 10, 11, 6, 0 };
		int[] numsTwo = { 25, 9, 10, 8, 3, 2, 98 };
		MySet setOne = new MySet(numsOne);
		MySet setTwo = new MySet(numsTwo);
		assertNotNull(setOne.add(setTwo));
	}

	@Test
	public void testCheckAnswer() {
		int[] numsOne = { 9, 10, 11, 6, 0 };
		int[] numsTwo = { 25, 9, 10, 8, 3, 2, 98 };
		int[] answer = { 25, 9 , 10, 8, 3, 2, 98, 11, 6};
		MySet setOne = new MySet(numsOne);
		MySet setTwo = new MySet(numsTwo);
		MySet testAgainst = setOne.add(setTwo);
		assertSame("Not Equal", answer, testAgainst);
	}

	@Test
	public void testSubtractMethod(){
		int[] numsOne = {9};
		}

}

package LabSeven;

public class MySet implements MyMath<MySet> {

	private int[] reference;
	private boolean isTrue = true;

	public MySet(int[] a) {
		reference = a;
	}

	public int[] stripDuplicates(int[] a) {
		int[] stripOrigSize = new int[a.length];
		int j = 0; // j is initialized outside of the loop so it can be
					// referenced outside of the inner loop
		int k = 0; // k is a counter for the number of repeated numbers
		int l = 0; // l is a counter for the proper index of the stripOrigSize
					// array

		for (int i = 0; i < a.length; i++) {
			for (j = 0; j < i; j++) {
				if (a[i] == stripOrigSize[j]) {
					j = i + 10;
					k++;
				}
			}
			if (j == i) {
				stripOrigSize[l] = a[i];
				l++;
			}
		}

		int[] stripArray = new int[a.length - k];
		for (int i = 0; i < stripArray.length; i++) {
			stripArray[i] = stripOrigSize[i];
		}
		return stripArray;
	}

	@Override
	public MySet add(MySet o) {
		int[] thing = new int[o.getReference().length + this.reference.length];
		for (int i = 0; i < thing.length; i++) {
			if (i < o.getReference().length) {
				thing[i] = o.getReference()[i];
			} else {
				thing[i] = this.reference[i - o.getReference().length];
			}
		}
		int[] stripArray = stripDuplicates(thing);

		for (int i = 0; i < stripArray.length; i++) {
			// System.out.println(stripArray[i]);
		}
		return new MySet(stripArray);
	}

	@Override
	public MySet subtract(MySet o) {
		int[] savedNums = new int[this.reference.length];
		int[] array1 = stripDuplicates(this.reference); // the set being
														// subtracted from
		int[] array2 = stripDuplicates(o.getReference()); // the set to be
															// subtracted
		// both the first and second sets have had repeated numbers removed
		int arraySize = 0;
		// array size increases every time a number in the first set DOESN'T
		// appear in the second
		// allows me to create a properly sized Array at the end
		int j = 0;

		for (int i = 0; i < array1.length; i++) {
			for (j = 0; j < array2.length; j++) {
				if (array1[i] == array2[j]) {
					j = array2.length + 2;
				}
			}

			if (j == array2.length) {
				savedNums[arraySize] = array1[i];
				arraySize++;
			}
		}

		int[] arrayResult = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			arrayResult[i] = savedNums[i];
			// System.out.println(arrayResult[i]);
		}
		return new MySet(arrayResult);
	}

	@Override
	public MySet multiply(MySet o) {
		int[] savedNums = new int[this.reference.length + o.getReference().length];
		int j = 0;
		int arraySize = 0;
		// array size in this method only serves as a counter for the position
		// in the savedNums array

		for (int i = 0; i < this.reference.length; i++) {
			for (j = 0; j < o.getReference().length; j++) {
				if (this.reference[i] == o.getReference()[j]) {
					j = o.getReference().length + 2;
				}
			}
			if (j == o.getReference().length) {
				savedNums[arraySize] = this.reference[i];
				arraySize++;
			}
		}

		int[] arrayResult = new int[arraySize];

		for (int i = 0; i < stripDuplicates(savedNums).length; i++) {
			arrayResult[i] = stripDuplicates(savedNums)[i];
			// System.out.println(arrayResult[i]);
		}

		return new MySet(arrayResult);
	}

	@Override
	public MySet divide(MySet o) {
		int[] savedNums = new int[this.reference.length + o.getReference().length];
		int arraySize = 0;

		for (int i = 0; i < this.reference.length; i++) {
			for (int j = 0; j < o.getReference().length; j++) {
				if (this.reference[i] == o.getReference()[j]) {
					savedNums[arraySize] = this.reference[i];
					arraySize++;
				}
			}
		}

		int[] arrayResult = new int[arraySize];

		for (int i = 0; i < stripDuplicates(savedNums).length; i++) {
			arrayResult[i] = stripDuplicates(savedNums)[i];
			// System.out.println(arrayResult[i]);
		}

		return new MySet(arrayResult);
	}
	
	public String toString() {
		String s = "";
		System.out.print("{");
		for (int i = 0 ; i < this.reference.length ; i++){
			s += " " + this.reference[i] + ",";
		}
		s += "}\n";
		return s;
	}

	public int[] getReference() {
		return reference;
	}

	public void setReference(int[] reference) {
		this.reference = reference;
	}

	public boolean isTrue() {
		return isTrue;
	}

	public void setTrue(boolean isTrue) {
		this.isTrue = isTrue;
	}

}

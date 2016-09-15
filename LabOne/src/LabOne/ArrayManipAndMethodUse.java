package LabOne;

import java.util.Scanner;

public class ArrayManipAndMethodUse 
{
	public static void main(String[] args) 
	{

		double[] arrayOfUserInput = arrayCreator();

		arrayPrinter(arrayOfUserInput);

		valueReplacer500(arrayOfUserInput);

		arrayPrinter(arrayOfUserInput);

		squareRootOfIndices(arrayOfUserInput);

		arrayPrinter(arrayOfUserInput);

		arrayPrinter(recipricalOfOriginalArray(arrayOfUserInput));

	}

	public static double[] arrayCreator() 
	{

		Scanner input = new Scanner(System.in);

		double[] arrayOfUserInput = new double[10];

		System.out.print("Enter 10 Double type integers: ");

		for (int i = 0; i <= 9; i++)
			arrayOfUserInput[i] = input.nextDouble();

		return arrayOfUserInput;

	}

	public static void arrayPrinter(double[] arrayName) 
	{

		for (int i = 0; i <= 9; i++)
			System.out.print(arrayName[i] + "  ");
		System.out.println();

	}

	public static double[] recipricalOfOriginalArray(double[] arrayOfUserInput) 
	{

		double[] recipricalsOfUserInput = new double[arrayOfUserInput.length];

		for (int i = 0; i <= 9; i++)
			recipricalsOfUserInput[i] = arrayOfUserInput[i];

		for (int i = 0; i <= 9; i++)
			recipricalsOfUserInput[i] = 1.0 / arrayOfUserInput[i];

		return recipricalsOfUserInput;

	}

	public static void squareRootOfIndices(double[] arrayOfUserInput) 
	{

		for (int i = 0; i <= 9; i++)
			System.out.print(Math.sqrt(arrayOfUserInput[i]) + "  ");
		System.out.println();

	}

	public static void valueReplacer500(double[] arrayOfUserInput) 
	{

		for (int i = 0; i <= 9; i++)
			if (arrayOfUserInput[i] > 500)
				arrayOfUserInput[i] = 500;
	}
}

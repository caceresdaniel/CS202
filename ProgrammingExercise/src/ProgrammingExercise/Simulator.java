package ProgrammingExercise;

import java.util.Random;

public class Simulator {
	private static double[] nums;

	public double[] getGaussianData(double mean, double std, int count, double min, double max) {
		Random r = new Random();
		nums = new double[count];
		double randDoub;
		for (int counter = 0; counter < nums.length; counter++) {
			randDoub = r.nextGaussian() * std + mean;
			if (randDoub > max)
				randDoub = max;
			if (randDoub < min)
				randDoub = min;
			nums[counter] = randDoub;

		}
		return nums;

	}

	public double[] getLinearData(int count, double min, double max) {
		Random r = new Random();
		nums = new double[count];
		double randDoub;
		for (int counter = 0; counter < nums.length; counter++) {
			randDoub = r.nextDouble() * (max - min) + min;
			nums[counter] = randDoub;
		}
		return nums;
	}
}

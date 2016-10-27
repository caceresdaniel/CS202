package LabSeven;

public class MyFraction implements MyMath<MyFraction> {

	private int numerator;
	private int denominator;
	private char sign;

	public MyFraction(int numeratorIn, int denominatorIn, char signIn) {
		numerator = numeratorIn;
		denominator = denominatorIn;
		sign = signIn;
	}

	public MyFraction(Object object) {

	}

	public double getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public double getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}

	public char getSign() {
		return sign;
	}

	public void setSign(char sign) {
		this.sign = sign;
	}

	@Override
	public MyFraction add(MyFraction o) {
		if (sign == '+' && o.sign == '+') {
			numerator = (numerator * o.denominator) + (denominator * o.numerator);
			denominator = denominator * o.denominator;
		} else if (sign == '+' && o.sign == '-') {
			o.sign = '+';
			numerator = (numerator * o.denominator) - (denominator * o.numerator);
			denominator = denominator * o.denominator;
		} else if (sign == '-' && o.sign == '-') {
			numerator = (numerator * o.denominator) + (denominator * o.numerator);
			denominator = denominator * o.denominator;
		} else if (sign == '-' && o.sign == '+') {
			sign = '+';
			numerator = (denominator * o.numerator) - (numerator * o.denominator);
			denominator = denominator * o.denominator;
		} else {
			return null;
		}
		if (denominator == 0) {
			System.out.println("Undefined");
			return new MyFraction(0, 0, '+');
		}
		System.out.println(reduce(numerator, denominator));
		return new MyFraction(numerator, denominator, sign);
	}

	@Override
	public MyFraction subtract(MyFraction o) {
		if (sign == '+' && o.sign == '+') {
			numerator = (numerator * o.denominator) - (denominator * o.numerator);
			denominator = denominator * o.denominator;
		} else if (sign == '+' && o.sign == '-') {
			o.sign = '+';
			numerator = (numerator * o.denominator) + (denominator * o.numerator);
			denominator = denominator * o.denominator;
		} else if (sign == '-' && o.sign == '-') {
			sign = '+';
			numerator = (denominator * o.numerator) - (numerator * o.denominator);
			denominator = denominator * o.denominator;
		} else if (sign == '-' && o.sign == '+') {
			numerator = (denominator * o.numerator) + (numerator * o.denominator);
			denominator = denominator * o.denominator;
		} else {
			return null;
		}
		if (denominator == 0) {
			System.out.println("Undefined");
			return new MyFraction(0, 0, '+');
		}

		System.out.println(reduce(numerator, denominator));
		return new MyFraction(numerator, denominator, sign);
	}

	@Override
	public MyFraction divide(MyFraction o) {
		if (sign == '+' && o.sign == '+') {
			numerator = numerator * o.denominator;
			denominator = denominator * o.numerator;
		} else if (sign == '+' && o.sign == '-') {
			sign = '-';
			numerator = numerator * o.denominator;
			denominator = denominator * o.numerator;
		} else if (sign == '-' && o.sign == '-') {
			numerator = numerator * o.denominator;
			denominator = denominator * o.numerator;
		} else if (sign == '-' && o.sign == '+') {
			sign = '-';
			numerator = numerator * o.denominator;
			denominator = denominator * o.numerator;
		} else {
			return null;
		}
		if (denominator == 0) {
			System.out.println("Undefined");
			return new MyFraction(0, 0, '+');
		}
		System.out.println(reduce(numerator, denominator));
		return new MyFraction(numerator, denominator, sign);
	}

	@Override
	public MyFraction multiply(MyFraction o) {
		if (sign == '+' && o.sign == '+') {
			numerator = numerator * o.numerator;
			denominator = denominator * o.denominator;
		} else if (sign == '+' && o.sign == '-') {
			sign = '-';
			numerator = numerator * o.numerator;
			denominator = denominator * o.denominator;
		} else if (sign == '-' && o.sign == '-') {
			numerator = numerator * o.numerator;
			denominator = denominator * o.denominator;
		} else if (sign == '-' && o.sign == '+') {
			sign = '-';
			numerator = numerator * o.numerator;
			denominator = denominator * o.denominator;
		} else {
			return null;
		}
		if (denominator == 0) {
			System.out.println("Undefined");
			return new MyFraction(0, 0, '+');
		}
		System.out.println(reduce(numerator, denominator));
		return new MyFraction(numerator, denominator, sign);

	}

	// Receives the numerator and denominator for it to be reduced
	// the first for loop starts at the numerator of the original object and
	// converts it to the absolute value
	// starts with the numerator and works its way down checking to see if the
	// numerator
	// and the denominator are divisible by that number until it hits 0
	// once it hits 0 that means they don't have a LCD
	public String reduce(int numerator, int denominator) {
		for (int i = Math.abs(numerator); i > 1; i--) {
			if (numerator % i == 0 && denominator % i == 0) {
				String plusOrMinus = "";
				if (sign == '-')
					plusOrMinus = "-";
				numerator = numerator / i;
				denominator = denominator / i;
				return plusOrMinus + String.valueOf(numerator) + "/" + String.valueOf(denominator);
			}
		}
		if (numerator == 0 && denominator > 0) {
			denominator = 1;
		}
		setDenominator(denominator);
		setNumerator(numerator);
		String plusOrMinus = "";
		if (sign == '-')
			plusOrMinus = "-";
		return plusOrMinus + String.valueOf(numerator) + "/" + String.valueOf(denominator);
	}

	public String toString() {
		String negOrPos = "";
		if (sign == '-') {
			negOrPos = "-";
		}
		return negOrPos + numerator + "/" + denominator;
	}
}
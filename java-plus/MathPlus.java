package setup.javaPlus;

import java.awt.Point;
import java.util.ArrayList;

/**
 * The class {@code MathPlus} contains methods for performing more complex
 * mathematical operations and extensions to existing methods in {@link Math}, 
 * along with a few important mathematical constants.
 * 
 * @author jonatanfontanez
 * @see {@link Math}
 *
 */
public abstract class MathPlus {
	
	
	/**
     * The {@code double} value that is closer than any other to
     * <i>τ</i>, the ratio of the circumference of a circle to its
     * radius.
     */
	public static final double TAU = 6.2831853071795864769;
	
	/**
     * The {@code double} value that is closer than any other to
     * <i>φ</i>, the golden ratio.
     */
	public static final double PHI = 1.6180339887498948482;
	
	/**
	 * The {@code double} value that is closer than any other to
	 * <i>Ω</i>, the value that is defined by Ωe^Ω=1.
	 */
	public static final double OMEGA = 0.5671432904097838729;
	
	/**
     * The {@code double} value that is closer than any other to
     * <i>√2</i>, the square root of two.
     */
	public static final double ROOT_TWO = 1.4142135623730950488;
	
	/**
	 * Returns a value <code>c</code> of the way between <code>a</code> and <code>b</code>.
	 * For example, given <code>a=2.0</code>, <code>b=6.0</code>, and <code>c=0.5</code>, the
	 * returned value will be 4.
	 * 
	 * @param a first value to be used, usually smaller than <code>b</code>
	 * @param b second value to be used, usually larger than <code>a</code>
	 * @param c number to find position of returned value
	 * @return a number <code>c</code> of the way between <code>a</code> and <code>b</code>
	 */
	public static float linearInterpolation(float a, float b, float c) {
		return a * (1-c) + b * c;
	}
	
	/**
	 * Produces a random integer value between 0 and <code>max</code>.
	 * 
	 * @param max the maximum value to be returned
	 * @return random integer between 0 and <code>max</code>
	 */
	public static int random(int max) {
		return (int) MathPlus.random(max+1*1.0);
	}
	
	/**
	 * Produces a random integer value between <code>min</code> and <code>max</code>.
	 * 
	 * @param min the minimum value to be returned
	 * @param max the maximum value to be returned
	 * @return random integer value between <code>min</code> and <code>max</code>
	 */
	public static int random(int min, int max) {
		return (int) MathPlus.random(min*1.0, max+1*1.0);
	}
	
	/**
	 * Produces a random decimal value between 0 and <code>max</code>.
	 * 
	 * @param max the maximum value to be returned
	 * @return random decimal between 0 and <code>max</code>
	 */
	public static double random(double max) {
		return MathPlus.random(0, max);
	}
	
	/**
	 * Produces a random decimal value between <code>min</code> and <code>max</code>.
	 * 
	 * @param min the minimum value to be returned
	 * @param max the maximum value to be returned
	 * @return random decimal value between <code>min</code> and <code>max</code>
	 */
	public static double random(double min, double max) {
		return (Math.random()*(max - min)) + min;
	}
	
	/**
     * Returns the correctly rounded positive square root of a
     * {@code double} value.
     * Special cases:
     * <ul>
     * <li> If the argument is negative, then the result is a <code>ComplexNumber</code>
     * object.
     * <li>If the argument is NaN, then the result is NaN.
     * <li>If the argument is positive infinity, then the result is positive
     * infinity.
     * <li>If the argument is positive zero or negative zero, then the
     * result is the same as the argument.</ul>
     * Otherwise, the result is the {@code double} value closest to
     * the true mathematical square root of the argument value.
     *
     * @param   a   a value.
     * @return  the positive square root of {@code a}.
     *          If the argument is NaN or less than zero, the result is NaN.
     */
	public static ComplexNumber sqrt(double a) {
		if(a < 0)
			return new ComplexNumber(0.0, Math.sqrt(-a));
		else
			return new ComplexNumber(Math.sqrt(a), 0.0);
	}

	/**
     * Returns the greatest of all {@code double} values. That is, the
     * result is the argument closer to the value of
     * {@link Double#MAX_VALUE}. If all the arguments have the same value,
     * the result is that same value.
     *
     * @param   value the input values
     * @return  the largest value in the input
     */
	public static double max(double... values) {
		double maximum = values[0];
		for(int i = 1; i < values.length; i++) {
			if(values[i] > maximum)
				maximum = values[i];
		}
		return maximum;
	}
	
	/**
     * Returns the least of all {@code double} values. That is, the
     * result is the argument closer to the value of
     * {@link Double#MIN_VALUE}. If all the arguments have the same value,
     * the result is that same value.
     *
     * @param   value the input values
     * @return  the smallest value in the input
     */
	public static double min(double... values) {
		double minimum = values[0];
		for(int i = 1; i < values.length; i++) {
			if(values[i] < minimum)
				minimum = values[i];
		}
		return minimum;
	}
	
	/**
	 * Returns the sum of all {@code double} values.
	 * 
	 * @param ds values to be summed
	 * @return sum of all values
	 */
	public static double sum(double... ds) {
		double sum = 0.0;
		for(int i = 0; i < ds.length; i++)
			sum += ds[i];
		return sum;
	}
	
	/**
	 * Returns if the value is between the minimum and the maximum.
	 * 
	 * @param val value to check
	 * @param min minimum value in range
	 * @param max maximum value in range
	 * @return if the value is within minimum and maximum
	 */
	public static boolean inRange(double val, double min, double max) {
		if(min > max)
			throw new IllegalArgumentException("Minimum value cannot be greater than maximum value!");
		return val >= min && val <= max;
	}
	
	/**
	 * Returns the mathematical average or mean of all {@code double} values.
	 * 
	 * @param ds values to be average
	 * @return mathematical average of all values
	 */
	public static double average(double...ds) {
		return MathPlus.sum(ds)/ds.length;
	}
	
	/**
	 * Returns the mathematical mode or most common value(s) of all {@code double}
	 * values. Returns an empty array if there is no mode, and multiple numbers if
	 * they are all equally common.
	 * 
	 * @param ds values to find the mode of
	 * @return the mode(s) of all values
	 */
	public static double[] mode(double...ds) {
		ArrayList<Double> commonValues = new ArrayList<Double>();
		ArrayList<Integer> valueOccurence = new ArrayList<Integer>();
		for(int i = 0; i < ds.length; i++) {
			if(commonValues.contains(ds[i])) {
				valueOccurence.set(commonValues.indexOf(ds[i]), valueOccurence.get(commonValues.indexOf(ds[i]))+1);
			}else {
				commonValues.add(ds[i]);
				valueOccurence.add(1);
			}
		}
		double[] occurences = new double[valueOccurence.size()];
		for(int i = 0; i < occurences.length; i++) {
			occurences[i] = valueOccurence.get(i);
		}
		int minNeeded = (int)MathPlus.max(occurences);
		for(int i = 0; i < commonValues.size(); i++) {
			if(valueOccurence.get(i) < minNeeded) {
				valueOccurence.remove(i);
				commonValues.remove(i);
				i--;
			}
		}
		double[] mode = new double[commonValues.size()];
		for(int i = 0; i < mode.length; i++) {
			mode[i] = commonValues.get(i);
		}
		return mode;
	}
	
	/**
	 * Returns the value of the factorial of n, or n!, where 
	 * n! = n * (n-1) * (n-2)...* 2 * 1
	 * 
	 * @param n value to find the factorial of
	 * @return factorial of n, or n!
	 */
	public static double factorial(double n) {
		if(n < 0)
			throw new IllegalArgumentException("Value cannot be negative!");
		else if(n % 1 != 0)
			throw new IllegalArgumentException("Value must be an integer!");
		else if(n == 0 || n == 1)
			return 1.0;
		else
			return n * factorial(n-1);
	}
	
	/**
	 * Returns the value of the <code>n</code>th root of <code>a</code>.
	 * 
	 * @param a radicand of radical
	 * @param n degree of radical
	 * @return <code>n</code>th root of <code>a</code>
	 */
	public static double nthrt(double a, double n) {
		return Math.pow(a, 1.0/n);
	}
	
	/**
	 * Returns a <code>Point</code> object which is a reflected <code>p</code>
	 * across a line designated where p1 = (x0, y0) and p2 = (x1, y1).
	 * 
	 * @param p point to be reflected
	 * @param x0 x coordinate of first point
	 * @param y0 y coordinate of first point
	 * @param x1 x coordinate of second point
	 * @param y1 y coordinate of second point
	 * @return point flipped across designated line
	 */
	public static Point mirror(Point p, int x0, int y0, int x1, int y1){
		double dx,dy,a,b;
		long x2,y2;
		Point p1; //reflected point to be returned 
		dx = (double) (x1 - x0);
		dy = (double) (y1 - y0);
		a = (dx * dx - dy * dy) / (dx * dx + dy*dy);
		b = 2 * dx * dy / (dx*dx + dy*dy);
		x2 = Math.round(a * (p.x - x0) + b*(p.y - y0) + x0); 
		y2 = Math.round(b * (p.x - x0) - a*(p.y - y0) + y0);
		p1 = new Point((int)x2,(int)y2); 
		return p1;
	}
	
	/**
	 * Returns the angle between two points in radians.
	 * 
	 * @param x1 x coordinate of first point
	 * @param y1 y coordinate of first point
	 * @param x2 x coordinate of second point
	 * @param y2 y coordinate of second point
	 * @return angle between points in radians
	 */
	public static double angleBetween(double x1, double y1, double x2, double y2) {
		double angle = Math.atan2(y2 - y1, x2 - x1);
		return angle;
	}

}

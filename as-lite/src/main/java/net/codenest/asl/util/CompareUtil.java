package net.codenest.asl.util;

public class CompareUtil {

	public static double epsilon = 1E-6;

	public static double abs(final double v) {
		return (v < 0) ? -v : v;
	}

	public static boolean equal(final double x, final double y) {
		double max = Math.max(abs(x), abs(y));
		if (max <= epsilon) {
			return true;
		}

		double diff = abs(x - y) / max;

		return (diff < epsilon);
	}

	public static boolean less(final double x, final double y) {
		return !equal(x, y) && (x < y);
	}

	public static boolean lessEqual(final double x, final double y) {
		return x < y || equal(x, y);
	}

	public static boolean greater(final double x, final double y) {
		return !equal(x, y) && (x > y);
	}

	public static boolean greaterEqual(final double x, final double y) {
		return x > y || equal(x, y);
	}

	public static int compare(final double x, final double y) {
		return equal(x, y) ? 0 : (x < y ? -1 : 1);
	}

	public static <T extends Comparable<T>> T min(T a, T b) {
		return a.compareTo(b) <= 0 ? a : b;
	}

	public static <T extends Comparable<T>> T max(T a, T b) {
		return a.compareTo(b) >= 0 ? a : b;
	}
}

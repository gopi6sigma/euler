import java.util.*;

public class P493 {
	private static final int max = 10;
	private static final int picks = 20;
	private static final int colors = 7;
	private static double result = 0.0;	
	private static long total = 0;
	private static long calls = 0;
	private static HashMap<Integer, Integer> map = new HashMap();
	public static double choose (int n, int r) {
		double result = 1.0;
		for (int i = 1; i <= n; i++) result *= i;
		for (int i = 1; i <= r; i++) result /= i;
		for (int i = 1; i <= (n - r); i++) result /= i;
		return result;
	}
	public static void main(String ar[]) throws Exception {
		System.out.println("choose " + choose(70, 20));
		int[] c = new int[colors];
		for (int i = 0; i < colors; i++) c[i] = max;
		f(c, 0, picks);
		for (int i = 0; i <= colors; i++) {
			System.out.println("dist: " + i + " entries " + map.get(i));
		}
		System.out.println("total : " + total  + " calls " + calls + " final result " + (double)total/calls);
		long count = 0L;
		for (int i = 0; i <= colors; i++) {
			if (null != map.get(i)) count += map.get(i) * i;
		}
		System.out.println("another total " + count);
		System.out.println("solns test: " + solns(colors, picks, max));
	}

	private static long solns(int n, int sum, int cap) {
		int x[] = new int[n];
		for (int i = 0; i < n; i++) x[i] = cap;
		long res = solnsRec(x, 0, sum);
		System.out.println("solns: " + res);
		return res;
	}

	private static long solnsRec(int[] x, int start, int sum) {
		long res = 0;
		if (0 == sum) {
			return 1L;
		}
		
		for (int i = start; i < x.length; i++) {
			if (x[i] > 0) {
				x[i]--;
				res += solnsRec(x, i, sum - 1);
				x[i]++;
			}
		}
		return res;
	}

	private static void f(int[] c, int start, int rem) throws Exception {
		if (0 == rem) {
			calls++;
			if (calls % 10000 == 0) { System.out.println("calls: " + calls + " total " + total);}
			int dist = 0;
			for (int i = 0; i < c.length; i++) {
				if (c[i] < max) dist++;
			}
			total += dist;
			if (map.containsKey(dist)) {
				map.put(dist, map.get(dist) + 1);
			} else {
				map.put(dist, 1);
			}
			return;
		}
		for (int i = start; i < c.length; i++) {
			if (c[i] > 0) {
				c[i]--;
				f(c, i, rem - 1);
				c[i]++;
			}
		}
	}
}

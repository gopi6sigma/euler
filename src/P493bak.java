public class P493 {
	private static final int max = 10;
	private static final int picks = 2;
	private class State implements Cloneable {
		int c1, c2, c3, c4, c5, c6, c7, rem, dist;
		public State(int c1, int c2, int c3, int c4, int c5, int c6, int c7, int rem, int dist) {
			this.c1 = c1;
			this.c2 = c2;
			this.c3 = c3;
			this.c4 = c4;
			this.c5 = c5;
			this.c6 = c6;
			this.c7 = c7;
			this.rem = rem;
			this.dist = dist;
		}
		
		@Override
		public boolean equals(Object o) {
			if (null == o) return false;
			if (this == o) return true;
			State that = (State) o;
			return c1 == that.c1 &&
					c2 == that.c2 &&
					c3 == that.c3 &&
					c4 == that.c4 &&
					c5 == that.c5 &&
					c6 == that.c6 &&
					c7 == that.c7 &&
					rem == that.rem &&
					dist == that.dist;
		}

		public State clone() throws CloneNotSupportedException {
			return (State) super.clone();
		}
	}
	
	public static void main(String ar[]) {
		double result = f(max, max, max, max, max, max, max, picks, 0);
		System.out.println("final result : " + result);
	}

	private double f(int c1, int c2, int c3, int c4, int c5, int c6, int c7, int rem, int dist) {
		if (0 == rem) return 0.0;
		double result = 0.0;
		int total = c1 + c2 + c3 + c4 + c5 + c6 + c7;
		if (c1 == max) {
			result += (dist + 1) * (c1 / total)f(c1 - 1, c2, c3, c4, c5, c6, c7, rem - 1, dist + 1);
		}
		return 0;	
	}

}

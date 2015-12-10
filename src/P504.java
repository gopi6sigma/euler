import java.util.HashMap;

public class P504 {
//
//    private static final int max = 4;
//    private static HashMap<Pair, Integer> map = new HashMap<>(max * max);
//
//    private static int latticePoints(int xInterceptr, int yInterceptor) {
//        System.out.println(" xInt " + xInterceptr + " yInt " + yInterceptor);
//        if (map.containsKey(new Pair(xInterceptr, yInterceptor))) {
//            return map.get(new Pair(xInterceptr, yInterceptor));
//        }
//        int count = 0;
//        int constant = xInterceptr * yInterceptor;
//        for (int x = 1; x < xInterceptr; x++) {
//            if ((constant - x * yInterceptor) % xInterceptr == 0) {
//                int y = (constant - x * yInterceptor) / xInterceptr;
//                if (y >= 1 && y < yInterceptor) {
//                    count++;
//                    System.out.println(count + " : x " + x + " y " + y);
//                }
//            }
//        }
//        map.put(new Pair(xInterceptr, yInterceptor), count);
//        return count;
//    }
//
//    private static boolean isSquare(int n) {
//
//        int lo = 1, hi = n;
//        while (lo <= hi) {
//            int mid = (lo + hi) / 2;
//            if (mid * mid == n) return true;
//            if (mid * mid < n) lo = mid + 1;
//            else hi = mid - 1;
//        }
//
//        return false;
//    }
//
//    private static class Pair {
//        int a;
//        int b;
//
//        public Pair(int a, int b) {
//            this.a = a;
//            this.b = b;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//
//            Pair pair = (Pair) o;
//
//            if (a != pair.a) return false;
//            return b == pair.b;
//
//        }
//
//        @Override
//        public int hashCode() {
//            int result = a;
//            result = 31 * result + b;
//            return result;
//        }
//    }
//
//    public static void main(String[] args) {
//        int count = 0;
//        for (int x1 = 1; x1 <= max; x1++) {
//            System.out.println("x1 : " + x1);
//            for (int y1 = 1; y1 <= max; y1++) {
//                int lp11 = latticePoints(x1, y1);
//                for (int x2 = 1; x2 <= max; x2++) {
//                    int lp21 = latticePoints(y1, x2);
//                    for (int y2 = 1; y2 <= max; y2++) {
//                        int lp22 = latticePoints(x2, y2);
//                        int lp12 = latticePoints(y2, x1);
//                        int sum = lp11 + lp12 + lp21 + lp22 + 4;
//                        if (isSquare(sum)) {
//                            count++;
//                            System.out.println(" count : " + count + " sum " + sum + " x1 " + x1 + " y1 " + y1 + " x2 " + x2 + " y2 " + y2);
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println(" final result : " + count);
//    }
}

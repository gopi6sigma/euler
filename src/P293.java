import java.util.*;

public class P293 {
    private static final int max = 1000000000;
    //private static final int max = 650;
    private static HashSet<Long> fort = new HashSet<Long>();
    private static HashSet<Long> adm = new HashSet<Long>();
    private static final int[] ps = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23};
    private static void get(long cur, int ind) {
        if (ind == ps.length) return;
        long temp = cur;
        while (temp * ps[ind] < max) {
            temp *= ps[ind];
            adm.add(temp);
            get(temp, ind + 1);
        }
    }

    public static long modExp(long a, long b, long mod) {
        if (0 == b) return 1L;
        long res = modExp(a, b/2, mod);
        long t = (res * res) % mod;
        if (0 == b % 2) return t;
        return (t * a) % mod;
    }

    private static int[] primes = new int[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};

    private static boolean isPrime(long n) {
        if (n <= primes[primes.length - 1]) {
            for (int i = 0; i < primes.length; i++) {
                if (n == primes[i]) return true;
            }
            return false;
        }
        for (int i = 0; i < primes.length; i++) {
            if (modExp((long)primes[i], n - 1, n) != 1) return false;
        }
        return true;
    }

    public static void main(String ar[]) {
        System.out.println(" isp ? " + isPrime(97));
        System.out.println(" isp ? " + isPrime(101));
        System.out.println(" isp ? " + isPrime(297));

        get(1L, 0);
//        System.out.println("size : " + adm.size());
  //      for (Long a : adm) {
    //        System.out.println(a);
      //  }
        System.out.println("size : " + adm.size());
        for (Long a : adm) {
            for (long m = 3; m < max; m += 2) {
                if (isPrime(a + m)) {
                    fort.add(m);
                    break;
                }
            }
        }
        System.out.println("fort size : " + fort.size());
        long res = 0;
        for (long f : fort) {
            res += f;
        }
        System.out.println("final res : " + res);
    } 
}



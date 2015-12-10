public class P500 {
    public static long modExp(long a, long b, long mod) {
        if (0 == b) return 1L;
        long res = modExp(a, b/2, mod);
        long t = (res * res) % mod;
        if (0 == b % 2) return t;
        return (t * a) % mod;

    }

    public static void main(String ar[]) {
        long mod = 500500507L;
        long[] bases = new long[] {2, 3, 5, 7, 11, 13, 17, 19};
        long[] exps = new long[] {13, 11, 7, 5, 5, 5, 2, 2};
        long res = 1L;
        for (int i = 0; i < bases.length; i++) {
            long t = modExp(bases[i], exps[i] - 1, mod);
            res = (res * modExp(2, t, mod)) % mod;
            System.out.println(" i : " + i + " base " + bases[i] + " expi " + exps[i] + " res " + res + " modexp result : " + modExp(bases[i], exps[i] - 1, mod));
        }
        System.out.println("final result : " + res);

        long t1 = modExp(2, 37, mod);
        System.out.println("t1 " + (t1));
        long t2 = modExp(t1, 167, mod);
        System.out.println("t2 " + (t2));
        long t3 = modExp(t2, 81, mod);
        System.out.println("t3 " + (t3));
    }
}

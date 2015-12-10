import java.util.HashSet;
import java.util.Set;

public class MyUtils {
	public static long pow(long a, int e) {
		if (1 == e) return a;
		long t = pow(a, e / 2); 
		if (a % e == 0) return t * t;
		return t * t * a;
	}

	public static long pow(long a, int e, int mod) {
		if (1 == e) return a;
		long t = pow(a, e / 2, mod);
		if (a % e == 0) return (t * t) % mod;
		return (((t * t) % mod) * a) % mod;
	}
	/*
		 returns primes of 'size'. 

	 */
	public static long[] makePrimes(int size) {
		long p[] = new long[size];
		if (0 == size) return p;
		p[0] = 2;
		int k = 1;
		for (long n = 3;; n += 2) {
			if (k == size) return p;
			if (isPrime(n, p, k)) {
				p[k++] = n;
			}
		}
	}

	/*
		 says if the given 'n' is a prime or not based on the divison test of given primes in p[] of size 'size'.
	 */

	public static boolean isPrime(long n, long[] p, int size) {
		for (int i = 0; i < size; i++) {
			if (p[i] * p[i] > n) return true;
			if (n % p[i] == 0) return false;
		}
		return true;
	}

	public static boolean isPrime(long n) {
		if (n < 2) return false;
		long[] p = new long[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
		if (n <= p[p.length - 1]) {
			for (int i = 0; i < p.length && p[i] * p[i] <= n; i++) {
				if (0 == n % p[i]) return false;
			}
			return true;
		}
		// if large
		for (int i = 0; i < p.length; i++) {
			if (0 == n % p[i]) return false;
		}
		for (int i = 0; i < p.length; i++) {            
			//System.out.println(n + " pi " + p[i] + " modexp " + modExp(n, p[i] - 1, p[i]));
			if (1 != modExp(p[i], n - 1, n)) return false;
		}
		return true;
	}

	// No multiplication overflow is considered
	public static long modExp(long a, long b, long mod) {
		long x = 1L, y = a;
		while (b > 0) {
			if (1L == b % 2) {
				//x = mulMod(x, y, mod);
				x = (x * y) % mod;                
			}
			//y = mulMod(y, y, mod);
			y = (y * y) % mod;
			if (y < 0 || x < 0) throw new RuntimeException("x or y is overflown apparently ... a " + a + " b " + b + " mod " + mod + " x " + x + " and y " + y + ".\n User saferIsPrime API. \n");
			b /= 2;
		}
		return x % mod;
	}

	public static boolean saferIsPrime(long n) {
		if (n < 2) return false;
		long[] p = new long[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
		if (n <= p[p.length - 1]) {
			for (int i = 0; i < p.length && p[i] * p[i] <= n; i++) {
				if (0 == n % p[i]) return false;
			}
			return true;
		}
		// if large
		for (int i = 0; i < p.length; i++) {
			if (0 == n % p[i]) return false;
		}
		for (int i = 0; i < p.length; i++) {            
			//System.out.println(n + " pi " + p[i] + " modexp " + modExp(n, p[i] - 1, p[i]));
			if (1 != saferModExp(p[i], n - 1, n)) return false;
		}
		return true;
	}

	// It considers overflow in multiplication
	public static long saferModExp(long a, long b, long mod) {
		long x = 1L, y = a;
		while (b > 0) {
			if (1L == b % 2) {
				x = mulMod(x, y, mod);
				//x = (x * y) % mod;                
			}
			y = mulMod(y, y, mod);
			//y = (y * y) % mod;
			if (y < 0 || x < 0) throw new RuntimeException("y is overflown apparently ... a " + a + " b " + b + " mod " + mod + " x " + x + " and y " + y);
			b /= 2;
		}
		return x % mod;
	}

	/* this function calculates (a*b)%c taking into account that a*b might overflow */
	public static long mulMod(long a, long b, long c){
		long x = 0L, y=a%c;
		while(b > 0){
			if(b%2 == 1){
				x = (x+y)%c;
			}
			y = (y*2)%c;
			b /= 2;
		}
		return x%c;
	}

	public static long gcd(long a) {
		return a;
	}    

	public static long gcd(long a, long b) {
		if (a < b) return gcd(b, a);
		while (a % b != 0) {
			long t = a % b;
			a = b;
			b = t;
		}
		return b;
	}

	public static long incExc(long cur, int ind, long f[], long n, int sign) {
		if (cur < 0) {
			throw new RuntimeException("cur < 0 " + cur);
		}
		long res = 0L;
		calls++;
		//System.out.println(calls + " incExc " + cur + " ind " + ind + " sign " + sign);
		for (int i = ind; i < f.length; i++) {
			if (cur == 1) {
				System.out.println("progress : ind " + ind + " find " + f[ind] + " calls so far " + calls + " res " + res);
			}
			long g = gcd(f[i], cur);
			//System.out.println("g " + g + " i " + i + " fi " + f[i] + " cur " + cur + " f[i] * cur " + f[i] * cur);
			//System.out.println("result of condn  " + );

			if (f[i] * cur > g * n || (f[i] * cur)/g > n || (cur/g) * f[i] > n || cur * (f[i]/g) > n || cur * f[i] < 0 || cur * f[i] < cur || cur * f[i] < f[i]) {
				// do nothing 
				break;
			} else {
				res += sign * (n/((f[i] * cur)/g));
				//System.out.println(" res after first " + res);
				long v = cur * f[i];
				if (v < 0 || v < cur || v < f[i]) {
					throw new RuntimeException("apparent overflow : prod " + v + " cur " + cur + " fi " + f[i]);
				}
				System.out.println("calling incExc gcd " + g + " cur " + cur + " i " + i + " fi " + f[i] + " calling with cur = " + (cur * f[i])/g);
				res += incExc((cur * f[i])/g, i + 1, f, n, sign * -1);
				//System.out.println(" res secodn " + res);
			}
			//System.out.println(" res " + res);
		}
		//System.out.println("cur " + cur + " ind " + ind + " sign " + sign + " res " + res);
		return res;
	}

	private static long calls;

	//    // works for primes for sure. Not sure otherwise. Result includes n.
	//    public static long uniqueMultiplesOfPrime(long p[], long n, long mod) {
	//        long res = primeIncExcSum(1L, 0, p, n, 1, mod);
	//    }

	public static long uniqueMultiples(long f[], long n) {
		calls = 0;
		long res = incExc(1L, 0, f, n, 1);
		System.out.println("calls made : " + calls);
		return res;
	}

	public static long nearestSqrtFloor(long n) {
		long res = 1;
		for (; res * res <= n; res++);
		return res - 1;
	}

	public static long nearestSqrtCeil(long n) {
		long res = 0;
		for (; res * res < n; res++);
		return res;
	}

	public static long uniqueMultiplesSum(long f[], long limit, long mod) {
		return incExcSum(f, 0, 1L, 0, limit, mod);
	}

	private static long spfSum1 = 0L;
	private static long incExcSum1 = 0L;

	private static void P521IncExc(long f[], int start, long prod, int terms, long limit, long mod) {
		if (prod < 0) {
			throw new RuntimeException("possible overflow: prod = " + prod + " terms " + terms + " start " + start);
		}   
		if (terms == 1 || prod < 1000) {
			System.out.println("terms: " + terms + " prod " + prod);
		}
		for (int i = start; i < f.length; i++) {
			long newProd = prod * f[i];
			if (newProd > limit || (newProd / f[i] > prod) || (newProd / prod > f[i]) || (newProd < 0)) return;
			//if (newProd > limit) return;
			long n = limit / newProd;
			//long sigma_n = ((n % mod) * (n % mod + 1)) % mod;
			//sigma_n >>= 1;
			long sigma_n = n % mod;
			sigma_n = (n % 2 == 0 ? (sigma_n/2) * (sigma_n + 1) : sigma_n * (sigma_n + 1)/2);
			sigma_n %= mod;
//			System.out.println("sigman ... " + sigma_n);

			long ixVal = (sigma_n * newProd) % mod;
			long spfVal = (n * f[i]) % mod;
			if (0 == terms % 2) {
				incExcSum1 += ixVal;
				spfSum1 += spfVal;
				//System.out.println("n : " + n + " sigmn " + sigma_n + " newProd " + newProd + " Added ixSum " + incExcSum1 + " ixval " + ixVal + " spfSum " + spfSum1 + " spfVal " + spfVal);
			} else {
				incExcSum1 -= ixVal;
				spfSum1 -= spfVal;
//				System.out.println("n : " + n + " sigmn " + sigma_n + " newProd " + newProd + " Added ixSum " + incExcSum1 + " ixval " + ixVal + " spfSum " + spfSum1 + " spfVal " + spfVal);
			}
			incExcSum1 %= mod;
			spfSum1 %= mod;
			P521IncExc(f, i + 1, newProd, terms + 1, limit, mod);
		} 
	}

	public static long P521Result(long f[], long limit, long mod) {
		P521IncExc(f, 0, 1L, 0, limit, mod);
		long sigmaN = limit % mod;
		if (sigmaN % 2 == 0) sigmaN = (sigmaN/2) * (sigmaN + 1);
		else sigmaN = sigmaN * ((sigmaN + 1)/2);
		//sigmaN = (sigmaN * (sigmaN + 1)) % mod;
		sigmaN %= mod;
		
		long res = (sigmaN + spfSum1 - incExcSum1 - 1) % mod;
		while (res < 0) res += mod;
		System.out.println("final result from Util : " + res + " spfSum " + spfSum1 + " incExcSum " + incExcSum1 + " sigmaN " + sigmaN);
		return res;
	}

	public static long sigmaN_mod(long n, long mod) {
		long res = 1L;
		if (n % 2 == 0) res = ((n / 2) % mod) * ((n + 1) % mod);
		else res = (n % mod) * (((n + 1) / 2) % mod);
		return res %= mod;
	}

	public static long totient_brute(long n, long[] primes) {
		long res = n;
		long m = n;
		for (int i = 0; i < primes.length && primes[i] <= m; i++) {
			if (0 != m % primes[i]) continue;
			res /= primes[i];
			res *= primes[i] - 1;
		}
		return res;
	}

	private static long incExcSum(long f[], int start, long prod, int terms, long limit, long mod) {
		if (prod < 0) {
			throw new RuntimeException("possible overflow: prod = " + prod + " terms " + terms + " start " + start);
		}
		long sum = 0L;
		for (int i = start; i < f.length; i++) {
			long newProd = prod * f[i];
			if (newProd > limit || (newProd / f[i] > prod) || (newProd / prod > f[i]) || (newProd < 0)) return sum;
			long n = limit / newProd;
			long sigma_n = ((n % mod) * (n % mod + 1)) % mod;
			sigma_n >>= 1;

			long val = (sigma_n * newProd) % mod;
			if (0 == terms % 2) {
				sum += val;
				//				System.out.println("newProd " + newProd + " Added val " + val + " sum " + sum);
			} else {
				sum -= val;
				//			System.out.println("newProd " + newProd + " Subtracted val " + val + " sum " + sum);
			}
			sum %= mod;
			sum += incExcSum(f, i + 1, newProd, terms + 1, limit, mod);
		}
		return sum;
	}

	public static long smallestPrimeFactorsSum(long f[], long limit, long mod) {
		long result = spfSum(f, 0, 1L, 0, limit, mod);
		return result;
	}

	private static long spfSum(long f[], int start, long prod, int terms, long limit, long mod) {
		//		System.out.println("start: " + start + " prod " + prod + " terms " + terms);
		if (prod < 0) {
			throw new RuntimeException("possible overflow: prod = " + prod + " terms " + terms + " start " + start);
		}
		long sum = 0L;
		for (int i = start; i < f.length; i++) {
			long newProd = prod * f[i];
			if (newProd > limit || (newProd / f[i] > prod) || (newProd / prod > f[i]) || (newProd < 0)) return sum;
			long val = ((limit / newProd) * f[i]) % mod;
			if (0 == terms % 2) {
				sum += val;
				//			System.out.println("newProd " + newProd + " Added val " + val + " sum " + sum);
			} else {
				sum -= val;
				//				System.out.println("newProd " + newProd + " Subtracted val " + val + " sum " + sum);
			}
			sum %= mod;
			sum += spfSum(f, i + 1, newProd, terms + 1, limit, mod);
		}
		return sum;
	}
}

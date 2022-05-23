import java.util.*;

public class SieveOfEratosthenes {

    // ~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~
    public static void printPrimeUsingSieve(int n) {
        // write your code here
        boolean primes[] = new boolean[n + 1];
        Arrays.fill(primes, true);

        for (int i = 2; i < primes.length; i++) {
            if (primes[i] == false)
                continue;

            for (int j = i + i; j < primes.length; j+=i) {
                if (j % i == 0) {
                    primes[j] = false;
                }
            }
        }

        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

    }

    // ~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~
    public static Scanner scn = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scn.nextInt();
        printPrimeUsingSieve(n);
    }
}
package net.htlgkr.hafle.pos3.eratosthenesPrimeSieve;

public class EratosthenesPrimeSieve implements  PrimeSieve {
    static int n = 100;
    boolean[] isPrime = new boolean[n + 1];
    int[] onlyPrimes = new int[n];
    int counter = 0;

    @Override
    public boolean isPrime(int p) {

        for (int i = 2; i <= p; i++) {
            isPrime[i] = true;
        }
        for (int factor = 2; factor <= p; factor++) {

            if (isPrime[factor]) {
                for (int j = 2; factor * j <= n; j++) {
                    isPrime[factor * j] = false;
                }
            }
        }
        return isPrime[p];
    }

        @Override
        public void printPrimes (){
        int primes = 0;
            for (int i = 2; i <= n; i++) {
                if (isPrime[i]) primes++;
            }
            System.out.println("The number of primes <= " + n + " is " + primes);
        }

    public static void main(String[] args) {
        EratosthenesPrimeSieve e = new EratosthenesPrimeSieve();
        e.isPrime(n);
        e.printPrimes();

    }
}

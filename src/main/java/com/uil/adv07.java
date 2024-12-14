package com.uil;

import java.util.*;


public class adv07 {
    private static final Set<Integer> mersennePrimes = new LinkedHashSet<>();

    private static boolean[] sieve(int limit) {
        final boolean[] sieve = new boolean[limit + 1];
        Arrays.fill(sieve, true);

        final double upper = Math.sqrt(limit);
        for (int i = 2; i < upper; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    sieve[j] = false;
                }
            }
        }

        return sieve;
    }

    private static List<Integer> getPrimes(int limit) {
        final List<Integer> primes = new ArrayList<>();
        final boolean[] sieve = sieve(limit);
        for (int i = 2; i < sieve.length; i++) {
            if (sieve[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    private static boolean isPrime(final long num) {
        final double upper = Math.sqrt(num);
        for (int i = 2; i < upper; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static void computeMaxPrimes(final int amount) {
        int limit = 1000;
        while (mersennePrimes.size() < amount) {
            final List<Integer> primes = getPrimes(limit);
            for (int prime : primes) {
                int val = (2 << (prime - 1)) - 1;
                if (isPrime(val)) {
                    mersennePrimes.add(val);
                }
            }

            limit <<= 1;
        }
    }

    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int numLines = Integer.parseInt(scanner.nextLine());
        final List<Integer> amounts = new ArrayList<>(numLines);
        int maxAmount = 0;
        for (int i = 0; i < numLines; i++) {
            final int amount = Integer.parseInt(scanner.nextLine());
            amounts.add(amount);
            maxAmount = Math.max(amount, maxAmount);
        }

        computeMaxPrimes(maxAmount);

        final List<Integer> mersenne = new ArrayList<>(mersennePrimes);
        for (int amount : amounts) {
            for (int i = 0; i < amount; i++) {
                System.out.print(mersenne.get(i));
                if (i < amount - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

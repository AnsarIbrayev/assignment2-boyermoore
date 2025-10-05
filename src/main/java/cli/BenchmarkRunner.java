package cli;

import algorithms.BoyerMooreMajority;
import java.util.Random;

public class BenchmarkRunner {
    public static void main(String[] args) {
        int n = 1000000;
        int[] arr = new int[n];

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(10);
        }

        long start = System.currentTimeMillis();
        Integer result = BoyerMooreMajority.findMajorityElement(arr);
        long end = System.currentTimeMillis();

        System.out.println("Majority element: " + result);
        System.out.println("Execution time: " + (end - start) + " ms");
    }
}
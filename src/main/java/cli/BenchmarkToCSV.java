package cli;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class BenchmarkToCSV {

    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 100000, 1000000};
        String outputFile = "benchmark-results.csv";

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("n,time_ms\n");

            for (int n : sizes) {
                int[] arr = generateArray(n);
                long start = System.nanoTime();
                int result = boyerMooreMajority(arr);
                long end = System.nanoTime();

                double timeMs = (end - start) / 1_000_000.0;
                writer.write(n + "," + timeMs + "\n");
                System.out.println("n=" + n + " -> " + timeMs + " ms, result=" + result);
            }

            System.out.println("CSV saved to " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] generateArray(int n) {
        Random rand = new Random();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(100);
        }
        return arr;
    }

    private static int boyerMooreMajority(int[] nums) {
        int count = 0, candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
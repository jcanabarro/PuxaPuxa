package rcb;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static final int MAX = 50000;

    private static final int STEP = 1000;

    private static final String BRUTE_FORCE = "--bf";

    private static final String DIVIDE_AND_CONQUER = "--dc";

    public static void main(String[] args) throws IOException {
        String path;
        if (args.length == 2) {

            if (args[1].equals(BRUTE_FORCE)) {
                System.out.println("Brute force...");
            } else if (args[1].equals(DIVIDE_AND_CONQUER)) {
                System.out.println("Dividing and conquering...");
            } else {
                System.err.println("\uD83C\uDFB7 Invalid parameters. Should be path of directory and method (--bf or --dc)");
                System.exit(1);
            }

            for (int j = STEP; j < MAX; j += STEP) {
                path = args[0];
                File file = new File(path.concat("case-" + j + ".txt"));
                BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file));
                Scanner sc = new Scanner(bf);

                int size = Integer.parseInt(sc.nextLine());
                int[] vector = new int[size];

                for (int i = 0; i < size; i++) {
                    vector[i] = Integer.parseInt(sc.nextLine());
                }

                System.out.println("Case: " + j);

                int res = args[1].equals(BRUTE_FORCE) ? MaxSum.bruteForce(vector, size) : MaxSum.divideAndConquer(vector, 0, size - 1);

                System.out.println("Result:\t" + res);
                System.out.println("Sums:\t" + MaxSum.sums);
                System.out.println("Comparisons:\t" + MaxSum.comparisons);
                System.out.println("Total:\t" + MaxSum.comparisons + MaxSum.sums);
                System.out.println();
            }
        } else {
            System.err.println("\uD83C\uDFB7 Invalid parameters. Should be path of directory and method (--bf or --dc)");
        }

    }
}

package rcb;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static final int MAX = 50000;

    private static final int STEP = 1000;

    private static final String BRUTE_FORCE = "--bf";

    private static final String DIVIDE_AND_CONQUER = "--dc";

    private static void printErrorMessageAndExit() {
        System.err.println("\uD83C\uDFB7 Invalid parameters. Should be path of directory and method (--bf or --dc)");
        System.exit(1);
    }


    public static void main(String[] args) throws IOException {

        String path;

        Boolean bruteForce = false;

        if (args.length == 2) {
            switch (args[1]) {
                case BRUTE_FORCE:
                    System.out.println("Brute force...");
                    bruteForce = true;
                    break;
                case DIVIDE_AND_CONQUER:
                    System.out.println("Dividing and conquering...");
                    bruteForce = false;
                    break;
                default:
                    printErrorMessageAndExit();
                    break;
            }
        } else {
            printErrorMessageAndExit();
        }

        System.out.println("CASE\tRESULT\tSUMS\tCOMPARISONS\tTOTAL");

        for (int j = STEP; j <= MAX; j += STEP) {
            path = args[0];
            File file = new File(path.concat("case-" + j + ".txt"));
            BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file));
            Scanner sc = new Scanner(bf);

            int size = Integer.parseInt(sc.nextLine());
            int[] vector = new int[size];

            for (int i = 0; i < size; i++) {
                vector[i] = Integer.parseInt(sc.nextLine());
            }
            long res = bruteForce ? MaxSum.bruteForce(vector, size) : MaxSum.divideAndConquer(vector, 0, size - 1);
            System.out.println(j + "\t" + res + "\t" + MaxSum.sums + "\t" + MaxSum.comparisons + "\t" + (MaxSum.comparisons + MaxSum.sums));
        }
    }
}

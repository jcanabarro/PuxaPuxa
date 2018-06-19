package rcb;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static final int MAX=50000;
    private static final int STEP=1000;

    public static void main(String[] args) throws IOException {
        String path;
        if (args.length == 1) {
            for (int j = STEP; j < MAX; j+=STEP) {
                path = args[0];
                File file = new File(path.concat("case-" + j + ".txt"));
                BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file));
                Scanner sc = new Scanner(bf);

                int size = Integer.parseInt(sc.nextLine());
                int[] vector = new int[size];

                for (int i = 0; i < size; i++) {
                    vector[i] = Integer.parseInt(sc.nextLine());
                }

                int resBrute = MaxSum.bruteForce(vector, size);
                int resDivide = MaxSum.divideAndConquer(vector, 0, size - 1);
                System.out.println("Case: " + j);
                System.out.println("\tBrute Force: " + resBrute);
                System.out.println("\tDivide and Conquer: " + resDivide);
                System.out.println();
            }
        } else {
            System.err.println("\uD83C\uDFB7 Invalid parameters.");
        }

    }
}

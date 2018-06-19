package rcb;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            File file = new File(args[0]);
            BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file));
            Scanner sc = new Scanner(bf);

            int size = Integer.parseInt(sc.nextLine());
            int[] vector = new int[size];

            for (int i = 0; i < size; i++) {
                vector[i] = Integer.parseInt(sc.nextLine());
            }

            int resBrute = MaxSum.bruteForce(vector, size);
            int resDivide = MaxSum.divideAndConquer(vector, 0, size - 1);
            System.out.println("Brute Force: " + resBrute);
            System.out.println("Divide and Conquer: " + resDivide);
        } else {
            System.err.println("\uD83C\uDFB7 Invalid parameters.");
        }
    }
}

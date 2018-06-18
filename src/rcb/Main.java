package rcb;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	    if (args.length == 1){
	        File file = new File(args[0]);
	        BufferedInputStream bf = new BufferedInputStream(new FileInputStream(file));
            Scanner sc = new Scanner(bf);

            int size = Integer.parseInt(sc.nextLine());
            int[] vector = new int[size];

            for (int i = 0; i < size; i++){
                vector[i] = Integer.parseInt(sc.nextLine());
            }
	        int a = MaxSum.run(vector, size);
        }
    }
}

package rcb;

class MaxSum {

    static int run(int[] vector, int size){

        int maxSoFar = Integer.MIN_VALUE, maxEndingHere = 0;

        for (int i = 0; i < size; i++) {

            maxEndingHere = maxEndingHere + vector[i];

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }

            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }
}

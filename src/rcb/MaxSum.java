package rcb;

class MaxSum {

    static int bruteForce(int[] vector, int size) {
        int maxSoFar = 0;
        for (int i = 0; i < size; ++i) {
            for (int j = i; j < size; ++j) {
                int sum = 0;
                for (int k = i; k <= j; ++k) {
                    sum += vector[k];
                }
                maxSoFar = Math.max(maxSoFar, sum);
            }
        }

        return maxSoFar;
    }
}

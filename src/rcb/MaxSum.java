package rcb;

class MaxSum {

    static long sums = 0;

    static long comparisons = 0;

    static long bruteForce(int[] vector, int size) {
        long maxSoFar = 0;
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                long sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += vector[k];
                    sums++;
                }
                maxSoFar = Math.max(maxSoFar, sum);
                comparisons++;
            }
        }

        return maxSoFar;
    }

    static long divideAndConquer(int[] vector, int startIndex, int endIndex) {
        if (startIndex > endIndex) return 0;
        if (endIndex == startIndex) return Math.max(0, vector[startIndex]);
        int m = (int) Math.floor((startIndex + endIndex) / 2);
        long sum = 0, lMax = 0, rMax = 0;
        for (int i = m; i >= startIndex; i--) {
            sum += vector[i];
            lMax = Math.max(lMax, sum);
            sums++;
            comparisons++;
        }
        sum = 0;
        for (int i = m + 1; i <= endIndex; i++) {
            sum += vector[i];
            rMax = Math.max(rMax, sum);
            sums++;
            comparisons++;
        }

        comparisons++;
        long maxA = Math.max(lMax + rMax, divideAndConquer(vector, startIndex, m));
        comparisons++;
        return Math.max(maxA, divideAndConquer(vector, m + 1, endIndex));
    }
}

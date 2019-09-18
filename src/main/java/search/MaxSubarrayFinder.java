package search;

import java.util.ArrayList;
import java.util.List;

public class MaxSubarrayFinder {

    private static CrossingSubarrayResult findMaximumSubarray(List<Integer> A, int low, int high) {
        if (high == low) {
            return new CrossingSubarrayResult(low, high, A.get(low));
        }

        int mid = (low + high) / 2;
        CrossingSubarrayResult leftSubarrayResult = findMaximumSubarray(A, low, mid);
        CrossingSubarrayResult rightSubarrayResult = findMaximumSubarray(A, mid + 1, high);
        CrossingSubarrayResult crossingSubarrayResult = findMaxCrossingSubarray(A, low, mid, high);
        if (leftSubarrayResult.getSum() > rightSubarrayResult.getSum() &&
                leftSubarrayResult.getSum() > crossingSubarrayResult.getSum()) {
            return leftSubarrayResult;
        } else if (rightSubarrayResult.getSum() > leftSubarrayResult.getSum() &&
                rightSubarrayResult.getSum() > crossingSubarrayResult.getSum()) {
            return rightSubarrayResult;
        } else {
            return crossingSubarrayResult;
        }
    }

    private static CrossingSubarrayResult findMaxCrossingSubarray(List<Integer> A, int low, int mid, int high) {
        Integer leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = mid + 1;

        for (int i = mid; i >= low; i--) {
            sum = sum + A.get(i);
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        Integer rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = mid;

        for (int i = mid + 1; i <= high; i++) {
            sum = sum + A.get(i);
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }

        return new CrossingSubarrayResult(maxLeft, maxRight, leftSum + rightSum);
    }

    public List<Integer> findMaximumSubarray(List<Integer> list) {
        if (list.isEmpty()) {
            return list;
        }
        CrossingSubarrayResult result = findMaximumSubarray(list, 0, list.size() - 1);
        return new ArrayList<>(list.subList(result.getMaxLeft(), result.getMaxRight() + 1));
    }

    private static class CrossingSubarrayResult {
        private int maxLeft;
        private int maxRight;
        private int sum;

        CrossingSubarrayResult(int maxLeft, int maxRight, int sum) {
            this.maxLeft = maxLeft;
            this.maxRight = maxRight;
            this.sum = sum;
        }

        int getMaxLeft() {
            return maxLeft;
        }

        int getMaxRight() {
            return maxRight;
        }

        int getSum() {
            return sum;
        }
    }
}

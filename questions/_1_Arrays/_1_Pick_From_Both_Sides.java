package questions._1_Arrays;

/*
* Given an integer array A of size N.
* You have to pick exactly B elements from either left or right end of the array A to get maximum sum.
* Find and return this maximum possible sum.
*/
public class _1_Pick_From_Both_Sides {

    public int solve(ArrayList<Integer> A, int B) {

        int size = A.size();
        int maxSum = 0;

        // Consider first B number's sum as max
        for (int i = 0; i < B; i++) {
            maxSum += A.get(i);
        }

        // Then start a sliding sum and keep checking if any of the tempSum is > maxSum
        int tempSum = maxSum;
        for (int j = 0; j < B; j++) {
            // Remove one value from left, and add one value from right.
            tempSum = tempSum - A.get(B - 1 - j) + A.get(size - 1 - j);
            if (tempSum > maxSum) {
                maxSum = tempSum;
            }
        }

        return maxSum;

    }

    public static void main (String[] args) {
        int[] testArray = [ -533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684, 35 ];
        int count = 48;
        int result = 6253;

        System.out.println("Expected Result: " + result);
        System.out.println("Your Result: " + solve(testArray, count)); // Should return 6253
    }

}
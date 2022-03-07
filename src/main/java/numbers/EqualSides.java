package numbers;

//You are going to be given an array of integers. Your job is to take that array
// and find an index N where the sum of the integers to the left of N is equal
// to the sum of the integers to the right of N. If there is no index that would make this happen, return -1.
public class EqualSides {
    public static int findEvenIndex(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < arr.length; j++) {
                if (i < j) {
                    leftSum += arr[j];
                }
                if (i > j) {
                    rightSum += arr[j];
                }
            }
            if (leftSum == rightSum) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{6, 3, 1, 0, 1, 6, 3};
        int result = findEvenIndex(arr);
        System.out.println(result);
    }

}

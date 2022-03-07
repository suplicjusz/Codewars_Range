package numbers;

//Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.
//Additionally, if the number is negative, return 0 (for languages that do have them).
//Note: If the number is a multiple of both 3 and 5, only count it once.
public class MultiplesOf3Or5 {
    public static int solution(int number) {
        int sum = 0;
        for (int i = 0; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }
        if (sum < 0) {
            sum = 0;
        }
        return sum;
    }

    public static void main(String[] args) {
        int x = solution(-345);
        System.out.println(x);
    }
}

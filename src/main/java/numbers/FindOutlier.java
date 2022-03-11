package numbers;

import java.util.Arrays;

public class FindOutlier {

    static int find(int[] integers) {
        int counterEven = 0;
        int counterNotEven = 0;
        int indexEven = 0;
        int indexNotEven = 0;
        for (int i = 0; i < integers.length; i++) {
            if (integers[i] % 2 == 0) {
                counterEven++;
                indexEven = i;
            } else {
                counterNotEven++;
                indexNotEven = i;
            }
        }
        int result = 0;
        for (int i = 0; i < integers.length; i++) {
            if (counterEven == 1) {
                result = integers[indexEven];
            }
            if (counterNotEven == 1) {
                result = integers[indexNotEven];
            }
        }
        return result;
    }

    //Pro!
    static int find2(int[] integers) {
        int[] array = Arrays.stream(integers).filter(i -> i % 2 == 0).toArray();
        return array.length == 1 ? array[0] : Arrays.stream(integers).filter(i -> i % 2 != 0).findAny().getAsInt();
    }
    public static void main(String[] args) {
        int[] exampleTest2 = {206847684, 1056521, 7, 17, 1901, 21104421, 7, 1, 35521, 1, 7781};
        int x = find(exampleTest2);
        System.out.println(x);
    }


}

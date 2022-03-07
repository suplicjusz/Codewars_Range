package strings;
//Write a function that accepts an array of 10 integers (between 0 and 9),
// that returns a string of those numbers in the form of a phone number.
//Kata.createPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}) // => returns "(123) 456-7890"

public class CreatePhoneNumber {
    //My solution:
    public static String createPhoneNumber(int[] numbers) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            builder.append(numbers[i]);
        }
        String s = builder.toString();
        return "(" + s.substring(0, 3) + ") " + s.substring(3, 6) + " " + s.substring(6, 10);
    }

    // Brilliant solution!
    public static String createPhoneNumber2(int[] numbers) {
        String phoneNumber = new String("(xxx) xxx-xxxx");
        for (int i : numbers) {
            phoneNumber = phoneNumber.replaceFirst("x", Integer.toString(i));
        }
        return phoneNumber;
    }

    // The best:
    public static String createPhoneNumber3(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", java.util.stream.IntStream.of(numbers).boxed().toArray());
    }

    //It's possibility?
    public static String createPhoneNumber4(final int[] n) {
        return "("+n[0]+n[1]+n[2]+") "+n[3]+n[4]+n[5]+"-"+n[6]+n[7]+n[8]+n[9];
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String s = createPhoneNumber(num);
        System.out.println(s);
    }


}




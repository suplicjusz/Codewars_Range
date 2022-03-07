package strings;
//Complete the solution so that the function will break up camel casing, using a space between words.
public class BreakCamelCase {
    public static String camelCase(String input) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char temp = input.charAt(i);
            if (temp > 64 && temp < 91) {
                builder.append(" ").append(temp);
            } else {
                builder.append(temp);
            }
        }
        return builder.toString();
    }

    //Well... I'm stupid still... Below the best solution.
    public static String camelCase2(String input) {
        return input.replaceAll("([A-Z])", " $1");
    }

    public static void main(String[] args) {
        String s = "camelCaseExample";
        s = camelCase(s);
        System.out.println(s);
    }
}

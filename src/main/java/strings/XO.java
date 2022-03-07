package strings;
/*Check to see if a string has the same amount of 'x's and 'o's.
The method must return a boolean and be case-insensitive.
The string can contain any char.*/

public class XO {

    public static boolean getXO(String s) {

        int valueOfInstanceX = 0;
        int valueOfInstanceO = 0;

        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (s.charAt(i) == 88 || s.charAt(i) == 120) {
                valueOfInstanceX++;
            }
            if (s.charAt(i) == 79 || s.charAt(i) == 111) {
                valueOfInstanceO ++;
            }
        }
        return valueOfInstanceX == valueOfInstanceO;
    }

    public static void main(String[] args) {
        System.out.println(XO.getXO("OJOJXX"));
        System.out.println(XO.getXO("xxxXoOaasasa"));
    }
}

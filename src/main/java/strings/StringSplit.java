package strings;
/*Complete the solution so that it splits the string into pairs of two characters.
If the string contains an odd number of characters then it should replace the missing second character of
the final pair with an underscore ('_').*/

public class StringSplit {

    public static String[] solution(String s) {
        String[] array;
        if (s.length() %2 == 0) {
            array = new String[s.length() / 2];
            int x = 0;
            int y = 2;
            for (int i = 0; i < array.length; i++) {
                array[i] = s.substring(x, y);
                x += 2;
                y += 2;
            }
        } else {
            array = new String[s.length()/2 + 1];
            int x = 0;
            int y = 2;
            for (int i = 0; i < array.length -1 ; i++) {
                array[i] = s.substring(x, y);
                x += 2;
                y += 2;
            }
            array[array.length - 1] = s.charAt(s.length() - 1) + "_";

        }
        return array;
    }

    public static void main(String[] args) {
        String[] tab = StringSplit.solution("qwerty");
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i]);
        }
    }
}

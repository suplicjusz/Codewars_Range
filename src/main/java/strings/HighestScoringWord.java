package strings;

import java.util.Arrays;
import java.util.Comparator;

public class HighestScoringWord {
    public static String high(String s) {
        String[] arr = s.split(" ");
        int[] points = new int[arr.length];
        String temp = "";
        for (int i = 0; i < arr.length; i++) {
            temp = arr[i];
            for (int j = 0; j < temp.length(); j++) {
                points[i] += countPoints(temp.charAt(j));
            }
        }
        int index = 0;
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            if (points[i] > max) {
                max = points[i];
                index = i;
            }
        }
        return arr[index];
    }

    public static int countPoints(char ch) {
        if (ch >= 65 && ch <= 90) {
            return ch - 64;
        }
        if (ch >= 97 && ch <= 122) {
            return ch - 96;
        }
        return 0;
    }

    //The best solution from CodeWars
    public static String high2(String s) {
        return Arrays.stream(s.split(" "))
                .max(Comparator.comparingInt(
                        a -> a.chars().map(i -> i - 96).sum()
                )).get();
    }

    //The most enjoyable solution
    public static String high3(String s) {

        String winner = "";
        int highScore = 0;

        for (String word : s.split(" ")) {
            int score = 0;
            for (char c : word.toCharArray()) {
                score += c - 'a' + 1;
            }
            if (score > highScore) {
                winner = word;
                highScore = score;
            }
        }

        return winner;
    }

    public static void main(String[] args) {
        String word = "man i need a taxi up to u bud";
        word = high(word);
        System.out.println(word);
    }


}

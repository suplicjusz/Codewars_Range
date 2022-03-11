package strings;
/*An isogram is a word that has no repeating letters, consecutive or non-consecutive.
Implement a function that determines whether a string that contains only letters is an isogram.
Assume the empty string is an isogram. Ignore letter case. */

import java.util.Arrays;

public class Isogram {

    public static boolean isIsogram(String str) {
        str = str.toLowerCase();
        char[] array = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            array[i] = str.charAt(i);
        }
        Arrays.sort(array);
        char temp1;
        char temp2;
        for (int i = 0; i < array.length - 1; i++) {
            temp1 = array[i];
            temp2 = array[i + 1];
            if(temp1 == temp2){
                return false;
            }
        }
        return true;
    }

    //The best Answer
    public static boolean isIsogram2(String str){
        return str.length() == str.toLowerCase().chars().distinct().count();
    }


    public static void main(String[] args) {
        System.out.println(Isogram.isIsogram("qwertyY"));
        System.out.println(Isogram.isIsogram("qwerty"));
        System.out.println(Isogram.isIsogram("qwertyq"));

    }
}

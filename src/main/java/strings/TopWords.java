package strings;

import java.util.*;

public class TopWords {
    public static List<String> top3(String s) {
        s = s.toLowerCase();
        StringBuilder builder = new StringBuilder();
        if (s.charAt(0) != 32) {
            builder.append(s.charAt(0));
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == 39 || (s.charAt(i) > 96 && s.charAt(i) < 123) || (s.charAt(i) == 32 && s.charAt(i - 1) != 32)) {
                builder.append(s.charAt(i));
            }
        }
        String[] arr = builder.toString().split(" ");
        List<String> stringList = new ArrayList<>(Arrays.asList(arr));
        Map<String, Integer> wordsMap = new TreeMap<>();
        for (String word : stringList) {
            if (!wordsMap.containsKey(word)) {
                wordsMap.put(word, 1);
            } else {
                wordsMap.put(word, wordsMap.get(word) + 1);
            }
        }
        String temp = wordsMap.toString();
        temp = temp.substring(1, temp.length() - 1);

        List<String> stringList1 = List.of(temp.split(", "));
        List<String> stringList2 = new ArrayList<>(stringList1);

        String firstPlace = "";
        String secondPlace = "";
        String thirdPlace = "";
        int tempInt = 0;
        int tempIndex = 0;
        if (stringList.size() > 0) {
            for (int i = 0; i < stringList2.size(); i++) {
                if (getNumber(stringList2.get(i)) > tempInt && stringList2.get(i).charAt(0) != '\'') {
                    firstPlace = stringList2.get(i);
                    tempInt = getNumber(stringList2.get(i));
                    tempIndex = i;
                }
            }
            stringList2.remove(tempIndex);
        }
        if (stringList2.size() > 0) {
            tempInt = 0;
            for (int i = 0; i < stringList2.size(); i++) {
                if (getNumber(stringList2.get(i)) > tempInt && stringList2.get(i).charAt(0) != '\'') {
                    secondPlace = stringList2.get(i);
                    tempInt = getNumber(stringList2.get(i));
                    tempIndex = i;
                }
            }
            stringList2.remove(tempIndex);
        }
        if (stringList2.size() > 0) {
            tempInt = 0;
            for (int i = 0; i < stringList2.size(); i++) {
                if (getNumber(stringList2.get(i)) > tempInt && stringList2.get(i).charAt(0) != '\'') {
                    thirdPlace = stringList2.get(i);
                    tempInt = getNumber(stringList2.get(i));
                }
            }
        }
        System.out.println(firstPlace);
        System.out.println(secondPlace);
        System.out.println(thirdPlace);///
        firstPlace = cutNumber(firstPlace);
        secondPlace = cutNumber(secondPlace);
        thirdPlace = cutNumber(thirdPlace);
        List<String> result = new ArrayList<>();
        if (!firstPlace.equals("")) {
            result.add(firstPlace);
        }
        if (!secondPlace.equals("")) {
            result.add(secondPlace);
        }
        if (!thirdPlace.equals("")) {
            result.add(thirdPlace);
        }
        return result;
    }

    public static int getNumber(String s) {
        int x = 0;
        int counter = 1;
        for (int i = s.length() - 1; i > -1; i--) {
            if (Character.isDigit(s.charAt(i))) {
                x += (s.charAt(i) - 48) * counter;
                counter *= 10;
            }
        }

        return x;
    }

    public static String cutNumber(String s) {
        int cutHere = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 61) {
                cutHere = i;
            }
        }
        return s.substring(0, cutHere);
    }


    public static void main(String[] args) {
        String s = " Ala has a cats and cats are cute#    and cats are an animals. Ala's cats are called: Filemon and Boniface ";
        String a = "  //wont won't won't ";
        String c = "    '    ";
        List<String> list = top3(c);
        System.out.println(list);

    }
}

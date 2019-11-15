package ru.job4j.comparator;

import java.util.Comparator;

public class ListCompare  implements Comparator<String> {
    @Override
    public  int compare(String left, String right) {
        int result = left.length() - right.length();
        int length = right.length();
        if (result < 0) {
            length = left.length();
        }
        for (int i = 0; i < length; i++) {
            if (Character.compare(left.charAt(i), right.charAt(i)) != 0) {
                result = Character.compare(left.charAt(i), right.charAt(i));
                break;
            }
        }
        return result;
    }
}


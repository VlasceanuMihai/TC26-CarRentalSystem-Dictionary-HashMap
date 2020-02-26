package Ex242_ValidAnafram_Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Project: Ex242ValidAnagram
 * Author: mihai
 * Date: 2/24/2020
 */
public class Ex242ValidAnagram_Sort {
    public static boolean sortMethod(String s, String t){
        if (s.length() != t.length()){
            return false;
        }

        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();

        Arrays.sort(sChar);
        Arrays.sort(tChar);

        return Arrays.equals(sChar, tChar);
    }


    public static boolean isAnagram(String s, String t){
        if (s.length() != t.length()){
            return false;
        }

        List<Character> sList = new ArrayList<>();
        for (char sChar : s.toCharArray()){
            sList.add(sChar);
        }
        List<Character> tList = new ArrayList<>();
        for (char tChar : t.toCharArray()){
            tList.add(tChar);
        }

        Collections.sort(sList);
        Collections.sort(tList);

        return sList.equals(tList);
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }
}

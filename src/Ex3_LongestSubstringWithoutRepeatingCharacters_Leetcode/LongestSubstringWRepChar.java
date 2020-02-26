package Ex3_LongestSubstringWithoutRepeatingCharacters_Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: TemaC26
 * Author: mihai
 * Date: 2/25/2020
 */
public class LongestSubstringWRepChar {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;

        for (int i = 0, j = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (map.containsKey(c)){
                j = Math.max(j, map.get(c) + 1);
            }

            map.put(c, i);
            max = Math.max(max, i + 1 - j);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "dvdf";

        System.out.println(lengthOfLongestSubstring(s));
    }
}

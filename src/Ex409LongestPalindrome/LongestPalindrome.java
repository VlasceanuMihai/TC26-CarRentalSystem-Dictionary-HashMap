package Ex409LongestPalindrome;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Project: TemaC26
 * Author: mihai
 * Date: 2/25/2020
 */
public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        int counter = 0;
        int temp = 0;

        if (s == null){
            return 0;
        }else if (s.length() > 1010){
            throw new IndexOutOfBoundsException();
        }

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++){
            char character = s.charAt(i);
            map.put(character, map.getOrDefault(character,0) + 1);
        }

        for (Map.Entry<Character, Integer> mapEl : map.entrySet()){
            char key = mapEl.getKey();
            int value = mapEl.getValue();

            if (value > 1){
                counter += (value / 2) * 2;
                if (counter % 2 == 0 && value % 2 == 1){
                    counter++;
                }
            }
        }

        return (counter + temp);
    }

    public static void main(String[] args) {
        String s = "bananas";

        System.out.println(longestPalindrome(s));
    }
}

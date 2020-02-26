package Ex387FirstUniqueCharacterInString;

import java.util.HashMap;
import java.util.Map;

/**
 * Project: TemaC26
 * Author: mihai
 * Date: 2/25/2020
 */
public class FirstUniqueCharacterInString {
    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            char character = s.charAt(i);
            map.put(character, map.getOrDefault(character, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++){
            char character = s.charAt(i);
            if (map.get(character) == 1){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String s = "leetcode";

        System.out.println(firstUniqChar(s));
    }
}

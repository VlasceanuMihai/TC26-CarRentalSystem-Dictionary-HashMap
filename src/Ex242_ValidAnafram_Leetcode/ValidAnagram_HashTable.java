package Ex242_ValidAnafram_Leetcode;

/**
 * Project: Ex242ValidAnagram
 * Author: mihai
 * Date: 2/24/2020
 */
public class ValidAnagram_HashTable {
    public static boolean isAnagram(String s, String t){
        if (s.length() != t.length()){
            return false;
        }

        // a-z => 26 characters
        char[] temp = new char[26];

        for (int i = 0; i < s.length(); i++){
            temp[s.charAt(i) - 'a']++;
            temp[t.charAt(i) - 'a']--;
        }

        for (char c : temp){
            if (c != 0){
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }
}

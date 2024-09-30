/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package medium;

import java.util.ArrayList;

/**
 * QUESTION: 
 * Given a string s, find the length of the longest substring 
 * without REPEATING CHARACTERS.
 *
 * @author m.yusufsonmez03@gmail.com
 */
public class LongestSubstring {

    public static int lenghtOfLongestSubstring(String s) {
        int len = s.length();
        ArrayList<Character> letterArrayList = new ArrayList<>(len);

        int currentSubStrLen = 0;
        int longestSubStrLen = 0;

        for (int i = 0; i < len; i++) {
            letterArrayList.clear();
            for (int j = i; j < len; j++) {
                char lastChar = s.charAt(j);
                if (!letterArrayList.contains(lastChar)) {
                    letterArrayList.add(lastChar);
                } else {
                    break;
                }
                currentSubStrLen = letterArrayList.size();

            }
            if (currentSubStrLen > longestSubStrLen) {
                longestSubStrLen = currentSubStrLen;
            }
        }
        return longestSubStrLen;
    }
}

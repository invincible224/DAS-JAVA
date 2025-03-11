package SlidingWindow;

import java.util.HashSet;
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, maxLen = 0;
        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));  // Remove leftmost character
                left++;  // Shrink window
            }
            set.add(s.charAt(right));  // Add new character
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}



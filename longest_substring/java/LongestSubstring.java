package longest_substring.java;

import java.util.LinkedList;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) return 0;
        
        final var len = s.length();
        var visited = new LinkedList<Character>();
        var longest = 1;
        var currRun = 0;
        
        var i = 0;
        while (i < len) {
            var currChar = s.charAt(i);
            
            // Repeatedly remove first, 
            // until same char as current is removed
            if (visited.contains(currChar)) {
                for (int j = 0; j < i; j++) {
                    currRun--;
                    final var firstChar = visited.removeFirst();
                    if (firstChar == currChar) break;
                }
            }
            
            visited.add(currChar);
            currRun++;
            longest = Math.max(longest, currRun);
            i++;
        }
        return longest;
    }
}
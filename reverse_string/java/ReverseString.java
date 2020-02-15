package reverse_string.java;

class Solution {
    public void reverseString(char[] s) {
        var start = 0;
        var end = s.length - 1;
        
        while (start >= 0 && start < s.length
              && end >= 0 && end < s.length
              && start < end) {
            
            var temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            
            start++;
            end--;
        }
    }
}
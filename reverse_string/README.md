# Reverse String
Write a function that reverses a string. The input string is given as an array of characters `char[]`.
Do not allocate extra space for another array, you must do this by **modifying the input array in-place** with `O(1)` extra memory.
You may assume all the characters consist of printable ascii characters.

## Example 1
**Input:** `["h","e","l","l","o"]`\
**Output:** `["o","l","l","e","h"]`\

## Example 2
**Input:** `["H","a","n","n","a","h"]`\
**Output:** `["h","a","n","n","a","H"]`\

## Solution in Java
```java
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
```

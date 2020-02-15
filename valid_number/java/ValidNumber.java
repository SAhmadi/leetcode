package valid_number.java;

import java.util.regex.*;

class Solution {
    public boolean isNumber(String s) {
        var isMatch = Pattern
            .compile("\\s*(\\-|\\+)?([0-9]*\\.?[0-9]+|[0-9]+\\.)(e(\\-|\\+)?[0-9]+)?\\s*")
            .matcher(s)
            .matches();
        
        return isMatch;
    }
}
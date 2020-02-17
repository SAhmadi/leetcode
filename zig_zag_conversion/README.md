# ZigZag Conversion
The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

```
P _ A _ H _ N
A P L S I I G
Y _ I _ R _ _
```

And then read line by line: `"PAHNAPLSIIGYIR"`
Write the code that will take a string and make this conversion given a number of rows:

`string convert(string s, int numRows);`

**Example 1**
**Input:** `s = "PAYPALISHIRING", numRows = 3`
**Output:** `PAHNAPLSIIGYIR`

**Example 2**
**Input:** `s = "PAYPALISHIRING", numRows = 4`
**Output:** `PINALSIGYAHRPI`
**Explanation:**
```
P _ _ I _ _ N
A _ L S _ I G
Y A _ H R _ _
P _ _ I _ _ _
```

## Solution in Java
```java
package zig_zag_conversion.java;

import java.util.Comparator;
import java.util.TreeMap;

class Solution {
    public String convert(String s, int numRows) {
        final var sortedMap = new TreeMap<Integer[], Character>(new Comparator<Integer[]>() {
            @Override public int compare(Integer[] arr1, Integer[] arr2) {
                if (arr1.length != 2 || arr2.length != 2) throw new IllegalArgumentException();
                if (arr1[0] < arr2[0]) return -1; // arr1 is smaller
                if (arr1[0] == arr2[0] && arr1[1] < arr2[1]) return -1; // arr1 is smaller
                if (arr1[0] == arr2[0] && arr1[1] > arr2[1]) return 1; // arr1 is bigger
                return 1; // arr1 is bigger
            }
        });
 
        final var res = new StringBuilder();
        var diagonalUp = false;
        
        for (int i = 0, row = 0, col = 0; i < s.length(); i++) {
            row = (row >= numRows - 1) ? numRows - 1 : row;
            diagonalUp = (row >= numRows - 1) ? true : diagonalUp;
        
            row = (row <= 0) ? row = 0 : row;
            diagonalUp = (row <= 0) ? false : diagonalUp;
            
            sortedMap.put(
                new Integer[]{ Integer.valueOf(row), Integer.valueOf(col) },
                Character.valueOf(s.charAt(i))
            );
            
            if (diagonalUp) { row--; col++; }
            else row++;   
        }
        
        for (var entry : sortedMap.entrySet()) {
            if (entry.getValue().toString().equals("\u0000"))
                res.append("");
            else
                res.append(entry.getValue().toString());
        }
        return res.toString();
    }
    
}
```

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
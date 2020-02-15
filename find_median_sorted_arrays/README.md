# Find Median Sorted Arrays
There are two sorted arrays `nums1` and `nums2` of size `m` and `n` respectively.
Find the median of the two sorted arrays. The overall run time complexity should be **O(log (m+n))**.
You may assume nums1 and nums2 cannot be both empty.

## Example 1
`nums1 = [1, 3]`\
`nums2 = [2]`\
`The median is 2.0`

## Example 2
`nums1 = [1, 2]`\
`nums2 = [3, 4]`\
`The median is (2 + 3) / 2 = 2.5`

## Solution in Java
```java
package find_median_sorted_arrays.java;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var total = new int[nums1.length + nums2.length];
        
        var i = 0;
        var j = 0;
        var counter = 0;
        while (i < nums1.length || j < nums2.length) {
            var elem = -1;
            
            if (i >= nums1.length && j < nums2.length) {
                elem = nums2[j];
                j++;
            }
            else if (j >= nums2.length && i < nums1.length) {
                elem = nums1[i];
                i++;
            }
            else {
                elem = (nums1[i] <= nums2[j]) ? nums1[i] : nums2[j];

                if (nums1[i] <= nums2[j]) i++;
                else j++;
            }
            total[counter++] = elem;
        }
        
        if (total.length % 2 == 0)
            return (total[total.length/2 - 1] + total[total.length/2]) / 2.0;
        
        return total[total.length / 2] * 1.0;
  }
}
```
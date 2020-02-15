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
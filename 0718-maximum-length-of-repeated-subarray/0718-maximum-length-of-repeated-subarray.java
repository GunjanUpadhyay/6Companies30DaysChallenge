class Solution {
    public int findLength(int[] nums1, int[] nums2) {
         int m = nums1.length;
    int n = nums2.length;
    int maxLen = 0;

    for (int i = 0; i < m; i++) {
        int len = 0; // Length of the current common subarray
        for (int j = 0; j < n; j++) {
            int k = i; 
            int l = j; 
            while (k < m && l < n && nums1[k] == nums2[l]) {
                k++; // Move pointer in nums1
                l++; // Move pointer in nums2
                len++; 
            }
            maxLen = Math.max(maxLen, len);

            len = 0; // Reset len for the next subarray
        }
    }
    return maxLen;
    }
}
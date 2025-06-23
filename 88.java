import java.util.*;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[m+n];
        int i=0;
        int j=0;

        int pos=0;
        while(i<m && j < n){
            if(nums1[i] <= nums2[j])
                ans[pos++]=nums1[i++];
            else
                ans[pos++]=nums2[j++];
        }
        while(i<m){
            ans[pos++]=nums1[i++];
        }

        while(j<n){
            ans[pos++]=nums2[j++];
        }

        // 把数组拷贝回nums1
        System.arraycopy(ans, 0, nums1, 0, m+n);
    }
}
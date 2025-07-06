class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int [] merge = new int[m+n];

        int i=0,j=0,p=0;
        while(i<n && j<m){
            if(nums1[i] <= nums2[j]){
                merge[p++] = nums1[i++];
            }else{
                merge[p++] = nums2[j++];
            }
        }
        while(i<n){
            merge[p++] = nums1[i++];
        }
        while(j<m){
            merge[p++] = nums2[j++];
        }

        if(merge.length % 2 == 1){
            return merge[merge.length/2];
        }else{
            return (double)(merge[merge.length/2-1] + merge[merge.length/2] ) / 2;
        }
    }
}
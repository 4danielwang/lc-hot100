class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;

        // 中位数对应的下标
        // eg: 1,2,3,4,5
        // eg: 1,2,3,4,5,6
        int leftK = (n+m+1)/2;
        int rightK = (n+m+2)/2;

        // 分别计算中位数所对应的两个k的第k小的值
        // 奇数 两个k相等
        // 偶数 两个k不等 平均
        return (getKth(nums1,0,m-1,nums2,0,n-1,leftK)+getKth(nums1,0,m-1,nums2,0,n-1,rightK))*0.5;
    }

    /**
      * 找到两个有序数组中第k大的值
      * left1 nums1的开始下标
      * right1 nums1的结束下标
      * nums2 left2 right2同理
     */
    private int getKth(int[] nums1, int left1, int right1, int[] nums2, int left2, int right2, int k){
        // 计算两个数组当前长度
        int len1 = right1-left1+1;
        int len2 = right2-left2+1;

        // 保证len1一定更小 只能是len1先空 只需要处理len1==0的问题
        if(len1 > len2){
            return getKth(nums2, left2, right2, nums1, left1, right1, k);
        }
        // 第一个数组为空 直接从第二个数组拿结果
        if(len1 == 0){
            return nums2[left2+k-1];
        }
        // 只要找第一小的 直接比较left1 left2
        if(k==1){
            return Math.min(nums1[left1], nums2[left2]);
        }

        // 找到两个数组中各自k/2位置
        int i = left1 + Math.min(len1, k/2) - 1;
        int j = left2 + Math.min(len2, k/2) - 1;

        // 直接丢弃更小的那k/2
        if(nums1[i] <nums2[j]){
            return getKth(nums1, i+1, right1, nums2, left2, right2, k - (i-left1+1));
        }else{
            return getKth(nums1, left1, right1, nums2, j+1, right2, k - (j-left2+1));
        }
    }

}
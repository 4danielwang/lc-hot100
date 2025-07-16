class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        // 保存副本
        int[] copy = Arrays.copyOf(nums, n);
        int j=0; // copy的下标
        k = k % nums.length;
        // public static native void arraycopy(Object src,  int  srcPos,
        //                             Object dest, int destPos,
        //                             int length);
        System.arraycopy(copy, n-k, nums, 0, k);
        System.arraycopy(copy, 0, nums, k, n-k);
    }
}
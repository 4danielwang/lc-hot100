class Solution {
    public int mySqrt(int x) {
        
        // 二分查找 最后的值 平方一定是小于等于x的
        int l=0;
        int r=x;
        int ans=-1;
        while(l<=r){
            int mid = l + (r-l)/2;
            
            // mid*mid可能会溢出
            if((long)mid*mid <=x){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }
}
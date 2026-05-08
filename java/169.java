class Solution {
    // 时间O(n) 空间O(1)
    public int majorityElement(int[] nums) {
        // 每个数都是一个挑战者 ans是当前的擂主 
        // hp记录生命值
        // 返回最后的擂主（挑战者）
        int ans = 0;
        int hp  = 0;

        // 每个数是一个挑战者
        for(int n : nums){
            // 下一个挑战者为新的擂主
            if(hp == 0){
                ans = n;
                hp = 1;
            }else{
                // 同一个门派（相同的值）hp+1，否则-1
                hp += (n == ans) ? 1 : -1;
            }
        }
        return ans;
    }
}
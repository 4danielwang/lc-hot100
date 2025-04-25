import java.util.*;
class Solution {
    public int maxArea(int[] height) {
        // 双指针 i和j中间的范围代表搜索空间，也就是没有被扫描的范围
        // 最低的指针确定水面高度
        // 确定决定水面高度的那个指针，另一个指针无论怎么移动，容量都会变小
        // 最小高度已经由另一个指针确定了，宽度一直缩减，所以不需要扫描i~j的范围了
        // 缩减范围，让最低指针向右移动，扫描i+1~j

        int i=0; // 左指针
        int j=height.length-1; // 右指针

        int max_vol = 0; // 最大容量
        // 指针相遇 没有剩余搜索空间
        while(i!=j){
            // 如果是左侧指针决定最小水面高度
            // 向右缩小左侧范围，继续寻找
            if(height[i]<height[j]){
                max_vol = Math.max((j-i) * height[i], max_vol);
                i++;
            }else{ 
                // 如果是右侧指针决定最低高度
                // 向左缩小寻找范围，继续寻找
                max_vol = Math.max((j-i) * height[j], max_vol);
                j--;
            }
        }
        return max_vol;
    }
}
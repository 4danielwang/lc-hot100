/**
 * @description: 把nums数组排列,组成一个最大的数
 * [3,30,34,5,9] -> 9534330
 * 排序规则 [x,y]如果xy>yx 则x排在y前面
 */
class Solution {
    // 需要把两个字符串组合起来
    // a,b 看看ab大还是ba大
    public String largestNumber(int[] nums) {
        // 把int[]转为String[]
        String[] numStrs = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            numStrs[i] = String.valueOf(nums[i]);
        }

        // 需要降序排列数字
        Arrays.sort(numStrs, (a,b)->{
            String o1 = a+b;
            String o2 = b+a;
            // a.compare(b): 判断a-b的正负 a<b返回负数 a>b返回正数
            // 升序排列 需要a<b时候 返回负数 a>b时候返回正数
            // 降序排列 需要a<b时候 返回正数 a>b时候返回负数
            return o2.compareTo(o1); // 当o1<o2 返回o2-o1是正数 满足降序条件
        });

        // 如果最高的数就是0 其他也全为0
        if(numStrs[0].equals("0")){
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for(String s : numStrs){
            sb.append(s);
        }
        return sb.toString();
    }
}
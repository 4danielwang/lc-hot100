class Solution {
    // 需要把两个字符串组合起来
    // a,b 看看a+b大还是b+a大
    // 字符串比较大小，比较字典序
    public String largestNumber(int[] nums) {
        // 把int[]转为String[]
        String[] numStrs = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            numStrs[i] = String.valueOf(nums[i]);
        }

        // 排序
        // lambda定义比较规则
        Arrays.sort(numStrs, (a,b)->{
            String o1 = a+b;
            String o2 = b+a;
            // 注意 comparator用法 两个参数a和b
            // a<b返回负数 a>b返回正数 ：升序
            // a>b返回负数 a<b返回正数 ：降序
            // 字符串的compareTo默认按照按照字典序降序排列
            return o2.compareTo(o1); 
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
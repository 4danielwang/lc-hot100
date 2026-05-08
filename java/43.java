class Solution {
  // leetcode 415 字符串相加
    private String addString(String s1, String s2){
        StringBuilder sb = new StringBuilder();
        int carry=0; // 进位
        
        // 从末尾开始加 更新carry
        for(int i=s1.length()-1, j=s2.length()-1;i>=0 || j>=0 || carry !=0; i--,j--){
            int x = i<0?0:s1.charAt(i)-'0'; //只剩下carry的时候 
            int y = j<0?0:s2.charAt(j)-'0'; //只剩下carry的时候 
            int sum = (x+y+carry) %10;
            carry = (x+y+carry) / 10;
            sb.append(sum);
        }
        // 从末尾倒着计算 需要再翻转一次
        return sb.reverse().toString();
    }

    public String multiply(String num1, String num2) {
        // 其中一个为0 直接返回
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        // 遍历num2的每一位，与num1相乘
        // 计算两个字符串的和 每多一位 后面要加一个0
        String ans = "0";

        // 同样是从低位到高位计算累加
        for(int i=num2.length()-1;i>=0;i--){
            int carry=0;
            StringBuilder sb = new StringBuilder();
            // 补0 计算需要补几个0
            int zeros = num2.length()-1-i;
            for(int j=0;j<zeros;j++){
                sb.append(0);
            }
            // num2用来乘的那位数
            int n2 = num2.charAt(i)-'0'; 
            
            // 计算num1 * n2的结果
            // 遍历num1的每一位
            for(int j=num1.length()-1;j>=0 || carry!=0;j--){
                int n1 = j<0?0:num1.charAt(j)-'0'; //只剩下carry的时候 
                int product = (n1*n2+carry)%10;
                carry = (n1*n2+carry)/10;
                sb.append(product);
            }
             // 累加两数之和
            ans = addString(ans, sb.reverse().toString());
        }
       
        return ans;
    }
}
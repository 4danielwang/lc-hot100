class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int i=num1.length()-1,j=num2.length()-1,carry=0;

        // 从字符串末尾开始相加
        while(i>=0 || j>=0){
            // 越界给默认值0
            int n1 = i>=0 ? num1.charAt(i)-'0': 0;
            int n2 = j>=0 ? num2.charAt(j)-'0': 0;
            sb.append((n1+n2+carry)%10);
            carry = (n1+n2+carry)/10;
            i--;
            j--;
        }
        // 不要忘了最后判断下carry
        if(carry == 1)
            sb.append("1");
        return sb.reverse().toString();
    }
}
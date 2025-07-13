import java.util.regex.*;

class Solution {
    public int myAtoi(String s) {
        // 正则表达式 筛选到数字的部分
        // 正则表达式的特殊字符需要转义
        Pattern pattern = Pattern.compile("^\\s*([+-]?\\d+).*");
        Matcher matcher = pattern.matcher(s);

        if(matcher.find()){
            String num = matcher.group(1);
            try{
                // Long.parseLong 避免直接 Integer.parseInt 溢出
                long ans = Long.parseLong(num);
                if (ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if (ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
                return (int) ans;
            }catch(NumberFormatException e){
                //Long.parseLong 失败（如数字过长），根据符号返回 MIN_VALUE 或 MAX_VALUE
                return num.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
           
        }
        return 0;
    }
}
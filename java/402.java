/**
 * @description: 一个字符串数字num,删除其中k位数字,使得数字最小,返回删除k位后的最小数字字符串
 *               输出不能有前导0,如果删除后没有数字了,返回0
 *               "1432219", k = 3 -> "1219"
 *               尽可能让高位(左边)的数字保持最小:
 *               从左到右扫描数字,发现前面一个数字大于后面数字时,删除这个前面的大数字,用单调栈维持单调不降的数字序列
 */
class Solution {
    // 时间O(n) 空间O(n)
    public String removeKdigits(String num, int k) {
        // 栈 存放最终保留的数字字符串
        Deque<Character> deque = new LinkedList<Character>();
        int length = num.length();
        // 从左到右扫描数字
        for (int i = 0; i < length; ++i) {
            // 出栈: 当栈不为空且还要继续删数字(k>0)切栈顶元素大于当前的digit
            char digit = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            // digit入栈
            deque.offerLast(digit);
        }
        // 如果k>0 继续从右往左删数字
        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }

        StringBuilder ret = new StringBuilder();
        // 去掉前导0
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            // 跳过所有的前导0
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            ret.append(digit);
        }
        // 如果删除后没有数字了,返回0
        return ret.length() == 0 ? "0" : ret.toString();
    }
}
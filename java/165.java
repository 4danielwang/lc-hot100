/**
 * @description: 比较两个版本号 version1 和 version2。修订号的值是它转换为整数并忽略前导零
 * @example: 输入 1.2, 1.10 输出 -1
 * @example: 输入 1.01, 1.001 输出 0
 * @example: 输入 1.0, 1.0.0 输出 0
 * 思路：双指针，不断地解析出两个版本号的每一段数字进行比较，按位计算每个数字的大小。不存在的版本号段视为0
 */
class Solution {
    // 时间O(n+m) 空间O(1)
    public int compareVersion(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }
}
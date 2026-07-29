/**
 * 这里定义的是公共类
 */
// 链表节点定义
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// 二叉树节点定义
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

// 开区间找到第一个大于等于target的下标
// 延伸：upperBound = lowerBound(target+1) - 1
private int lowerBound(int[] nums, int target){
    // 循环不变量：
    // nums[left] < target
    // nums[right] >= target
    // 开区间 (left, right) 结束条件为left+1=right
    int left = -1, right = nums.length;
    while (left + 1 < right) {
        int mid = (right - left) / 2 + left;
        if (nums[mid] < target){ // 应该往右边区间找
            left = mid;
        } else {
            right = mid;
        }
    }

    // 循环结束后 left+1 = right
    // 此时 nums[left] < target 而 nums[right] >= target
    // 所以 right 就是第一个 >= target 的元素下标
    return right; // 或left+1
}
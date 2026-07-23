# Codetop 公司题频 Top 100 对照表

数据源：`https://codetop.cc/api/questions/?company=1&page=1..5&search=&ordering=-frequency`，抓取日期：2026-06-10。接口默认每页 20 条，因此这里覆盖第 1-5 页共 100 条。

本地解法来源：`java/{题号}.java`。Top 100 中 98 道可匹配本地 Java 题解，2 道未收录（补充题2、补充题23）。

| 题号 | 中文名称 | 英文名/Slug | 题目关键词 | 题目概要描述 | 本地解法关键词 | 本地解法思路描述 |
|---|---|---|---|---|---|---|
| 3 | 无重复字符的最长子串 | longest-substring-without-repeating-characters | 字符串、滑动窗口、哈希计数 | 给定字符串，求不含重复字符的最长连续子串长度。 | 滑动窗口、字符计数 | 右指针扩张窗口，`cnt[128]` 统计字符出现次数，当 `cnt[c] > 1` 时左指针右移直到窗口无重复，更新最大窗口长度。 |
| 146 | LRU缓存机制 | lru-cache | 设计、哈希表、双向链表、LRU | 实现支持 O(1) `get` 和 `put` 的最近最少使用缓存。 | LRU、哈希表、双向链表 | `cache` 哈希表定位节点，`dummyhead`/`dummytail` 伪首尾双向链表维护最近使用顺序，访问移到头部，超容量删尾部。 |
| 25 | K 个一组翻转链表 | reverse-nodes-in-k-group | 链表、分组翻转、原地操作 | 每 k 个节点一组翻转链表，不足 k 个的尾部保持原顺序。 | 链表翻转、k个一组、三指针 | 先遍历求链表长度 `n`，`dummy` 哨兵加 `p0` 记录每组前驱，用 `pre`/`cur`/`next` 三指针逐组翻转 `k` 个节点，翻转后重连前后段，不足 `k` 个保持原序。 |
| 206 | 反转链表 | reverse-linked-list | 链表、指针反转、迭代 | 反转单链表并返回新的头节点。 | 链表翻转、三指针 | 用 `pre`/`cur`/`next` 三指针迭代翻转，`cur.next` 指向 `pre` 后逐节点后移，最后 `dummy.next` 指向翻转后的头节点。 |
| 215 | 数组中的第K个最大元素 | kth-largest-element-in-an-array | 数组、快速选择、堆、排序 | 在未排序数组中返回第 k 大元素，而不是第 k 个不同元素。 | 快速选择、随机pivot、三路划分 | 将第 k 大转成升序下标 `target = n-k`，随机选 `pivot` 后用 `lt`/`i`/`gt` 三路划分，判断目标索引所在区间只继续该侧。 |
| 200 | 岛屿数量 | number-of-islands | 网格、DFS、BFS、连通分量 | 给定由陆地和水组成的网格，统计四方向相连的岛屿数量。 | DFS、岛屿计数、原标记修改 | 遍历网格，遇到 `'1'` 启动 DFS 并计数，DFS 中将访问过的陆地标记为 `'2'`，向四个方向递归直到越界或非陆地。 |
| 103 | 二叉树的锯齿形层次遍历 | binary-tree-zigzag-level-order-traversal | 二叉树、BFS、层序遍历、双端队列 | 按层遍历二叉树，层与层之间左右方向交替输出。 | BFS、层序遍历、双端队列 | `Deque` 队列做层序 BFS，用 `leftToRight` 标志当前层方向，奇数层 `addLast`、偶数层 `addFirst`，每层结束翻转方向。 |
| 15 | 三数之和 | 3sum | 数组、排序、双指针、去重 | 找出数组中所有和为 0 且不重复的三元组。 | 排序、双指针、三数之和 | 先 `Arrays.sort` 排序，固定 `i` 后用 `j`/`k` 双指针在剩余区间求两数之和，跳过重复元素，并用最小/最大两数和做剪枝。 |
| 33 | 搜索旋转排序数组 | search-in-rotated-sorted-array | 数组、二分、旋转有序数组 | 在无重复元素的旋转升序数组中查找目标下标。 | 二分查找、旋转数组、有序区间判断 | 二分查找，比较 `nums[left]` 与 `nums[mid]` 判断 `[left,mid]` 是否有序，再判断 `target` 是否落在有序区间内决定去左或右继续。 |
| 121 | 买卖股票的最佳时机 | best-time-to-buy-and-sell-stock | 数组、贪心、一次遍历 | 只能买卖一次股票，求可获得的最大利润。 | 一次遍历、最小买入价 | 一次遍历，维护历史最低价 `minPrice`，每步用 `price-minPrice` 更新最大利润 `ans`，同时更新 `minPrice`。 |
| 54 | 螺旋矩阵 | spiral-matrix | 矩阵、模拟、方向控制 | 按顺时针螺旋顺序返回矩阵所有元素。 | 模拟、方向数组、访问标记 | 用 `directions` 四方向数组顺时针模拟，`visited` 标记已访问，越界或已访问时 `(directionIdx+1)%4` 换方向。 |
| 5 | 最长回文子串 | longest-palindromic-substring | 字符串、回文、中心扩展、动态规划 | 返回字符串中最长的回文子串。 | 中心扩展、回文子串 | 枚举每个位置作为回文中心，分别对奇数长度 `(i,i)` 和偶数长度 `(i,i+1)` 调用 `expandAroundCenter` 向两侧扩展，记录最长回文起止位置。 |
| 236 | 二叉树的最近公共祖先 | lowest-common-ancestor-of-a-binary-tree | 二叉树、递归、最近公共祖先 | 在二叉树中找到两个指定节点的最近公共祖先。 | DFS、后序遍历、公共祖先 | 后序 DFS 递归查找，`root==p` 或 `root==q` 直接返回，左右子树都非空则 `root` 为最近公共祖先，否则返回非空一侧。 |
| 42 | 接雨水 | trapping-rain-water | 数组、双指针、单调栈、前后缀最大值 | 给定柱状高度，计算雨后可以接住的水量。 | 双指针、左右最大值 | 左右双指针向中间靠拢，维护 `leftMax`/`rightMax`，较小一侧的 `max - height` 即该位置接水量，移动较小一侧指针累加。 |
| 1 | 两数之和 | two-sum | 数组、哈希表、补数 | 在数组中找出和为 target 的两个数并返回下标。 | 哈希表、一次遍历、值映射下标 | 用 `HashMap<Integer,Integer> cache` 存「值->下标」，遍历时查 `target - nums[i]` 是否在表中，命中即返回两个下标，否则把当前元素 `<值,下标>` 入表。 |
| 46 | 全排列 | permutations | 回溯、排列、数组 | 返回不含重复数字数组的所有排列。 | 回溯、DFS、全排列 | 回溯 DFS，`path` 记录当前排列，遍历 `nums` 用 `path.contains` 跳过已选元素，递归到 `path.size() == nums.length` 时拷贝 `path` 加入 `ans`，回溯时 `path.remove(size-1)` 移除末尾。 |
| 53 | 最大子数组和 | maximum-subarray | 数组、动态规划、前缀和、Kadane | 求连续子数组的最大和。 | 动态规划、滚动变量、Kadane | 动态规划 `f(i)=max(f(i-1)+nums[i], nums[i])`，用变量 `pre` 滚动记录前一个状态，`maxAns` 维护全局最大值，空间优化到 O(1)。 |
| 160 | 相交链表 | intersection-of-two-linked-lists | 链表、双指针、指针切换 | 返回两个单链表开始相交的节点，不相交返回 null。 | 双指针、链表拼接、O(1)空间 | 双指针 `pA`、`pB` 分别从 `headA`、`headB` 出发，走到末尾（`null`）后切换到另一链表头继续，两指针走过的总长度相同，最终在相交点相遇或同时到达 `null`。 |
| 23 | 合并K个排序链表 | merge-k-sorted-lists | 链表、归并、堆、分治 | 将 k 个升序链表合并为一个升序链表。 | 分治、归并、递归、哨兵节点 | 递归分治，`merge(lists, left, right)` 对半划分区间递归合并，再用 `mergeTwoLists`（`dummy` 哨兵 + 双指针比较 `list1.val`、`list2.val`）两两归并。 |
| 300 | 最长上升子序列 | longest-increasing-subsequence | 数组、动态规划、二分、贪心 | 求数组中最长严格递增子序列的长度。 | 贪心、二分查找、原地修改、开区间写法 | 贪心+二分，复用 `nums` 作 `tails` 数组，对每个 `x` 用开区间二分 `lowerBound`（`left=-1, right=len`）找第一个 `>=x` 的位置替换，`res` 记录 LIS 长度。 |
| 31 | 下一个排列 | next-permutation | 数组、双指针、字典序 | 将数组原地改成字典序下一个排列，不存在则变为最小排列。 | 两轮扫描、双指针、交换翻转 | 从后往前找第一个 `nums[i] < nums[i+1]` 的 `i`，再从后往前找第一个大于 `nums[i]` 的 `j` 交换，最后 `reverse` 翻转 `[i+1, n)` 使其升序；若 `i<0` 直接整体翻转。 |
| 143 | 重排链表 | reorder-list | 链表、快慢指针、反转、合并 | 将链表重排为首尾交替的顺序。 | 快慢指针、链表逆序、交替合并 | 快慢指针 `middleNode` 找中点断开，`reverseList`（`prev`、`curr` 迭代）反转后半段 `l2`，再 `mergeList` 把 `l1`、`l2` 交替拼接。 |
| 88 | 合并两个有序数组 | merge-sorted-array | 数组、双指针、原地合并 | 将两个非降序数组合并到第一个数组中。 | 逆向双指针、原地合并、从后往前填 | 逆向双指针 `p1=m-1`、`p2=n-1`、`p=m+n-1` 从各数组末尾出发，每次取较大者填入 `nums1[p--]`，循环条件 `p2 >= 0` 直到 `nums2` 合并完。 |
| 199 | 二叉树的右视图 | binary-tree-right-side-view | 二叉树、DFS、BFS、层序 | 返回从右侧能看到的二叉树节点值。 | DFS、右子树优先、深度首次访问 | DFS 先递归 `root.right` 再递归 `root.left`，当 `depth == ans.size()` 表示该深度首次访问即右视图节点，加入 `ans`。 |
| 20 | 有效的括号 | valid-parentheses | 字符串、栈、括号匹配 | 判断括号字符串是否按正确顺序闭合。 | 栈、哈希表、括号匹配 | `pairs` 映射右括号->左括号，遇左括号 `stack.push`，遇右括号检查栈顶是否等于 `pairs.get(ch)`，奇数长度直接返回 `false`，最后栈空即有效。 |
| 102 | 二叉树的层序遍历 | binary-tree-level-order-traversal | 二叉树、BFS、队列 | 按层返回二叉树节点值。 | BFS、队列、层序遍历 | BFS 用 `queue`，每轮 `currentLevelSize = queue.size()` 确定当前层节点数，逐个 `poll` 收集到 `level` 并把左右孩子 `offer` 入队，`ans.add(level)`。 |
| 415 | 字符串相加 | add-strings | 字符串、模拟、进位 | 不使用大整数库，计算两个非负整数字符串之和。 | 模拟加法、双指针、进位 | 双指针 `i`、`j` 从两串末尾出发逐位相加，`add` 记进位，`ans.append(result % 10)` 追加个位，最后 `ans.reverse()` 翻转 `StringBuffer` 输出。 |
| 21 | 合并两个有序链表 | merge-two-sorted-lists | 链表、双指针、递归 | 合并两个升序链表并返回新链表头。 | 迭代、哨兵节点、双指针 | `dummy` 哑节点 + `prev` 指针，比较 `l1.val <= l2.val` 把较小者接到 `prev.next` 并后移 `prev`，循环结束后把未合并完的链表直接拼接到 `prev.next`。 |
| 72 | 编辑距离 | edit-distance | 字符串、动态规划、编辑距离 | 计算将一个单词转换为另一个单词的最少插入、删除、替换次数。 | 动态规划、编辑距离、滚动数组 | `D[2][m+1]` 滚动数组表示 `dp[i][j]`（word1 前 i 个字符到 word2 前 j 个字符的编辑距离），由插入 `D[curr][j-1]+1`、删除 `D[prev][j]+1`、替换 `D[prev][j-1]` 三者取最小，用 `i%2`、`(i-1)%2` 切换当前行与上一行。 |
| 141 | 环形链表 | linked-list-cycle | 链表、快慢指针、环检测 | 判断链表中是否存在环。 | 快慢指针、环形链表 | `slow` 走一步、`fast` 走两步，若相遇则有环；`fast` 或 `fast.next` 为 null 则无环。 |
| 92 | 反转链表 II | reverse-linked-list-ii | 链表、区间翻转、指针操作 | 只反转链表中从 left 到 right 的一段。 | 链表翻转、dummy 节点、三指针 | 加 `dummy` 头节点，先定位翻转段前驱 `p0`，再用 `pre`、`cur`、`next` 三指针迭代翻转 `[left,right]` 段，最后 `p0.next.next=cur`、`p0.next=pre` 完成重连。 |
| 124 | 二叉树中的最大路径和 | binary-tree-maximum-path-sum | 二叉树、DFS、树形 DP | 求二叉树中任意非空路径的最大路径和。 | 二叉树、后序 DFS、最大路径和 | 后序 `dfs` 返回以当前节点为端点的单侧最大贡献（负数取 0），在转弯处用 `left+right+root.val` 更新全局 `ans`。 |
| 56 | 合并区间 | merge-intervals | 数组、排序、区间合并 | 合并所有重叠区间。 | 区间合并、排序 | 按左端点 `Arrays.sort` 排序，遍历时若 `ans` 末尾区间右端点 `>=` 当前左端点则合并（取右端点最大值），否则加入 `ans`。 |
| 41 | 缺失的第一个正数 | first-missing-positive | 数组、原地哈希、置换 | 用 O(n) 时间和 O(1) 额外空间找缺失的最小正整数。 | 原地哈希、置换 | 将值在 `[1,n]` 的元素通过交换放到下标 `nums[i]-1` 处，重复或越界值丢弃；再扫一遍找第一个 `nums[i]!=i+1` 的位置返回。 |
| 165 | 比较版本号 | compare-version-numbers | 字符串、双指针、模拟 | 比较两个版本号字符串的大小。 | 字符串分割、版本号比较 | 用 `split("\\.")` 按点拆分版本号，逐段转 `Integer` 比较（短的补默认 0），不等即返回 1 或 -1，全部相等返回 0。 |
| 221 | 最大正方形 | maximal-square | 矩阵、动态规划 | 在 0/1 矩阵中找只包含 1 的最大正方形面积。 | 动态规划、最大正方形 | `dp[i][j]` 表示以 `(i,j)` 为右下角的全 1 正方形最大边长，由左、左上、上三方最小值加 1 转移，边界为字符值本身，答案取最大边长的平方 `ans*ans`。 |
| 148 | 排序链表 | sort-list | 链表、排序、归并 | 在 O(n log n) 时间内对链表排序。 | 链表排序、ArrayList | 将链表节点存入 `ArrayList`，用 `Collections.sort` 按 `val` 排序，再用 `dummy` 头节点重新串成链表。 |
| 32 | 最长有效括号 | longest-valid-parentheses | 字符串、栈、动态规划 | 求最长合法括号子串长度。 | 栈、括号匹配 | 栈存括号下标，初始压入 -1 作为最后一个未匹配右括号；遇 `(` 入栈，遇 `)` 出栈，栈空则压入当前下标作新分界，否则用 `i-stack.peek()` 更新 `ans`。 |
| 69 | x 的平方根 | sqrtx | 数学、二分、整数运算 | 返回非负整数 x 的算术平方根整数部分。 | 数学函数、exp/log | 用 `Math.exp(0.5*Math.log(x))` 计算平方根，再用 `(ans+1)*(ans+1)<=x` 修正取整误差。 |
| 4 | 寻找两个正序数组的中位数 | median-of-two-sorted-arrays | 数组、二分、分治、第 k 小 | 在两个有序数组中求整体中位数，要求 O(log(m+n))。 | 二分查找、第k小、双数组 | 中位数转为求第 `k` 小，`getKth` 递归比较两数组 `k/2` 位置丢弃较小的一段，保证较短数组先空，`k==1` 时取两数组首元素较小值。 |
| 22 | 括号生成 | generate-parentheses | 回溯、递归、卡特兰数 | 生成 n 对括号的所有合法组合。 | DFS、回溯、括号生成 | `dfs` 回溯构建括号串，左括号数 `<max` 可加 `(`，右括号数 `<left` 可加 `)`，长度达 `2*max` 时加入 `ans`。 |
| 补充题4 | 手撕快速排序 | sort-an-array | 排序、快速排序、分治 | 实现快速排序，对数组进行升序排序。 | 快速排序、随机 pivot、双指针划分 | 随机选 `pivot` 交换到 `left`，左右双指针向中间扫描交换使小于 pivot 的在左、大于的在右，递归排序两侧。 |
| 101 | 对称二叉树 | symmetric-tree | 二叉树、递归、镜像 | 判断二叉树是否关于中心轴对称。 | 递归、双指针、镜像判断 | 递归双指针 `check(p, q)` 让 `p`、`q` 朝反方向移动，比较根值后递归判断 `p` 的左子树与 `q` 的右子树、`p` 的右子树与 `q` 的左子树是否互为镜像。 |
| 93 | 复原IP地址 | restore-ip-addresses | 字符串、回溯、分段枚举 | 从字符串中恢复所有合法 IPv4 地址。 | DFS、回溯、字符串分割 | DFS 回溯，`dfs(start, path)` 从 `start` 起尝试取 1-3 个字符作为段，用 `validIpAdddr` 校验无前导零且值在 0-255，凑齐 4 段且用完字符则加入 `ans`，回溯移除末尾段。 |
| 1143 | 最长公共子序列 | longest-common-subsequence | 字符串、动态规划、LCS | 求两个字符串的最长公共子序列长度。 | DP、滚动数组、最长公共子序列 | DP 用滚动数组 `dp[2][n+1]`，字符相等时 `dp[i%2][j]=dp[(i-1)%2][j-1]+1`，否则取 `dp[(i-1)%2][j]` 与 `dp[i%2][j-1]` 的最大值，返回 `dp[m%2][n]`。 |
| 105 | 从前序与中序遍历序列构造二叉树 | construct-binary-tree-from-preorder-and-inorder-traversal | 二叉树、递归、哈希表 | 根据前序和中序遍历结果构造二叉树。 | 递归、哈希表、前序中序 | 用 `indexMap` 记录中序值下标，前序首位为根，定位中序根位置 `pos` 后算出左子树节点数 `leftNum`，递归构建左右子树并更新前序中序索引范围。 |
| 322 | 零钱兑换 | coin-change | 动态规划、完全背包、记忆化搜索 | 用给定硬币凑出指定金额，求最少硬币数。 | DP、滚动数组、完全背包 | 完全背包 DP 用滚动数组 `f[2][amount+1]`，`f[(i+1)%2][c]` 取不选 `f[i%2][c]` 与选 `f[(i+1)%2][c-coins[i]]+1` 的最小值，初值 `Integer.MAX_VALUE/2` 防溢出，无解返回 -1。 |
| 129 | 求根到叶子节点数字之和 | sum-root-to-leaf-numbers | 二叉树、DFS、路径数字 | 每条根到叶路径形成一个数字，求所有数字之和。 | DFS、路径求和 | DFS 传递 `pathSum`，访问节点时 `pathSum = pathSum * 10 + root.val`，到达叶子节点时累加到 `ans`，递归遍历左右子树。 |
| 394 | 字符串解码 | decode-string | 栈、字符串、递归解析 | 解码形如 `k[encoded_string]` 的嵌套字符串。 | 递归、字符串解析、指针 | 递归解析，全局指针 `ptr` 扫描字符串，遇数字用 `getDigits` 取重复次数 `repTime`，递归解析括号内子串后重复拼接，遇字母直接追加，最后递归处理剩余部分。 |
| 39 | 组合总和 | combination-sum | 回溯、组合、剪枝 | 从无重复候选数中找所有和为 target 的组合，每个数可重复使用。 | DFS、回溯、搜索树 | DFS 回溯以选/不选构建搜索树，`dfs(idx)` 左支跳过 `candidates[idx]`，右支选入 `combine` 并停留在 `idx`（可重复选），`target==0` 时记录组合，回溯 `remove` 末尾元素。 |
| 662 | 二叉树最大宽度 | maximum-width-of-binary-tree | 二叉树、BFS、节点编号 | 计算二叉树所有层中的最大宽度。 | BFS、层序遍历、节点编号 | BFS 层序遍历，用 `Pair<TreeNode, Integer>` 给节点编号（左子 `2*nodeNum`，右子 `2*nodeNum+1`），每层宽度为首尾编号差 `cur.last - cur.first + 1`，取最大值。 |
| 76 | 最小覆盖子串 | minimum-window-substring | 字符串、滑动窗口、哈希计数 | 在 s 中找包含 t 全部字符的最短子串。 | 滑动窗口、字符计数 | 滑动窗口配 `cntS[128]`、`cntT[128]` 计数，右指针扩张累加字符，`isCover` 判断窗口涵盖 `t` 后左指针收缩求最短窗口，记录 `ansLeft`、`ansRight`。 |
| 232 | 用栈实现队列 | implement-queue-using-stacks | 栈、队列、设计 | 只用栈实现队列的 push、pop、peek、empty。 | 双栈、队列、栈翻转 | 双栈 `inStack`、`outStack`，`push` 入 `inStack`，`pop`/`peek` 时若 `outStack` 空则调用 `in2out` 把输入栈倒入输出栈再取栈顶。 |
| 209 | 长度最小的子数组 | minimum-size-subarray-sum | 数组、滑动窗口、前缀和 | 找和至少为 target 的最短连续子数组长度。 | 滑动窗口、求和 | 滑动窗口，`right` 扩张累加 `sum`，当 `sum >= target` 时收缩 `left` 并更新最短长度 `ans`，找不到返回 0。 |
| 43 | 字符串相乘 | multiply-strings | 字符串、模拟、乘法 | 不用大整数库，返回两个非负整数字符串的乘积。 | 模拟乘法、数组、逐位相乘 | 模拟竖式乘法，`res[m+n]` 存结果，`num1[i]*num2[j]` 写入 `res[i+j]`（进位）和 `res[i+j+1]`（低位），最后转字符串跳过前导零。 |
| 142 | 环形链表 II | linked-list-cycle-ii | 链表、快慢指针、环入口 | 返回链表入环的第一个节点，无环返回 null。 | 快慢指针、Floyd判圈、环入口 | Floyd 判圈，`slow`、`fast` 快慢指针相遇确认有环，再让 `slow` 与 `head` 同步前进，相遇点即环入口节点。 |
| 162 | 寻找峰值 | find-peak-element | 数组、二分、峰值 | 找到任意一个严格大于相邻元素的峰值下标。 | 二分查找、峰值元素、对相邻比较 | 二分比较 `nums[mid]` 与 `nums[mid+1]`，下降则峰值在左缩 `right=mid`，上升则在右缩 `left=mid+1`，区间收敛到峰值下标。 |
| 78 | 子集 | subsets | 回溯、位运算、子集枚举 | 返回不含重复元素数组的所有子集。 | 回溯、DFS、选或不选、子集枚举 | DFS 对每个元素讨论选或不选，到 `i==nums.length` 时将 `path` 复制加入 `ans`，选后 `path.remove` 回溯。 |
| 2 | 两数相加 | add-two-numbers | 链表、模拟、进位 | 两个逆序链表表示非负整数，返回它们的和。 | 链表模拟、进位加法、dummy 头节点 | `dummy` 头节点串接结果，`carry` 维护进位，逐位相加 `l1`、`l2` 后处理剩余链表与最终进位。 |
| 19 | 删除链表的倒数第N个节点 | remove-nth-node-from-end-of-list | 链表、双指针、哑节点 | 删除链表倒数第 n 个节点并返回头节点。 | 双指针、快慢指针、dummy 哨兵 | `dummy` 哨兵简化头删，`right` 先走 `n` 步，再与 `left` 同步前进至 `right.next==null`，`left` 停在待删节点前驱，执行 `left.next=left.next.next`。 |
| 122 | 买卖股票的最佳时机 II | best-time-to-buy-and-sell-stock-ii | 数组、贪心、动态规划 | 可多次买卖股票，求最大利润。 | 动态规划、贪心、滚动变量 | 文件含两个解法：DP 用滚动变量 `prev2`(无股票)/`prev1`(有股票) 转移；贪心则累加所有相邻正向差价 `Math.max(0, prices[i+1]-prices[i])`。 |
| 82 | 删除排序链表中的重复元素 II | remove-duplicates-from-sorted-list-ii | 链表、哑节点、去重 | 删除有序链表中所有重复值节点，只保留未重复的值。 | 链表去重、dummy 哨兵、连续删除 | `dummy` 哨兵，`cur` 扫描，发现 `cur.next.val==cur.next.next.val` 时记下 `x` 并连续删除所有值为 `x` 的节点。 |
| 239 | 滑动窗口最大值 | sliding-window-maximum | 队列、单调队列、滑动窗口 | 返回每个长度为 k 的滑动窗口中的最大值。 | 单调队列、双端队列、滑动窗口最大值 | 双端队列 `deque` 存下标维护单调递减，入窗弹出队尾 `<=nums[i]` 的下标，队首出窗即移除，`i>=k-1` 时记录 `nums[deque.getFirst()]`。 |
| 112 | 路径总和 | path-sum | 二叉树、DFS、路径和 | 判断树中是否存在根到叶路径，其节点和等于 target。 | 递归、路径和、叶子判断 | 递归自顶向下累减 `targetSum`，到叶子节点判断 `targetSum==root.val`，左右子树任一满足即返回 true。 |
| 98 | 验证二叉搜索树 | validate-binary-search-tree | 二叉树、BST、递归、中序遍历 | 判断二叉树是否为合法二叉搜索树。 | 递归、区间约束、BST 验证 | 递归传递 `(lower,upper)` 开区间约束，`node.val<=lower` 或 `node.val>=upper` 即非法，左子树上界收紧为 `node.val`，右子树下界收紧为 `node.val`。 |
| 695 | 岛屿的最大面积 | max-area-of-island | 网格、DFS、连通块面积 | 求网格中由 1 组成的最大岛屿面积。 | DFS、连通分量、原地标记 | 遍历矩阵遇 `grid[i][j]==1` 调 `dfs` 求面积，访问过的格子置 `-1` 原地标记，向四方向递归累加面积取最大。 |
| 470 | 用 Rand7() 实现 Rand10() | implement-rand10-using-rand7 | 概率、拒绝采样、随机数 | 只调用 `rand7()` 实现均匀的 `rand10()`。 | 拒绝采样、等概率、进制转换 | 两次 `rand7()` 构造 `bit2*7+bit1` 共 49 种等概率组合，拒绝采样仅保留 `[0,39]`，映射 `ans%10+1` 得到等概率 `[1,10]`。 |
| 补充题1 | 排序奇升偶降链表 | https://mp.weixin.qq.com/s/0WVa2wIAeG0nYnVndZiEXQ | 链表、拆分、反转、归并 | 将奇数位升序、偶数位降序的链表整理成整体升序链表。 | 链表拆分、反转、归并合并 | 三步：`splitList` 按奇偶位置拆成两条链表，`reverseList` 反转偶数链表，`mergeTwoLists` 归并合并两个升序链表。 |
| 94 | 二叉树的中序遍历 | binary-tree-inorder-traversal | 二叉树、DFS、中序遍历 | 返回二叉树的中序遍历结果。 | 递归、中序遍历 | 递归实现中序遍历，`doInorder` 先遍历左子树，访问 `root.val` 加入 `ans`，再遍历右子树。 |
| 240 | 搜索二维矩阵 II | search-a-2d-matrix-ii | 矩阵、二分、搜索剪枝 | 在每行每列均升序的矩阵中查找 target。 | 右上角搜索、类 BST、缩小范围 | 从右上角 `(0,n-1)` 出发，`matrix[x][y]>target` 向左走，否则向下走，类似 BST 搜索直到越界或命中。 |
| 155 | 最小栈 | min-stack | 栈、设计、辅助栈 | 设计支持常数时间获取最小值的栈。 | 辅助栈、同步最小值 | 双栈 `xStack` 存数据、`minStack` 同步存当前最小值，入栈时 `minStack.push(Math.min(minStack.peek(), x))`，`getMin` 直接取 `minStack.peek()`。 |
| 139 | 单词拆分 | word-break | 字符串、动态规划、Trie | 判断字符串是否能由字典中的单词拼接而成。 | 动态规划、哈希集合、字符串拆分 | `dp[i]` 表示 `s[0..i-1]` 能否拆分，字典存入 `HashSet`；枚举分割点 j，`dp[i]=dp[j] && wordDictSet.contains(s.substring(j,i))`，命中即 break。 |
| 剑指 Offer 26 | 树的子结构 | shu-de-zi-jie-gou-lcof | 二叉树、递归、子结构匹配 | 判断一棵树是否包含另一棵树的子结构。 | 递归、先序遍历、结构匹配 | 对 `tree1` 每个节点调用 `dfs` 同步匹配 `tree2`，`node2==null` 视为匹配成功，`node1==null` 或 `node1.val!=node2.val` 则失败，递归比较左右子树。 |
| 79 | 单词搜索 | word-search | 回溯、矩阵、DFS | 判断单词是否能由网格中相邻字符路径组成，每格最多用一次。 | DFS、回溯、原地标记 | 遍历网格找到首字符后 DFS 四方向扩展，用 `board[r][c]='#'` 原地标记访问，回溯时用 `temp` 恢复，`index` 到 `word.length()` 即找到。 |
| 64 | 最小路径和 | minimum-path-sum | 矩阵、动态规划、记忆化搜索 | 从左上到右下，只能向右或向下，求最小路径和。 | 动态规划、滚动数组、原地修改 | 两个版本：`minPathSum` 原地 `grid[i][j] += min(grid[i-1][j], grid[i][j-1])` 空间 O(1)；`minPathSum2` 用一维 `dp[n]` 滚动更新空间 O(n)。 |
| 113 | 路径总和 II | path-sum-ii | 二叉树、DFS、回溯、路径和 | 返回所有根到叶路径和等于 target 的路径。 | DFS、回溯、路径记录 | 前序 DFS 用 `path` 记录路径并扣减 `targetSum`，到叶子且 `targetSum==0` 时把 `path` 拷贝加入 `ans`，递归返回时 `path.pollLast()` 回溯。 |
| 128 | 最长连续序列 | longest-consecutive-sequence | 哈希表、数组、连续序列 | 在未排序数组中求最长连续整数序列长度。 | 哈希集合、序列起点、向上计数 | 数存入 `HashSet`，仅对 `num-1` 不在集合中的起点向上 `while set.contains(currentNum+1)` 计数，`ans` 取最大长度。 |
| 152 | 乘积最大子数组 | maximum-product-subarray | 数组、动态规划、最大最小状态 | 求连续子数组的最大乘积。 | 动态规划、滚动变量、最大最小乘积 | 维护滚动变量 `fMax`、`fMin`，每步从 `fMaxOld*nums[i]`、`fMin*nums[i]`、`nums[i]` 三者取最大最小更新（处理负数翻转），`ans` 记录全局最大。 |
| 剑指 Offer 22 | 链表中倒数第k个节点 | lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof | 链表、双指针、倒数节点 | 返回链表中倒数第 k 个节点。 | 双指针、快慢指针、一次遍历 | 快指针 `post` 先走 `cnt` 步，再 `pre`、`post` 同步前进，`post` 到 `null` 时 `pre` 即倒数第 `cnt` 个节点。 |
| 440 | 字典序的第K小数字 | k-th-smallest-in-lexicographical-order | 字典树、前缀计数、数学 | 在 1 到 n 的整数中字典序第 k 小的数字。 | 字典序、十叉树、前缀计数 | 把 `[1..n]` 看作十叉前缀树，`curr` 从 1 出发，`getSteps` 计算以 `curr` 为前缀且 `<=n` 的节点数；`steps<=k` 则跳兄弟 `curr++` 并扣减 k，否则下探 `curr*=10`。 |
| 48 | 旋转图像 | rotate-image | 矩阵、原地旋转、转置 | 将 n x n 矩阵原地顺时针旋转 90 度。 | 原地翻转、垂直翻转、对角线翻转 | 顺时针 90 度拆两步原地翻转：先 `flip1` 沿水平中线 `matrix[i][j]` 与 `matrix[n-i-1][j]` 上下翻转，再 `flip2` 沿主对角线转置。 |
| 70 | 爬楼梯 | climbing-stairs | 动态规划、斐波那契 | 每次爬 1 或 2 阶，求到第 n 阶的方法数。 | 动态规划、斐波那契、滚动变量 | `f(n)=f(n-1)+f(n-2)`，`n<=2` 直接返回 n，否则用滚动变量 `prev2`、`prev1` 迭代更新，空间 O(1)。 |
| 402 | 移掉K位数字 | remove-k-digits | 栈、贪心、单调栈 | 删除数字字符串中的 k 位，使剩余数字最小。 | 单调栈、贪心、去前导零 | 用双端队列 `deque` 作单调不降栈，扫描时栈顶大于当前数字且 `k>0` 则 `pollLast` 弹出；剩余 `k` 从尾部删，最后去前导零，空串返回 "0"。 |
| 198 | 打家劫舍 | house-robber | 动态规划、滚动数组 | 相邻房屋不能同时偷，求可偷的最大金额。 | 动态规划、滚动变量、打家劫舍 | `dp[i]=max(dp[i-2]+nums[i], dp[i-1])`，用滚动变量 `prev2`、`prev1` 迭代更新，空间 O(1)。 |
| 62 | 不同路径 | unique-paths | 动态规划、组合数学、网格路径 | 机器人从左上到右下，只能向右或向下，求路径数。 | 动态规划、滚动数组、空间优化 | 用一维数组 `f[n]` 滚动更新，初始全为 1，`f[j] += f[j-1]` 表示上方加左方，空间优化到 O(n)。 |
| 543 | 二叉树的直径 | diameter-of-binary-tree | 二叉树、DFS、树高 | 求二叉树中任意两节点路径的最大边数。 | DFS、后序遍历、全局最大值 | DFS 后序遍历，`dfs` 返回以当前节点为端点的最大链长（空节点返回 -1），用 `left+right+2` 更新全局变量 `ans`。 |
| 补充题23 | 检测循环依赖 | https://mp.weixin.qq.com/s/pCRscwKqQdYYN7M1Sia7xA | 图、拓扑排序、环检测 | 在依赖关系中检测是否存在循环依赖。 | 未收录 | 仓库中未找到对应补充题文件。 |
| 补充题2 | 圆环回原点问题 | https://mp.weixin.qq.com/s/NZPaFsFrTybO3K3s7p7EVg | 动态规划、环、计数 | 在圆环上按步移动，计算回到原点的方案数。 | 未收录 | 仓库中未找到对应补充题文件。 |
| 207 | 课程表 | course-schedule | 图、DFS、拓扑排序、环检测 | 判断是否可以完成所有课程，即先修依赖图是否无环。 | 拓扑排序、DFS、三色标记法、邻接表、环检测 | 构建邻接表 `graph[]`，用三色标记 `colors[]`（0 未访问/1 访问中/2 已访问）做 DFS，遇到访问中节点说明有环则返回 false。 |
| 179 | 最大数 | largest-number | 排序、贪心、自定义比较 | 将非负整数数组排列成能组成的最大数字字符串。 | 自定义排序、字符串拼接、降序 | 将数字转为字符串数组 `numStrs`，按 `(a,b)->(b+a).compareTo(a+b)` 降序排序后拼接，特判首元素为 "0" 时返回 "0"。 |
| 24 | 两两交换链表中的节点 | swap-nodes-in-pairs | 链表、递归、成对交换 | 两两交换链表相邻节点并返回新头。 | 虚拟头节点、迭代、指针交换 | 用 `dummyHead` 哨兵节点，`temp` 每次交换其后两个节点 `node1`、`node2` 的指针指向，然后 `temp` 前移到 `node1`。 |
| 958 | 二叉树的完全性检验 | check-completeness-of-a-binary-tree | 二叉树、BFS、完全二叉树 | 判断一棵二叉树是否为完全二叉树。 | BFS、层序遍历、节点编号 | BFS 层序遍历，用 `ANode` 包装节点与编号（根为 1，左 `code*2` 右 `code*2+1`），完全二叉树最后一个节点编号应等于节点总数 `nodes.size()`。 |
| 329 | 矩阵中的最长递增路径 | longest-increasing-path-in-a-matrix | 矩阵、DFS、记忆化搜索、拓扑排序 | 求矩阵中四方向移动形成的最长严格递增路径长度。 | DFS、记忆化搜索、备忘录、四方向探索 | 对每个格子做 DFS 探索 `dirs` 四方向严格递增路径，`memo[][]` 记录已算结果避免重复计算，取全局最大值 `maxLength`。 |
| 8 | 字符串转换整数 (atoi) | string-to-integer-atoi | 字符串、模拟、边界处理 | 按 atoi 规则将字符串转换为 32 位有符号整数。 | 正则表达式、越界截断、Long 解析 | 用正则 `^\s*([+-]?\d+).*` 提取数字部分，`Long.parseLong` 解析后与 `Integer.MAX_VALUE`/`MIN_VALUE` 比较截断，解析失败按符号返回边界值。 |
| 55 | 跳跃游戏 | jump-game | 数组、贪心、最远可达 | 判断是否能从数组起点跳到最后一个下标。 | 贪心、最远可达 | 贪心维护能到达的最远位置 `rightmost`，遍历时若 `i <= rightmost` 则更新 `rightmost = max(rightmost, i+nums[i])`，达到 `n-1` 提前返回 true。 |
| 135 | 分发糖果 | candy | 贪心、两次扫描、数组 | 按评分给孩子分糖，评分更高的相邻孩子糖更多，求最少糖数。 | 贪心、常数空间、递增递减序列 | 一次遍历，用 `inc`、`dec`、`pre` 跟踪递增/递减序列长度，评分相等时 `pre` 置 1，递减序列长度追上递增时 `dec++` 补偿，累加糖果数 `ret`。 |
| 560 | 和为K的子数组 | subarray-sum-equals-k | 数组、前缀和、哈希表 | 统计和等于 k 的连续子数组个数。 | 前缀和、哈希表、两数之差 | 用哈希表 `preToCount` 记录前缀和出现次数（初始放入 `0:1`），遍历时查 `pre-k` 是否存在，存在则累加其计数到 `ans`。 |
| 151 | 翻转字符串里的单词 | reverse-words-in-a-string | 字符串、双指针、分词 | 去掉多余空格并反转字符串中单词顺序。 | 字符串分割、逆序拼接、trim | `trim()` 去首尾空格后按 `\\s+` 分割成 `ar`，逆序遍历用 `StringBuilder` 拼接单词。 |
| 224 | 基本计算器 | basic-calculator | 栈、递归、表达式求值 | 计算包含加减和括号的表达式字符串。 | 栈、符号作用域、括号处理 | 用栈 `ops` 记录括号作用域符号，遇 `(` 入栈当前 `sign`，遇 `)` 出栈，遇 `+`/`-` 取栈顶设置 `sign`，数字按 `sign*num` 累加到 `ret`。 |
| 110 | 平衡二叉树 | balanced-binary-tree | 二叉树、DFS、树高 | 判断二叉树任意节点左右子树高度差是否不超过 1。 | DFS、后序遍历、提前剪枝 | DFS 后序遍历求高度，不平衡时返回 -1 提前剪枝，左右子树高度差超过 1 即标记 -1，最终判断 `height(root) >= 0`。 |

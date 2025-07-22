class Solution {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans = new ArrayList<>();
        ans.add(List.of(1)); // 第一行
        
        // 剩下的n-1行 i是当前行下标 也是中间的数字的个数
        for(int i=1;i<numRows;i++){
            List<Integer> list = new ArrayList<>();
            // 第一个为1
            list.add(1);
            // 中间的数字个数
            // a[i][j] = a[i-1][j-1] + a[i-1][j];
            for(int j=1;j<i;j++){
                list.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
            }
            // 最后一个为1
            list.add(1);
            ans.add(list);
        }
        return ans;
    }
}
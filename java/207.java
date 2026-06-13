/**
 * @description: 课程表. 课程之间有依赖关系,根据依赖数组判断是可以拓扑排序
 * 拓扑排序(判断这个有向图中是否存在环。 如果存在环，说明课程要求有冲突),不存在环(DAG)则可以完成所有课程
 * numCourses = 2, prerequisites = [[1,0]] 输出: true
 */
class Solution {
    // 用dfs判断是否为DAG 
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // prerequisites[ai, bi]表示bi->ai的边
        // 用邻接表表示图,表示每个节点做为起点的边的终点列表

        // 构建图(领接表)
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] p : prerequisites){
            graph[p[1]].add(p[0]);
        }       
        
        // colors数组表示每个图节点的状态
        // 0未访问，1访问中(dfs未返回)，2已访问(dfs已返回)
        int[] colors = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            // 找到一个没访问的点 开始dfs访问
            // dfs返回true 就是找到了环 拓扑排序失败
            if(colors[i] == 0 && dfs(i, graph, colors)){
                return false;
            }    
        }
        return true;
    }

    /**
      * dfs判断是否存在环返回true则存在环,false则不存在环则是DAG
      * node 当前的节点
      * graph 图邻接表
      * colors 节点状态数组 (三色标记法)
      * return 是否为dag
     */
    private boolean dfs(int node, List<Integer>[] graph, int[] colors){
        // 当前节点 访问中
        colors[node] = 1;
        // 访问所有node的所有相邻节点x->[p1,p2,p3]
        for(int p : graph[node]){
            // 正在访问中 存在环
            // OR 没访问过 继续dfs访问没被访问的节点
            if(colors[p] == 1 || colors[p] == 0 && dfs(p, graph, colors)){ 
                return true;
            }
        }
        // 当前节点 已访问结束
        colors[node] = 2;
        return false;
    }
}
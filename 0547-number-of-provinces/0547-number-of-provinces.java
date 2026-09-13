class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] vis = new boolean[isConnected.length];
        int ans  = 0;
        for(int i = 0 ; i < vis.length; i++){
            if(!vis[i]){
                bfs(isConnected, i, vis);
                ans++;
            }
        }
        return ans;
    }

    public void bfs(int[][] isConnected, int start, boolean[] vis) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int i = 0; i < isConnected.length; i++){
                if(!vis[i] && isConnected[node][i] == 1 ){
                    q.add(i);
                    vis[i] = true;
                }
            }
        }
    }
}
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        boolean[] vis = new boolean[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int count = 0;
        for(int i  = 0 ; i < n; i++){
            if(!vis[i]){
                count += bfs(adj, i, vis);
            }
        }
        return count;
    }
    public int bfs(ArrayList<ArrayList<Integer>> adj, int start, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        vis[start] = true;
        int edges = 0;
        int nodes = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            nodes++;
            edges += adj.get(node).size();
            for(int i = 0; i < adj.get(node).size(); i++){
                if(!vis[adj.get(node).get(i)]){
                    q.add(adj.get(node).get(i));
                    vis[adj.get(node).get(i)] = true;
                }
            }

        }
            if(edges/2 == (nodes)*(nodes-1)/2){
                return 1;
            } 
            return 0;
    }
}
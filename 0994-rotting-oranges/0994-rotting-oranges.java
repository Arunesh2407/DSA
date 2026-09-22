class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Integer> hor = new LinkedList<>();
        Queue<Integer> ver = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                if(grid[i][j] == 2){
                    hor.add(i);
                    ver.add(j);
                }
            }
        }
        int ans = 0;
        int times = hor.size();
        int temp = 0;
        boolean check = false;
        while(!hor.isEmpty()){
            if(temp ==  times){
                times = hor.size();
                temp = 0;
                if(check){
                    ans++;
                }
                check = false;
            }
            temp++;
            int i = hor.poll();
            int j = ver.poll();
            if(i > 0){
                if(grid[i-1][j] == 1){
                    grid[i-1][j] = 2;
                    hor.add(i-1);
                    ver.add(j);
                    check = true;
                }
            }
            if(j > 0){
                if(grid[i][j-1] == 1){
                    grid[i][j-1] = 2;
                    hor.add(i);
                    ver.add(j-1);
                    check = true;
                }
            }
            if(i < n-1){
                if(grid[i+1][j] == 1){
                    grid[i+1][j] = 2;
                    hor.add(i+1);
                    ver.add(j);
                    check = true;
                }
            }
            if(j < m-1){
                if(grid[i][j+1] == 1){
                    grid[i][j+1] = 2;
                    hor.add(i);
                    ver.add(j+1);
                    check = true;
                }
            }
        }

        // if(ans == -1){
        //     ans = 0;
        // }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return ans;
    }
}
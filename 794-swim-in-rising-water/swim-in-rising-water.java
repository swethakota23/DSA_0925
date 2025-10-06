class Solution {
    public int swimInWater(int[][] grid) {
        int n=grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq= new PriorityQueue<>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        pq.offer(new int[]{0,0});
        int ans = 0;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        while(!pq.isEmpty()){
            int[] curr= pq.poll();
            int r= curr[0];
            int c= curr[1];
            ans= Math.max(ans,grid[r][c]);
            if(r==(n-1) && c==(n-1)) return ans;
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nr<=n-1 && nc>=0 && nc<=n-1 && !visited[nr][nc]){
                    pq.offer(new int[]{nr,nc});
                    visited[nr][nc]=true;
                }
            }
        }
        return -1;
    }
}
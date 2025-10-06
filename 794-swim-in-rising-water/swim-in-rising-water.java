import java.util.*;

class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        
        // Min-heap comparing by elevation
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]
        );
        
        // Start from top-left corner
        pq.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        int ans = 0;
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};
        
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int r = cell[0], c = cell[1];
            ans = Math.max(ans, grid[r][c]);
            
            // When we reach the destination, return the water level
            if (r == n - 1 && c == n - 1) return ans;
            
            // Explore 4-directionally adjacent cells
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    pq.offer(new int[]{nr, nc});
                }
            }
        }
        return -1; // should never reach here
    }
}

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;
        int[][] dp= new int[n][n];
        for(int[] i:dp){
            Arrays.fill(i,Integer.MAX_VALUE);
        }
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, minFall(matrix, n - 1, j,dp));
        }
        return ans;
    }

    private int minFall(int[][] matrix, int i, int j,int[][] dp) {
        // Out of bounds
        if (j < 0 || j >= matrix.length) {
            return Integer.MAX_VALUE;
        }
        if(dp[i][j]<Integer.MAX_VALUE) return dp[i][j];

        // Base case
        if (i == 0) {
            return dp[i][j]=matrix[0][j];
        }

        // Use long to avoid overflow
        long u  = (long) matrix[i][j] + minFall(matrix, i - 1, j,dp);
        long ld = (long) matrix[i][j] + minFall(matrix, i - 1, j - 1,dp);
        long rd = (long) matrix[i][j] + minFall(matrix, i - 1, j + 1,dp);

        return dp[i][j]=(int) Math.min(u, Math.min(ld, rd));
    }
}

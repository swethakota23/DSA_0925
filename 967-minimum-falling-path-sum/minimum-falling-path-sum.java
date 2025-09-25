class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        // Base case: first row is same as matrix
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // Fill dp table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = matrix[i][j] + dp[i - 1][j];
                int ld = (j > 0) ? matrix[i][j] + dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int rd = (j < n - 1) ? matrix[i][j] + dp[i - 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = Math.min(up, Math.min(ld, rd));
            }
        }

        // Result: minimum in last row
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            mini = Math.min(mini, dp[n - 1][j]);
        }

        return mini;
    }
}


    // private int minFall(int[][] matrix, int i, int j,int[][] dp) {
    //     // Out of bounds
    //     if (j < 0 || j >= matrix.length) {
    //         return Integer.MAX_VALUE;
    //     }
    //     if(dp[i][j]<Integer.MAX_VALUE) return dp[i][j];

    //     // Base case
    //     if (i == 0) {
    //         return dp[i][j]=matrix[0][j];
    //     }

    //     // Use long to avoid overflow
    //     long u  = (long) matrix[i][j] + minFall(matrix, i - 1, j,dp);
    //     long ld = (long) matrix[i][j] + minFall(matrix, i - 1, j - 1,dp);
    //     long rd = (long) matrix[i][j] + minFall(matrix, i - 1, j + 1,dp);

    //     return dp[i][j]=(int) Math.min(u, Math.min(ld, rd));
    // }

    
    


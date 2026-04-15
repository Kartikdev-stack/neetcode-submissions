class Solution {
    public int uniquePaths(int m, int n) {
        // Memoisation Approach
        int[][] dp=new int[m][n];
        
        for(int[] cell: dp){
            Arrays.fill(cell, -1);
        }

        return uniquePaths(m-1, n-1, dp);
    }

    public int uniquePaths(int i, int j, int[][] dp){

        if(i==0 && j==0){
            return 1;
        }

        if(i<0 || j<0){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        dp[i][j]=uniquePaths(i-1,j,dp) + uniquePaths(i,j-1,dp);

        return dp[i][j];
    }
}

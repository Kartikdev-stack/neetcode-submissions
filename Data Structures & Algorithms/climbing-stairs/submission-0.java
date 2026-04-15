class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return climb(n,dp);
    }

    public int climb(int n, int[] dp){ // no of ways to climb n stairs

        if(n==0 || n==1){
            return 1;
        }

        if(dp[2]!=-1)
            return dp[n]; // directly returning the cached value of climbing 2 steps instead of again calculating

        dp[n]=climb(n-1, dp) + climb(n-2, dp);

        return dp[n];
    }
}

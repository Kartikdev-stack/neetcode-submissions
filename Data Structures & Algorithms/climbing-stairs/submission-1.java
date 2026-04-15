class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);

        return climb(n, dp);
    }

    public int climb(int n, int[] dp){
        if(n==1 || n==0){
            return 1; // no of ways to reach 0th or 1st step
        }

        if(dp[n]!=-1){
            return dp[n]; // use the cached value
        }

        dp[n]=climb(n-1,dp) + climb(n-2,dp); // total ways to reach nth step
        return dp[n];
    }

}

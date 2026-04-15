class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
            return nums[0];

        int[] dp1=new int[nums.length];
        int[] dp2=new int[nums.length];

        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);

        return Math.max(rob(n-2,0,nums,dp1),rob(n-1,1,nums,dp2));
    }

    public int rob(int i, int start, int[] nums, int[] dp){
        if(i<start)
            return 0;

        if(i==start)
            return nums[start];
        
        if(dp[i]!=-1){
            return dp[i];
        }

        dp[i]=Math.max(nums[i] + rob(i-2,start,nums,dp), rob(i-1,start,nums,dp));

        return dp[i];
    }
}

class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        dp =[0]*len(nums) # initializing dp array

        dp[0]=nums[0] # base case

        for i in range(1,len(nums)):
            dp[i]=max(dp[i-1]+nums[i],nums[i])
        
        return max(dp)

        
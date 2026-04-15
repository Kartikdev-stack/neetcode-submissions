class Solution:
    def rob(self, nums: List[int]) -> int:
        return self.dp(nums, len(nums) -1, {})

    def dp(self, nums: List[int], n: int, memo: dict):
        if n==0:
            return nums[0]
        
        if n==1:
            return max(nums[0], nums[1])
        
        if n in memo:
            return memo[n]
            
        memo[n]=max(self.dp(nums, n-1, memo), nums[n] + self.dp(nums, n-2, memo))

        return memo[n]
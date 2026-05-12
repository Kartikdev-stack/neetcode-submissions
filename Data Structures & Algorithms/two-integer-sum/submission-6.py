class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        sum={} # defining an empty dict

        for i in range(len(nums)):
            diff=target - nums[i]

            if diff in sum:
                return [sum[diff], i]
            sum[nums[i]]=i
        return []
            
        
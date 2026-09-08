class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        seen=set() # Define the hashset

        for num in nums:
            if num in seen:
                return True
            seen.add(num)

        return False



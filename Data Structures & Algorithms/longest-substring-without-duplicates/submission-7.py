class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left=0
        right=0
        length=0
        max_length=0

        seen=set() # Define a set

        for right in range(len(s)):
            while s[right] in seen:
                seen.remove(s[left])
                left+=1
            
            seen.add(s[right])
            length=right-left+1
            max_length=max(max_length, length)
        
        return max_length

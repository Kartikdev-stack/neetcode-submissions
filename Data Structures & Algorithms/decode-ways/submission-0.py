class Solution:
    def numDecodings(self, s: str) -> int:
        memo={}
        n=len(s)

        def dp(i):

            #base case
            if i==n:
                return 1
            
            if i in memo:
                return memo[i]
            
            total=0

            # Move 1: single digit at a time
            if s[i] != '0':
                total+=dp(i+1)
            
            # Move 2: we take both digits
            if i+1 < n and '10' <=s[i:i+2]<= '26':
                total+=dp(i+2)

            memo[i]=total
            return total

        return dp(0)
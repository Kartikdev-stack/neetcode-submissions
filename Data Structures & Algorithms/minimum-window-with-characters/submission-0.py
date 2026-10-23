class Solution:
    def minWindow(self, s: str, t: str) -> str:
        t_count={} # Defining a hashmap for t
        window_count={} # Define a hashmap for shortest substring in s
        formed=0

        for char in t:
            t_count[char]=t_count.get(char, 0) + 1
        
        required=len(t_count)

        # t_count = { 'X' : 1, 'Y' : 1, 'Z' : 1} 

        left=0
        min_length=float("inf")
        start=0

        # Starting the sliding window

        for right in range(len(s)):
            window_count[s[right]]=window_count.get(s[right], 0) + 1
            
            if s[right] in t_count and window_count[s[right]]==t_count[s[right]]:
                formed+=1

            while formed == required:
                current_length=right-left+1
                
                if current_length < min_length:
                    min_length=current_length
                    start=left
                
                window_count[s[left]]-=1

                if s[left] in t_count and window_count[s[left]] < t_count[s[left]]:
                    formed-=1

                if window_count[s[left]] == 0:
                    window_count.pop(s[left])

                left+=1
        
        if min_length == float("inf"):
            return ""
        
        return s[start: start+min_length]
        
        





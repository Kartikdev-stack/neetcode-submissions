class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        
        # Check the lengths first

        if len(s) != len(t):
            return False
        
        count={} # Define hashmap

        for char in s:
            count[char]=count.get(char,0) + 1
        
        for char in t:
            if char not in count:
                return False
            
            count[char]-= 1

        for char in count:
            if count[char] != 0:
                return False
        
        return True
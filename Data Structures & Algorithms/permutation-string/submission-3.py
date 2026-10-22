class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:

        if len(s1) > len(s2):
            return False

        s1_map={} # Define a hashmap for s1
        for i in range(len(s1)):
            char=s1[i] 
            s1_map[char]=s1_map.get(char, 0) + 1
        
        # Creating the initial length window for s2
        window_count={} # Second hashmap for s2
        for i in range(len(s1)):
            char=s2[i]
            window_count[char]=window_count.get(char, 0) + 1
        
        # Compare initial window with s1 for permuation match

        if window_count==s1_map:
            return True
        
        left=0
        for right in range(len(s1), len(s2)):
            window_count[s2[left]]-=1
            if window_count[s2[left]] == 0:
                window_count.pop(s2[left])
            left+=1
            window_count[s2[right]]=window_count.get(s2[right],0) + 1

            if window_count == s1_map:
                return True
        
        return False


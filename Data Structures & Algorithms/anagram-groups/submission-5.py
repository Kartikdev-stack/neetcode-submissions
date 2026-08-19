class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dict={}   # define the hashmap

        for s in strs:
            key="".join(sorted(s))
            dict.setdefault(key,[]).append(s)
        
        return list(dict.values())
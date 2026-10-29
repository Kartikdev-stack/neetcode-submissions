class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        hmap={} # Defining the hashmap

        for word in strs:
            key="".join(sorted(word))

            if key in hmap:
                hmap[key].append(word)
            else:
                hmap[key]=[]
                hmap[key].append(word)
            
        return list(hmap.values())

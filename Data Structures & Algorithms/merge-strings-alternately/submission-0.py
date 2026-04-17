class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        result=[]
        start=0

        while start < len(word1) and start< len(word2):
            result.append(word1[start])
            result.append(word2[start])
            start+=1
        
        result.append(word1[start:])
        result.append(word2[start:])

        return ''.join(result)

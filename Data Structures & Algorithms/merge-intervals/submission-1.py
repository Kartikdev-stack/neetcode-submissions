class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:

        intervals.sort(key=lambda x: x[0])
        result=[intervals[0]]
        
        for i in range(1, len(intervals)):
            current=intervals[i]
            last=result[-1]

            if current[0] <= last[1]:
                last[1]=max(current[1], last[1])
            else:
                result.append(current)
        
        return result
                
            
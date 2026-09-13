import heapq
class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count={}

        for num in nums:
            if num in count:
                count[num]=count[num] + 1
            else:
                count[num] = 1
            
        
        # 1->1
        # 2->2
        # 3 -> 3

        heap=[]

        for num, freq in count.items():
            heapq.heappush(heap, (freq, num))

            while len(heap) > k:
                heapq.heappop(heap)
        
        answer=[]

        for freq,num in heap:
            answer.append(num)
        
        return answer

        
class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        heap=[]

        for point in points:
            distance=(point[0]**2 + point[1]**2)
            heapq.heappush(heap, (-distance, point)) 

            if len(heap) > k:
                heapq.heappop(heap)
            
        res=[]
        for item in heap:
            point=item[1]
            res.append(point)
        
        return res
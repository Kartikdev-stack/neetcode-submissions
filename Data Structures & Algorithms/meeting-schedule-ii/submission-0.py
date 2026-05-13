"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""
import heapq
class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        
        if len(intervals)==0:
            return 0
        
        starts=[]
        ends=[]

        for interval in intervals:

            starts.append(interval.start)
            ends.append(interval.end)
        
        starts.sort()
        ends.sort()

        start_pointer=0
        end_pointer=0

        rooms=0

        max_rooms=0

        while start_pointer < len(intervals):

            if starts[start_pointer] < ends[end_pointer]:
                rooms+=1

                max_rooms=max(max_rooms, rooms)

                start_pointer+=1
            
            else: 

                rooms-=1
                end_pointer += 1
        
        return max_rooms


        




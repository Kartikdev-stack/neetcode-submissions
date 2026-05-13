"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def canAttendMeetings(self, intervals: List[Interval]) -> bool:

        if len(intervals) <=1 :        # Edge case
            return True

        intervals.sort(key=lambda x: x.start) # sort by the start time

        for i in range(1, len(intervals)):
            if intervals[i].start < intervals[i-1].end:
                return False
            

        return True
        

        
        
from collections import deque

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        fresh_count=0
        minutes=0
        directions=[[0,1],[0,-1],[1,0],[-1,0]]
        queue=deque()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:  # rotten
                    queue.append((i,j))
                elif grid[i][j]== 1:  # fresh
                    fresh_count+=1
        
        if fresh_count==0:
            return minutes
        
        while queue:
            for i in range(len(queue)):
                row, col = queue.popleft()
                for dr,dc in directions:
                    new_row=dr+row
                    new_col=dc+col
                
                    if new_row >=0 and new_row<len(grid) and new_col>=0 and new_col<len(grid[0]) and grid[new_row][new_col]==1:
                        grid[new_row][new_col]=2 # mark as rotten
                        fresh_count-=1
                        queue.append((new_row,new_col))
            if queue:
                minutes+=1
        
        if fresh_count == 0:
            return minutes
        else: 
            return -1
        
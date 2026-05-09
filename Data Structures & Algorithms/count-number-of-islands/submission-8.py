# BFS Approach
from collections import deque

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count=0 # defining the count of islands
        directions=[(0,1),(0,-1),(1,0),(-1,0)]
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=='1':
                    count+=1
                    queue=deque()
                    queue.append((i,j))
                    grid[i][j]='0' # mark as visited

                    while queue:
                        r,c = queue.popleft()
                        for dr,dc in directions:
                            nr,nc=r+dr, c+dc

                            if nr>=0 and nr<len(grid) and nc>=0 and nc<len(grid[0]) and grid[nr][nc]=='1':
                                grid[nr][nc]='0'
                                queue.append((nr,nc))

        return count
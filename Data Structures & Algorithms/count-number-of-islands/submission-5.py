class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        count=0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j]=='1':
                    self.dfs(grid, i, j)
                    count+=1
            
        return count    

    def dfs(self, grid: List[List[str]], i: int, j: int) -> None:

        # Edge Cases
        if i<0 or i>=len(grid) or j<0 or j>=len(grid[0]) or grid[i][j]=='0' :
            return

        grid[i][j]='0' # mark as visited

        self.dfs(grid, i-1, j) # up
        self.dfs(grid, i+1, j) # down
        self.dfs(grid, i, j-1) # left
        self.dfs(grid, i, j+1) # right
class Solution {
    int count=0;
    
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea=0;

        if(grid==null || grid.length==0 || grid[0].length==0)
            return 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    dfs(grid,i,j);
                    maxArea=Math.max(maxArea,count);
                    count=0;
                }
            }
        }

        return maxArea;
    }

    public void dfs(int[][] grid, int i, int j){
        
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j]==0){
            return;
        }

        grid[i][j]=0;
        count++;
      
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);

    }

}

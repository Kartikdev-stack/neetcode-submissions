class Solution {
    public static int[][] directions={{-1,0}, {1,0}, {0,-1}, {0,1}};

    public int numIslands(char[][] grid) {

        int count=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    bfs(grid,i,j);
                    count++;
                }
            }
        }

        return count;
    }

    public static void bfs(char[][] grid, int i, int j){
        Queue<int[]> q=new LinkedList<>();
        grid[i][j]='0'; // mark as visited
        q.add(new int[]{i,j});

        while(!q.isEmpty()){

            int[] cell=q.poll();
            int row=cell[0]; 
            int col=cell[1];

            for(int[] dir: directions){
                int newRow=row+dir[0];
                int newCol=col+dir[1];

                if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && grid[newRow][newCol]=='1'){
                    q.add(new int[]{newRow,newCol});
                    grid[newRow][newCol]='0';
                }
            }
        }
    }

}

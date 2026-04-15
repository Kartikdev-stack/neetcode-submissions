class Solution {
    public int numIslands(char[][] grid) {


        if(grid==null || grid.length==0 || grid[0].length==0 ){
            return 0;
        }

        int count=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int i, int j){
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[] {i,j});
        grid[i][j]='0';

        while(!queue.isEmpty()){
            int[] cell=queue.poll();
            int row=cell[0];
            int col=cell[1];

            int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
            for(int dir[]: directions){
                int newRow=row+dir[0];
                int newCol=col+dir[1];

                if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && grid[newRow][newCol]=='1'){
                    grid[newRow][newCol]='0';
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

    }
}

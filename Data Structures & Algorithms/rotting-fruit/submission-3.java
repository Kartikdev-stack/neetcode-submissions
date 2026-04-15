class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }
        
        int freshCount=0;
        Queue<int[]> queue=new LinkedList<>();

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.offer(new int[] {i,j});
                }

                if(grid[i][j]==1){
                    freshCount++;
                }
            }
        }

        if(freshCount==0)
            return 0;

        int minutes=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int k=0;k<size;k++){
                int[] cell= queue.poll();
                int row=cell[0];
                int col=cell[1];

                int[][] directions={{-1,0},{0,-1},{0,1},{1,0}};

                // exploring each direction one by one
                for(int dir[]: directions){

                    int newRow=row + dir[0];
                    int newCol=col + dir[1];

                    if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && grid[newRow][newCol]==1){
                        grid[newRow][newCol]=2;
                        queue.offer(new int[] {newRow,newCol});
                        freshCount--;
                    }
                }
            }

            minutes++;
        }

        if(freshCount==0){
            return minutes-1;
        }
        return -1;
    }
}

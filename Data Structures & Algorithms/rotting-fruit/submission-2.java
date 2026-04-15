class Solution {

    public int orangesRotting(int[][] grid) {

        int count=0; // represents fresh fruits
        int time=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i,j}); // identifiying all the rotten fruits
                }else if(grid[i][j]==1){
                    count++;
                }
            }
        }

        int[][] directions={{-1,0},{1,0},{0,-1},{0,1}}; // defining the coordinates

        while(!q.isEmpty() && count>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] cell=q.poll();
                int row=cell[0];
                int col=cell[1];

                // eksploring the neigbors level wise
                for(int[] dir: directions){
                    int newRow=row+dir[0];
                    int newCol=col+dir[1];

                    // Check boundary and visit conditions

                    if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && grid[newRow][newCol]==1){
                        q.add(new int[] {newRow, newCol});   
                        grid[newRow][newCol]=2; // mark as rotten
                        count--;
                    }
                }
            }
            time++;
        }

        if(count>0){
            return -1; // impossible state ( fresh fruits eksist)
        }

        return time;
    }
}

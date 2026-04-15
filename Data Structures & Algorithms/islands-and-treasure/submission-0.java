class Solution {
    public static class Pair{
        int x;
        int y;

        public Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public void islandsAndTreasure(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)
            return;
        
        Queue<Pair> q=new LinkedList<>();
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                   q.offer(new Pair(i,j));
                }
            }
        }

        if(q.isEmpty())
            return;

        while(!q.isEmpty()){
            Pair p=q.poll(); // taking out the items from queue ( dequeue)
            int row=p.x;
            int col=p.y;

            // Checking up

            if(row-1>=0 && grid[row-1][col] == Integer.MAX_VALUE){
                grid[row-1][col]=grid[row][col]+1;
                q.offer(new Pair(row-1,col));
            }


            //  Checking left

            if(col-1>=0 && grid[row][col-1] == Integer.MAX_VALUE){
                grid[row][col-1]=grid[row][col]+1;
                q.offer(new Pair(row,col-1));
            }

            // Checking down

            if(row+1<grid.length && grid[row+1][col] == Integer.MAX_VALUE){
                grid[row+1][col] = grid[row][col]+1;
                q.offer(new Pair(row+1,col));
            }

            // Checking right

            if(col+1<grid[0].length && grid[row][col+1] == Integer.MAX_VALUE){
                grid[row][col+1]=grid[row][col]+1;
                q.offer(new Pair(row,col+1));
            }

        }


    }
}

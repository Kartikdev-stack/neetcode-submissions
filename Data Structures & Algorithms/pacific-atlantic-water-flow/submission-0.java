class Solution {
    private int rows;
    private int cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> results=new ArrayList();
        if(heights==null || heights.length==0 || heights[0].length==0){
            return results;   // cehcking edge cases
        }

        rows=heights.length;
        cols=heights[0].length;

        // Initialising the boolean matrices

        boolean[][] canReachPacific=new boolean[rows][cols];
        boolean[][] canReachAtlantic=new boolean[rows][cols];

        // lets start applying dfs to border conditions

        // Pacific Border
        for(int col=0;col<cols;col++){
            dfs(heights,0,col,canReachPacific);  // top row
        }

        for(int row=0;row<rows;row++){
            dfs(heights,row,0,canReachPacific);  // left column
        }
                
        // Atlantic Border

        for(int col=0;col<cols;col++){
            dfs(heights,rows-1,col,canReachAtlantic);  // bottom row
        }
        
        for(int row=0;row<rows;row++){
            dfs(heights,row,cols-1,canReachAtlantic);  // right column
        }

        for(int row=0;row<rows;row++){
            for(int col=0;col<cols;col++){
                if(canReachPacific[row][col] && canReachAtlantic[row][col]){
                    results.add(Arrays.asList(row,col));
                }
            }
        }

        return results;
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] visited){
        visited[row][col]=true;

        // Checking the top
        if(isValid(row-1,col) && !visited[row-1][col] && heights[row-1][col]  >= heights[row][col] ){
            dfs(heights,row-1,col,visited);
        }

        // Checking the right

        if(isValid(row,col+1) && !visited[row][col+1] && heights[row][col+1]  >= heights[row][col]){
            dfs(heights,row,col+1,visited);
        }

        // Checking the left

        if(isValid(row,col-1) && !visited[row][col-1] && heights[row][col-1]  >= heights[row][col]){
            dfs(heights,row,col-1,visited);
        }

        // Checking the bottom

        if(isValid(row+1,col) && !visited[row+1][col] && heights[row+1][col]  >= heights[row][col] ){
            dfs(heights,row+1,col,visited);
        }


    }

    private boolean isValid(int row, int col){
        return row>=0 && row<rows && col>=0 && col<cols;
    }

}

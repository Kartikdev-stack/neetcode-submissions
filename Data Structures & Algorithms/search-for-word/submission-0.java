class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited=new boolean[board.length][board[0].length]; // Defining a visiting array
 
        // Since the word can start from any index we check each cell
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                boolean exists=backtrack(board, word, i, j, 0, visited);
                
                if(exists){
                    return true;
                }

            }
        }

        return false;
    }

    public boolean backtrack(char[][] board, String word, int row, int col, int idx, boolean[][] visited){
        
        if(idx==word.length()){
            return true;
        }
    
        if(row<0 || row>=board.length || col<0 || col>=board[0].length || visited[row][col]==true || board[row][col]!=word.charAt(idx)){
            return false;
        }

        visited[row][col]=true;
        boolean match_found=backtrack(board,word,row-1,col,idx+1,visited) || backtrack(board,word,row+1,col,idx+1,visited) || backtrack(board,word,row,col+1,idx+1,visited) || backtrack(board,word,row,col-1,idx+1,visited);
        visited[row][col]=false;
     
        return match_found;
    }


}

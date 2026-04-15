class Solution {
    public void solve(char[][] board) {
        if(board==null || board.length==0 || board[0].length==0){
            return; // checking null conditions
        }

        // top and bottom row
        for(int j=0;j<board[0].length;j++){
            if(board[0][j]=='O'){
                dfs(board,0,j); // top row
            }

            if(board[board.length-1][j]=='O'){
                dfs(board,board.length-1,j); // bottom row
            }
        }

        // left and right column

        for(int i=0;i<board.length;i++){
            if(board[i][0]=='O'){
                dfs(board,i,0);
            }

            if(board[i][board[0].length-1]=='O'){
                dfs(board,i,board[0].length-1);
            }
        }

        // Convert the non-boundary Os to X

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='#')
                    board[i][j]='O';  // print the safe Os in modified board
            }
        }


    }

    public void dfs(char[][] board, int i, int j){
        // check boundary conditions 

        if(i<0 || i>=board.length || j<0 || j>=board[0].length || board[i][j]!='O'){
            return;
        }

        board[i][j]='#'; // mark the boundary connected 0 with a temp char #

        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);

    }

}

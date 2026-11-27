class Solution {
    int rows;
    int cols;
    public void dfs(int row, int col, char[][] board, boolean visited[][]){
        if(row<0 || row>=rows || col<0 || col>=cols || board[row][col]=='X' || visited[row][col]) return ;
        visited[row][col]=true;
        int adjlist[][]={{row+1, col}, {row-1, col}, {row, col+1},{row, col-1}};
        for(int neighbour[]: adjlist){
            dfs(neighbour[0], neighbour[1], board, visited);
        }
    }
    public void solve(char[][] board) {
        rows=board.length;
        cols=board[0].length;
        boolean[][] visited= new boolean[rows][cols];
        for(int i=0; i<rows; i++){
            if(board[i][0]=='O' && !visited[i][0])
            dfs(i, 0, board, visited);
             if(board[i][cols-1]=='O' && !visited[i][cols-1])
            dfs(i, cols-1, board, visited);
        }
        for(int j=0; j<cols; j++){
            if(board[0][j]=='O' && !visited[0][j])
            dfs(0,j, board, visited);
             if(board[rows-1][j]=='O' && !visited[rows-1][j])
            dfs(rows-1,j, board, visited);
        }
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(board[i][j]=='O' && !visited[i][j])
                board[i][j]='X';
            }
        }
    }
}
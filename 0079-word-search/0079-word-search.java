class Solution {
    public boolean exist(char[][] board, String word) {
       int m=board.length;
        int n=board[0].length; 
        for(int r=0; r<m;r++){
            for(int c=0; c<n; c++){
                if(board[r][c]==word.charAt(0)){
                    boolean found= dfs(board, word, r, c, 0);
                    if(found) return true;

                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word ,int r, int c, int wordindex){
        if(word.length()==wordindex) return true;
        int rows=board.length;
        int cols=board[0].length;
        if(r<0 || r>=rows || c<0 || c>=cols) return false;
        if(board[r][c]=='.' || board[r][c]!=word.charAt(wordindex)) return false;
        char ch=board[r][c];
        board[r][c]='.';
        if(dfs(board, word, r+1, c, wordindex+1)||
        dfs(board, word, r-1, c, wordindex+1)||
        dfs(board, word, r, c+1, wordindex+1)||
        dfs(board, word, r, c-1, wordindex+1)) return true;
        board[r][c]=ch;
        return false;

    }
}
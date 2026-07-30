class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalcolor=image[sr][sc];
        if(originalcolor==color) return image;
        dfs(image, sr, sc, originalcolor, color);
        return image;
    }
    public void dfs(int[][] image, int row, int col, int originalcolor, int newcolor){
        int rows=image.length;
        int cols=image[0].length;
        if(row<0 || row>=rows ||
        col<0 || col>=cols ||
        image[row][col]!=originalcolor) return;
         
         image[row][col]=newcolor;
        dfs(image, row+1, col, originalcolor, newcolor);
        dfs(image, row-1, col, originalcolor, newcolor);
        dfs(image, row, col+1, originalcolor, newcolor);
        dfs(image, row, col-1, originalcolor, newcolor);

    }
}
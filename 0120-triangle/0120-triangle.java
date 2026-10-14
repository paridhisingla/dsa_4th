class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size=triangle.size();
        int[][] dp= new int[size+1][size+1];
        for(int level=size-1; level>=0; level--){
            for(int j=0; j<=level; j++){
                dp[level][j]=triangle.get(level).get(j)+Math.min(dp[level+1][j], dp[level+1][j+1]);
            }
        }
        return dp[0][0];
    }
}
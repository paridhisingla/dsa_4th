class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size=triangle.size();
        int[][] dp= new int[size+1][size+1];
        for(int level=size-1; level>=0 ; level--){
            for(int i=0; i<=level; i++){
                dp[level][i]=triangle.get(level).get(i)+Math.min(dp[level+1][i], dp[level+1][i+1]);
            }
        }
        return dp[0][0];
    }
}
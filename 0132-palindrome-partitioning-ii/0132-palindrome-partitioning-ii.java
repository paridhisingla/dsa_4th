class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = i; // max cuts = i (worst case: all single chars)
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) &&
                    (i - j <= 1 || isPal[j + 1][i - 1])) {
                    isPal[j][i] = true;

                    if (j == 0) {
                        dp[i] = 0; // whole substring [0..i] is palindrome
                    } else {
                        dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
        }
        return dp[n - 1];
    }
}

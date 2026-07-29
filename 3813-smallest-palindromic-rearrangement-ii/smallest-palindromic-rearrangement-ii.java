class Solution {
    private static final int LIMIT = 1_000_001;

    public String smallestPalindrome(String s, int k) {
        int[] cnt = new int[26];
        for (char ch : s.toCharArray()) {
            cnt[ch - 'a']++;
        }

        int[] half = new int[26];
        StringBuilder mid = new StringBuilder();
        int halfLen = 0;

        for (int i = 0; i < 26; i++) {
            half[i] = cnt[i] / 2;
            halfLen += half[i];
            if ((cnt[i] & 1) == 1) {
                mid.append((char) ('a' + i));
            }
        }

        // Pascal Triangle (clamped to LIMIT)
        int[][] C = new int[halfLen + 1][];
        for (int i = 0; i <= halfLen; i++) {
            C[i] = new int[i + 1];
            C[i][0] = C[i][i] = 1;
            for (int j = 1; j < i; j++) {
                long val = (long) C[i - 1][j - 1] + C[i - 1][j];
                C[i][j] = (int) Math.min(LIMIT, val);
            }
        }

        if (countWays(half, C) < k) return "";

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;

                half[c]--;
                int ways = countWays(half, C);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                }

                k -= ways;
                half[c]++;
            }
        }

        String right = new StringBuilder(left).reverse().toString();
        return left.toString() + mid.toString() + right;
    }

    private int countWays(int[] freq, int[][] C) {
        int rem = 0;
        for (int x : freq) rem += x;

        long ans = 1;
        int cur = rem;

        for (int x : freq) {
            if (x == 0) continue;
            ans = Math.min((long) LIMIT, ans * C[cur][x]);
            if (ans >= LIMIT) return LIMIT;
            cur -= x;
        }

        return (int) ans;
    }
}
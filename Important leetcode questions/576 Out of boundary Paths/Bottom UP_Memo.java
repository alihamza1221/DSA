class Solution {
    int mod = (int) Math.pow(10, 9) + 7;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Map<String, Integer> cache = new HashMap<>();
        return helper(m, n, maxMove, startRow, startColumn, cache);
    }

    public int helper(int m, int n, int maxMove, int startRow, int startColumn, Map<String, Integer> cache) {
        if (startRow >= m || startRow < 0 || startColumn < 0 || startColumn >= n)
            return 1;
        if (maxMove == 0)
            return 0;

        String key = maxMove + ":" + startRow + ":" + startColumn;
        if (cache.containsKey(key))
            return cache.get(key);

        int ans = 0;
        ans = (ans + helper(m, n, maxMove - 1, startRow + 1, startColumn, cache)) % mod;
        ans = (ans + helper(m, n, maxMove - 1, startRow, startColumn + 1, cache)) % mod;
        ans = (ans + helper(m, n, maxMove - 1, startRow - 1, startColumn, cache)) % mod;
        ans = (ans + helper(m, n, maxMove - 1, startRow, startColumn - 1, cache)) % mod;

        cache.put(key, ans);
        return ans;
    }
}

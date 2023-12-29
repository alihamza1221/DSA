class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if (d == 0)
            return -1;
        if (n < d)
            return -1;

        Map<String, Integer> cache = new HashMap<>();

        return dfs(jobDifficulty, n, d, 0, cache, 0);
    }

    public int dfs(int[] jobDifficulty, int n, int d, int idx, Map<String, Integer> cache, int cur_max) {
        if (idx == n) {
            if (d == 0)
                return 0;
            else
                return Integer.MAX_VALUE - 1000;
        }
        if (d <= 0)
            return Integer.MAX_VALUE - 1000;

        String key = idx + ":" + d + ":" + cur_max;
        
        if (cache.containsKey(key))
            return cache.get(key);

        cur_max = Math.max(cur_max, jobDifficulty[idx]);
        int res = Math.min(
            cur_max + dfs(jobDifficulty, n, d - 1, idx + 1, cache, 0), // next day
            dfs(jobDifficulty, n, d, idx + 1, cache, cur_max) // cur day
        );

        cache.put(key, res);
        return res;
    }
}

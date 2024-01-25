class Solution {
    private static final int mod = (int) 1e9 + 7;
    private static int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    private Long[][] dp;

    public int numberOfGoodSubsets(int[] nums) {
        Map<Integer,Integer> count = new HashMap<>();
        for(int num : nums) count.put(num, count.getOrDefault(num, 0) + 1);
        Integer[] arr = count.keySet().toArray(Integer[]::new);
        int n = arr.length;
        dp = new Long[n][1024];
        long ans = solve(0, 0, arr, n, count) - 1;
        return (int) (ans * binaryExp(2, count.getOrDefault(1, 0)) % mod);
    }
    private long solve(int idx, int primeMask, Integer[] nums, int n, Map<Integer,Integer> count) {
        if(idx == n) return 1;
        if(dp[idx][primeMask] != null) return dp[idx][primeMask];
        int num = nums[idx];
        long notPick = solve(idx + 1, primeMask, nums, n, count);
        long pick = 0;
        if(num != 1) {
            int newPrimeMask = getPrimeMask(num, primes);
            if(num % 4 != 0 && num % 9 != 0 && num % 25 != 0
            && (primeMask & newPrimeMask) == 0) {
                pick = solve(idx + 1, primeMask | newPrimeMask, nums, n, count) * count.get(num) % mod;
            }
        }
        return dp[idx][primeMask] = pick + notPick;
    }

    private int getPrimeMask(int num, int[] primes) {
        int mask = 0;
        int len = primes.length;
        for(int i = 0; i < len; i++) {
            if(num % primes[i] == 0) {
                mask |= 1 << i;
            }
        }
        return mask;
    }

    private long binaryExp(long x, int y) {
        if(y == 0) return 1;
        if(y % 2 == 1) {
            return x * binaryExp(x, y - 1) % mod;
        }
        return binaryExp(x * x % mod, y / 2);
    }
}
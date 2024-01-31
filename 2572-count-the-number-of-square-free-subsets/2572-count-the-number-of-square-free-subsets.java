class Solution {
    int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
    private static final int MOD = 1000000007;
    public int squareFreeSubsets(int[] nums) {
        Long[][] memo = new Long[31][1 << 11];
        int[] freq = new int[31];
        for (int num : nums) {
            freq[num]++;
        }
        for (int i = 4; i <= 30; i += 4) {
            freq[i] = 0;
        }
        for (int i = 9; i <= 30; i += 9) {
            freq[i] = 0;
        }
        freq[25] = 0;
        long result = dfs(2, 0, freq, memo);
        for (int i = 0; i < freq[1]; i++) {
            result = (result * 2) % MOD;
        }
        return (int) ((result - 1 + MOD) % MOD);
    }
    private long dfs(int num, int mask, int[] freq, Long[][] memo) {
        // termination condition
        if (num >= 31) {
            return 1;
        }
        if (memo[num][mask] != null) {
            return memo[num][mask];            
        }
        long result = dfs(num + 1, mask, freq, memo);
        // do add num
        boolean addNum = true;
        int maskNext = mask;
        for (int i = 0; i < primes.length; i++) {
            if (num % primes[i] == 0) {
                if ((maskNext & (1 << i)) > 0) {
                    addNum = false;
                    break;
                } else {
                    maskNext |= (1 << i);
                }
            }            
        }
        if (addNum && freq[num] > 0) {
            result = (result + freq[num] * dfs(num + 1, maskNext, freq, memo) % MOD) % MOD;
        }
        memo[num][mask] = result;
        return result;
    }
}

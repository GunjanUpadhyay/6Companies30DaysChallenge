class Solution {
    public int maxRotateFunction(int[] nums) {
       int n = nums.length;
        int totalSum = 0;
        int perRoundSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            perRoundSum += i * nums[i];
        }
        int answer = perRoundSum;
        for (int i = 1; i < n; i++) {
            int rotatedNum = nums[n - i];
            perRoundSum = perRoundSum - (rotatedNum * (n - 1)) + (totalSum - rotatedNum);
            answer = Math.max(answer, perRoundSum);
        }

        return answer; 
    }
}
class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;
        
        int[][] stoneValues = new int[n][3];
        
        for(int i = 0; i < n; i++){
            stoneValues[i] = new int[]{aliceValues[i], bobValues[i],  (aliceValues[i] + bobValues[i])};
        }
        Arrays.sort(stoneValues, (a, b) -> (b[2] - a[2]));
        
        int aliceScore = 0;
        for(int i = 0; i < n; i++){
            
            if(i % 2 == 0){
                aliceScore += stoneValues[i][0];
            }else{
                aliceScore -= stoneValues[i][1];
            }
        }
        
        if(aliceScore > 0) return 1;
        if(aliceScore < 0) return -1;
        
        return 0;
    }
}
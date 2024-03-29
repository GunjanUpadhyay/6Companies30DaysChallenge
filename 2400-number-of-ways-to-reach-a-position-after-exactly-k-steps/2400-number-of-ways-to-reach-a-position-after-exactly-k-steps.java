class Solution {
public int numberOfWays(int startPos, int endPos, int k) {
        //Creating a dp array
        int[][] dp=new int[3000][k+1];
        //Fill the dp array with -1
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(startPos,endPos,k,dp);
    }
    public int helper(int startPos,int endPos,int k,int[][] dp){
       
        if(startPos==endPos && k==0){
            return 1;
        }
        if(k==0){
            return 0;
        }
        if(dp[startPos+1000][k]!=-1){
            return dp[startPos+1000][k];
        }
        
        int left=helper(startPos-1,endPos,k-1,dp);
        
        int right=helper(startPos+1,endPos,k-1,dp);

        dp[startPos+1000][k]=(left+right)%((int)1e9+7);
        return dp[startPos+1000][k];
    }
}
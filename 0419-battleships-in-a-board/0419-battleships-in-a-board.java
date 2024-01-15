class Solution {
    public int countBattleships(char[][] board) {
        boolean[][] visited=new boolean[board.length][board[0].length];
        for(int i=0; i<board.length ; i++){
            for(int j=0; j<board[0].length ; j++){
                if(board[i][j]=='.'){
                  visited[i][j]=true;
                }
            }
        }
        int count=0;
        for(int i=0; i<visited.length; i++){
            for(int j=0; j<visited[0].length ; j++){
                if(!visited[i][j]){
                    count++;
                    dfs(board,i,j,visited);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] board, int i, int j, boolean[][] visited){
        if(i>=board.length || i<0 || j>=board[0].length || j<0 || visited[i][j]){
            return;
        }
        visited[i][j]=true;
        dfs(board,i+1,j,visited); 
        dfs(board,i-1,j,visited);
        dfs(board,i,j+1,visited);
        dfs(board,i,j-1,visited);      
    }
}
class Solution {
    public int minDays(int[][] grid) {
        
        int m=grid.length,n=grid[0].length;
        boolean visited[][]=new boolean[m][n];
        int islandCount=0;

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j]==1 && !visited[i][j]){
                    islandCount++;
                    countIsland(i,j,grid,visited,m,n);
                }

        if(islandCount > 1)
            return 0;

        int onesCount=0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 1){
                    onesCount++;
                    grid[i][j] = 0;
                    if(checkIsland(grid) > 1)
                        return 1;
                    grid[i][j] = 1;
                }
            }
        }

        return (onesCount == 0) ? 0 :(onesCount == 1) ? 1 : 2;

    }
    public int checkIsland(int[][] grid){
        int islandCount=0;
        int m=grid.length,n=grid[0].length;
        boolean visited[][]=new boolean[m][n];

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
                if(grid[i][j]==1 && !visited[i][j]){
                    islandCount++;
                    countIsland(i,j,grid,visited,m,n);
                }

        return islandCount;

    }

    public void countIsland(int r,int c,int[][] grid,boolean[][] visited,int m,int n){

        visited[r][c]=true;
        int arr1[]={ 0, 0, -1, 1 };
        int arr2[]={ 1, -1, 0, 0 };

        for(int i=0;i<4;i++){
            int nr = r + arr1[i];
            int nc = c + arr2[i];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1 && !visited[nr][nc])
                countIsland(nr,nc,grid,visited,m,n);
        }
    }
}
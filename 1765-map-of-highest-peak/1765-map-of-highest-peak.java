class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[][] mat = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
             Arrays.fill(mat[i], -1);
            for (int j = 0; j < m; j++) {
               
                if (isWater[i][j] == 1) {
                    mat[i][j] = 0;
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || y < 0 || x >= n || y >= m || mat[x][y] != -1) continue;
                mat[x][y] = mat[cur[0]][cur[1]] + 1;
                queue.add(new int[]{x, y});
            }
        }
        return mat;
    }
}
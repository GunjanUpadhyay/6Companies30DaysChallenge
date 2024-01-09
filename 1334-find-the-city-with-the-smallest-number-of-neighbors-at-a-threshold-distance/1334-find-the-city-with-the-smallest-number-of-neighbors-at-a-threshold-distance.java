class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = (int) (1e9); // Represents no direct connection
            }
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            ans[from][to] = weight; // Distance along direct edge
            ans[to][from] = weight; // Bidirectional connections
        }

        for (int i = 0; i < n; i++) {
            ans[i][i] = 0;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (ans[i][k] == (int) (1e9) || ans[k][j] == (int) (1e9)) {
                        continue;
                    }
                    ans[i][j] = Math.min(ans[i][j], ans[i][k] + ans[k][j]);
                }
            }
        }
        int minReachableCities = n;
        int optimalCity = -1;

        for (int city = 0; city < n; city++) {
            int reachableCities = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (ans[city][adjCity] <= distanceThreshold) {
                    reachableCities++;
                }
            }
            if (reachableCities <= minReachableCities) {
                if (reachableCities < minReachableCities || city > optimalCity) {
                    minReachableCities = reachableCities;
                    optimalCity = city;
                }
            }
        }
        return optimalCity;
    }
}
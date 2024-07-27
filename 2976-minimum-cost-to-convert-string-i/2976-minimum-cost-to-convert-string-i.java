class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {

        if (source.length() != target.length()) {
            return -1; 
        }

        int[][] dist = new int[26][26];

        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                if (i == j) {
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < cost.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            int w = cost[i];

            dist[u][v] = Math.min(dist[u][v], w); 
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        long minCost = 0; 

        for (int i = 0; i < source.length(); i++) {
            int row = source.charAt(i) - 'a';
            int col = target.charAt(i) - 'a';
            if (dist[row][col] == Integer.MAX_VALUE) {
                return -1;
            } else {
                minCost += dist[row][col];
            }
        }
        return minCost;
    }
}

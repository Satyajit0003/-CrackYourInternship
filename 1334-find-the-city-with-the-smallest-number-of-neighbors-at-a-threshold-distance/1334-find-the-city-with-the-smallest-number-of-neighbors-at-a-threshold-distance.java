import java.util.*;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Initialize the distance matrix with infinity
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 2); // Use a large number to represent infinity
            dist[i][i] = 0; // Distance from a node to itself is zero
        }

        // Fill in the initial distances based on the edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        // Apply the Floyd-Warshall algorithm
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Determine the city with the smallest number of reachable cities within the distance threshold
        int minReachableCities = Integer.MAX_VALUE;
        int resultCity = -1;

        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }
            if (reachableCities <= minReachableCities) {
                if (reachableCities < minReachableCities || i > resultCity) {
                    minReachableCities = reachableCities;
                    resultCity = i;
                }
            }
        }

        return resultCity;
    }
}


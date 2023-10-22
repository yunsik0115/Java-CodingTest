package Concepts.dijkstra;

import java.util.Arrays;
import java.util.Stack;

public class Main {

    /***
     * Dijkstra Algorithm With Adjacent Matrix
     */

    private static final int INF = Integer.MAX_VALUE;

    // 다익스트라 알고리즘 함수
    public static int[] dijkstra(int[][] graph, int start, int[] predecessor) { // Distancing
        int length = graph.length; // # of row
        int[] dist = new int[length];
        boolean[] visited = new boolean[length];

        Arrays.fill(dist, INF);
        dist[start] = 0;

        for (int i = 0; i < length - 1; i++) {
            int u = findMinimumDistanceNode(dist, visited);
            visited[u] = true;

            for (int v = 0; v < length; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                    predecessor[v] = u;  // v 노드에 대한 이전 노드를 u로 설정
                }
            }
        }

        return dist;
    }

    private static int findMinimumDistanceNode(int[] distance, boolean[] visited) {
        int min = INF, minIndex = -1;

        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] <= min) {
                min = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    // 주어진 노드로부터 시작 노드까지의 경로를 출력하는 함수 (BFS)
    public static void printPath(int[] predecessor, int end) {
        Stack<Integer> path = new Stack<>();
        int node = end;

        while (node != -1) {
            path.push(node);
            node = predecessor[node];
        }

        System.out.print("Path: ");
        while (!path.isEmpty()) {
            System.out.print(path.pop()+1 + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        int[] predecessor = new int[graph.length];
        Arrays.fill(predecessor, -1);

        int[] dist = dijkstra(graph, 0, predecessor);

        for (int i = 0; i < graph.length; i++) {
            System.out.println("To node " + (i+1) + ", distance: " + dist[i]);
            printPath(predecessor, i);
        }
    }
}

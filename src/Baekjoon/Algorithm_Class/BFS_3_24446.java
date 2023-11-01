package Baekjoon.Algorithm_Class;

import java.io.*;
import java.util.*;

public class BFS_3_24446 {
    static int n;
    static int m;
    static int r;
    static boolean[] isVisited;

    static int[] depth;

    static Map<Integer, LinkedList<Integer>> graphList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        depth = new int[n + 1];

        isVisited = new boolean[n + 1];
        Arrays.fill(isVisited, false);
        Arrays.fill(depth, -1);
        isVisited[0] = true;

        graphList = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            graphList.put(i, new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graphList.get(u).add(v);
            graphList.get(v).add(u);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(graphList.get(i));
        }

        br.close();

        bfs_list(bw, r, isVisited);

        for (int i = 1; i <= n; i++) {
            bw.write(Integer.toString(depth[i]));
            if(i != n) bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    public static void bfs_list(BufferedWriter bw, int v, boolean[] visited) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        queue.add(v);

        while (!queue.isEmpty()) {
            v = queue.poll();
            visited[v] = true;
            ++depth[v];
            List<Integer> nodes = graphList.get(v);
            for (Integer node : nodes) {
                if (!visited[node]) {
                    queue.add(node);
                }
            }
            count++;
        }

    }
}

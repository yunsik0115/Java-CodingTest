package Baekjoon.Algorithm_Class;

import java.io.*;
import java.util.*;

public class BFS_1_24444 {

    static int n;
    static int m;
    static int r;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        isVisited = new boolean[n + 1];
        Arrays.fill(isVisited, false);
        isVisited[0] = true;

        LinkedList[] adjList = new LinkedList[n + 1];

        for (int i = 0; i <= n; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adjList[u].add(v);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(adjList[i]);
        }

        br.close();

        bfs_list(bw, 1, adjList, isVisited);
        bw.flush();
        bw.close();
    }

    public static void bfs_list(BufferedWriter bw, int v, LinkedList<Integer>[] adjList, boolean[] visited) throws IOException {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[v] = true;
        queue.add(v);

        while(queue.size() != 0) {
            v = queue.poll();
            bw.write(v + "\n");

            Iterator<Integer> iter = adjList[v].listIterator();
            while(iter.hasNext()) {
                int w = iter.next();
                if(!visited[w+1]) {
                    visited[w+1] = true;
                    queue.add(w);
                }
            }
        }

        for(int i = 0; i<n; i++){
            if(!isVisited[i+1]){
                bw.write("0\n");
            }
        }
    }
}

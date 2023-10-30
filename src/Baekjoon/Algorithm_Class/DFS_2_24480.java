package Baekjoon.Algorithm_Class;

import java.io.*;
import java.util.*;

public class DFS_2_24480 {static int n;
    static int m;
    static int r;
    static boolean[] isVisited;

    static int[] order;

    static Map<Integer, LinkedList<Integer>> graphList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        order = new int[n + 1];

        isVisited = new boolean[n + 1];
        Arrays.fill(isVisited, false);
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

        dfs_list(bw, r);

        for (int i = 1; i <= n; i++) {
            bw.write(Integer.toString(order[i]) + "\n");
        }

        bw.flush();
        bw.close();
    }

    public static void dfs_list(BufferedWriter bw, int v) throws IOException {
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        stack.add(v);
        while (!stack.isEmpty()) {
            v = stack.pop();

            if(isVisited[v]) {continue;}

            isVisited[v]=true;
            order[v] = ++count;

            LinkedList<Integer> nodes = graphList.get(v);
            for (Integer node : nodes) {
                if(!isVisited[node]) {
                    stack.push(node);
                }
            }
        }
    }
}

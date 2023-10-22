package Baekjoon.MandN;

import java.io.*;
import java.util.StringTokenizer;

public class Q2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String condition = br.readLine();
        StringTokenizer st = new StringTokenizer(condition, " ");

        int n = Integer.parseInt(st.nextToken()); // 자연수 개수 - Level
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n];
        int[] output = new int[m];
        int start = 1;

        if (n < m) {
            throw new IllegalArgumentException("Invalid Argument");
        }

        dfsSolution(start, n, m, 0, output, visited);



    }

    static void dfsSolution(int start, int n, int m, int depth, int[] output, boolean[] visited){

        if(depth == m){
            for (int i = 0; i < m; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = start; i<=n; i++){
            if(!visited[i-1]){
                output[depth] = i;
                visited[i - 1] = true;
                dfsSolution(i + 1, n, m, depth + 1, output, visited);
                visited[i - 1] = false;
            }
        }

    }

}

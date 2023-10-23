package Baekjoon.MandN;

import java.io.*;
import java.util.StringTokenizer;

public class Q3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String condition = br.readLine();
        StringTokenizer st = new StringTokenizer(condition, " ");

        int n = Integer.parseInt(st.nextToken()); // 자연수 개수 - Level
        int m = Integer.parseInt(st.nextToken());

        int[] output = new int[m];

        dfsSolution(n, m, 0, output, bw);
        br.close();
        bw.flush();
        // Note that .flush() Operation is extremely heavy instruction.
        bw.close();
    }
    static void dfsSolution(int n, int m, int depth, int[] output, BufferedWriter bw) throws IOException {

        if(depth == m){
            for (int i = 0; i < m; i++) {
                bw.write(Integer.toString(output[i]) + " ");
            }
            bw.write("\n");
            // Placing Flush here can heavily affect Time Complexity;
            return;
        }
        for(int i = 1; i<=n; i++){
                output[depth] = i;
                dfsSolution(n, m, depth + 1, output, bw);
            }


    }

}


package Baekjoon.MandN;

import java.io.*;
import java.util.StringTokenizer;

public class Q4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String condition = br.readLine();
        StringTokenizer st = new StringTokenizer(condition, " ");

        int n = Integer.parseInt(st.nextToken()); // 자연수 개수 - Level
        int m = Integer.parseInt(st.nextToken());
        int[] output = new int[m];
        int start = 1;

        if (n < m) {
            throw new IllegalArgumentException("Invalid Argument");
        }

        dfsSolution(start, n, m, 0, output, bw);

        br.close();
        bw.flush();
        bw.close();


    }

    static void dfsSolution(int start, int n, int m, int depth, int[] output, BufferedWriter bw) throws IOException {

        if (depth == m) {
            for (int i = 0; i < m; i++) {
                bw.write(Integer.toString(output[i]) + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = start; i <= n; i++) {

            output[depth] = i;
            dfsSolution(i, n, m, depth + 1, output, bw);

        }
    }

}


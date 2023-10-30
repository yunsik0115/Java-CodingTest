package Baekjoon.Algorithm_Class;

import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class MatrixRouting_1_24418 {

    static int n;

    static int count = 0;
    static int countDp= 0;

    static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int[][] m = new int[n][n];
        d = new int[n][n];

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int index = 0; index<n; index++){
                m[i][index] = Integer.parseInt(st.nextToken());
            }
        } // Creating Matrix

        int i = matrix_path(m,n - 1);
        int i1 = matrix_path_dp(m, n);
        bw.write(Integer.toString(count));
        bw.write("\n");
        bw.write(Integer.toString(countDp));
        bw.flush();
        bw.close();
        br.close();
    }

    static int matrix_path(int[][] m, int n){
        count++;
        return matrix_path_recursive(m, n, n);
    }

    static int matrix_path_recursive(int[][] m, int i, int j) {
        count++;
        if (i == 0 && j == 0) {
            return m[0][0];
        } else if (i == 0) {
            return m[i][j] + matrix_path_recursive(m, i, j - 1);
        } else if (j == 0) {
            return m[i][j] + matrix_path_recursive(m, i - 1, j);
        } else {
            return m[i][j] + Integer.max(matrix_path_recursive(m, i - 1, j), matrix_path_recursive(m, i, j - 1));
        }
    }

    static int matrix_path_dp(int[][] m, int n) {
        int[][] d = new int[n][n];  // DP table, local initialization to avoid side effects from previous calls

        d[0][0] = m[0][0];

        // Initialize the first row
        for (int j = 1; j < n; j++) {
            d[0][j] = d[0][j-1] + m[0][j];
            countDp++;
        }

        // Initialize the first column
        for (int i = 1; i < n; i++) {
            d[i][0] = d[i-1][0] + m[i][0];
            countDp++;
        }

        // Fill up the rest of the DP table
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                d[i][j] = m[i][j] + Integer.max(d[i-1][j], d[i][j-1]);
                countDp++;
            }
        }

        countDp++;
        return d[n-1][n-1];
    }



}

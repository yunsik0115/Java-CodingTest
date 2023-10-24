package Baekjoon.MandN;

import java.io.*;
import java.util.*;

public class Q7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = 0;

        int[] series = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        int[] output = new int[m];
        for(int i=0; i<n; i++){
            series[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(series);

        seriesDFS(series, start, m, 0, output, bw);

        bw.flush();
        bw.close();
        br.close();
    }

    static void seriesDFS(int[] series, int start, int m, int depth, int[] output, BufferedWriter bw)
            throws IOException{


        if(depth == m){
            for(int i = 0; i< m; i++){
                bw.write(output[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < series.length; i++) {

                output[depth] = series[i];
                seriesDFS(series, i, m, depth + 1, output, bw);

        }


    }
}

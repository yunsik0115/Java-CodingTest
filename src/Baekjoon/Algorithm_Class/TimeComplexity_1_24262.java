package Baekjoon.Algorithm_Class;

import java.io.*;
import java.util.StringTokenizer;

public class TimeComplexity_1_24262 {

    static int[] arr;
    static int execCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        arr = new int[n];

        bw.write(Integer.toString(execCount));
        bw.write("0");

        bw.flush();
        bw.close();
        br.close();

    }

    static int MenOfPassion(int[] arr, int n){
       int i = n / 2;
       execCount++;
       return arr[i];
    }
}

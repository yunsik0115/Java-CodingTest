package Baekjoon.Algorithm_Class;

import java.io.*;
import java.util.StringTokenizer;

public class TimeComplexity_2_24263 {

    static int[] arr;
    static int execCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        arr = new int[n];

        MenOfPassion(arr, n);

        bw.write(Integer.toString(execCount));
        bw.write("\n1");

        bw.flush();
        bw.close();
        br.close();

    }

    static int MenOfPassion(int[] arr, int n){
        int sum = 0;
        for(int i = 0; i<n; i++){
            execCount++;
            sum += arr[i];
        }
        return sum;
    }
}

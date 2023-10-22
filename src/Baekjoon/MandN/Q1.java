package Baekjoon.MandN;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.


3 1

 */

public class Q1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String condition = br.readLine();
        StringTokenizer st = new StringTokenizer(condition, " ");

        int n = Integer.parseInt(st.nextToken()); // 자연수 개수 - Level
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n];

        int[] output = new int[m];

        if (n < m) {
            throw new IllegalArgumentException("Invalid Argument");
        }

        dfsSolution(n, m, 0, output, visited);



    }

    static void dfsSolution(int n, int m, int depth, int[] output, boolean[] visited){

        if(depth == m){
            for (int i = 0; i < m; i++) {
                System.out.print(output[i] + " ");
            }
            System.out.println();
            return;
        }


        for(int i = 1; i<=n; i++){
            if(!visited[i-1]){
                output[depth] = i;
                visited[i-1] = true;
                dfsSolution(n, m, depth + 1, output, visited);
                visited[i - 1] = false;
            }
        }

    }

}

package Baekjoon.vsFeRecommendation;

import java.io.*;
import java.util.StringTokenizer;

public class DropOut_14501 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());

        int[] day = new int[input + 1];
        int[] value = new int[input + 1];
        int[] result = new int[input + 1];

        for(int i = 0; i<input; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            day[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < input; i++) {
            if( i + day[i] <= input ){
                result[i + day[i]] = Math.max(result[i+day[i]], result[i] + value[i]);
            }
            result[i+1] = Math.max(result[i+1], result[i]);
        }

        bw.write(Integer.toString(result[input]));

        bw.flush();
        br.close();
        bw.close();


    }

}

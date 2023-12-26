package Baekjoon.vsFeRecommendation;

import java.io.*;

public class DirectorShom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        int count = 666;
        int index = 0;

        while(true){
            if(Integer.toString(count).contains("666")){
                index++;
                if(index == input) break;
            }
            count++;
        }

        bw.write(Integer.toString(count));
        bw.flush();
        br.close();
        bw.close();
    }


}

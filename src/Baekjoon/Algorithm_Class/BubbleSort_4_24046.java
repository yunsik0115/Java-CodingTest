package Baekjoon.Algorithm_Class;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BubbleSort_4_24046 {
    // Not solved Yet.

    static List<Integer> arrayList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        for (long i = 0; i < n; i++) {
            arrayList.add(Integer.parseInt(st.nextToken()));
        }

        bubbleSort(arrayList, n, k, bw);

        bw.flush();
        bw.close();
        br.close();
    }

    static void bubbleSort(List<Integer> target, int n, int k, BufferedWriter bw) throws IOException {
        int swapNo = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1 ; j++) {
                if (target.get(j) > target.get(j+1)) {
                    ++swapNo;
                    int temp = target.get(j);
                    target.set(j, target.get(j+1));
                    target.set(j+1, temp);
                    if(swapNo == k) {
                        bw.write(Integer.toString(target.get(j)));
                        bw.write(" ");
                        bw.write(Integer.toString(target.get(i+1)));
                        bw.write("\n");
                        return;
                    }
                }
            }
        }
        if(swapNo<k) {
            bw.write("-1\n");
            return;
        }
    }



}

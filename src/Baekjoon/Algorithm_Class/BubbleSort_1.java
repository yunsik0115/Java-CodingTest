package Baekjoon.Algorithm_Class;

import java.io.*;
import java.util.StringTokenizer;

public class BubbleSort_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bubbleSort(arr, n, k, bw);

        bw.flush();
        bw.close();
        br.close();
    }

    static void bubbleSort(int[] target, int n, int k, BufferedWriter bw) throws IOException {
        int swapNo = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1 ; j++) {
                if (target[j] > target[j + 1]) {
                    ++swapNo;
                    int temp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = temp;
                    if(swapNo == k) {
                        bw.write(Integer.toString(target[j]));
                        bw.write(" ");
                        bw.write(Integer.toString(target[j + 1]));
                        return;
                    }
                }
            }
        }
        bw.write("-1");
        return;
    }


}

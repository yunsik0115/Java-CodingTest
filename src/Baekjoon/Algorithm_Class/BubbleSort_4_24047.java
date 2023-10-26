package Baekjoon.Algorithm_Class;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BubbleSort_4_24047 {
    // 배열 입력 사이즈가 큰 경우 나눠서 받고
    // 나눈 배열에서 진행해서 K만큼 도달 가능하면
    // 반환하는 방식으로 생각해보는게 좋을 것 같음

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = (Integer.parseInt(st.nextToken()));
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
                if (arr[j] > arr[j+1]) {
                    ++swapNo;
                    int temp = target[j];
                    target[j] = target[j+1];
                    target[j+1] = temp;
                    if(swapNo == k) {
                        printArray(bw);
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

    static void printArray(BufferedWriter bw) throws IOException{
        for (int i : arr) {
            bw.write(Integer.toString(i));
            bw.write(" ");
        }
        bw.write("\n");
    }



}

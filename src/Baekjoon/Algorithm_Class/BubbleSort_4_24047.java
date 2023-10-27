package Baekjoon.Algorithm_Class;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BubbleSort_4_24047 {
    // Not solved Yet.

    static int[] arr;
    static int swapNo = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int i = 0;
        int turn = 0;

        arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (i = 0; i < n; i++) {
            arr[i] = (Integer.parseInt(st.nextToken()));
        }
        int quotient = n / 5;
        int remainder = n % 5;
        boolean indicator = false;

        if (quotient == 0) {  // 몫이 0인 경우 그냥 깡으로 bubbleSort 전범위 적용
            indicator = bubbleSort(arr, 0, remainder, n, k);
        } else {
            for (turn = 0; turn < quotient; turn++) { // 몫이 0이 아닌 경우 범위별로 bubblesort 실행
                // 몫만큼 반복, 마지막 시행은 remainder만큼만 실행
                if (indicator) {
                    break;
                } // 시행이 끝나기 이전에 swapNo == k 만족시 true를 반환하기 때문에 반복문 정지
                if (remainder != 0 && turn == quotient - 1) {  // 마지막 시행 (나머지만큼)
                    indicator = bubbleSort(arr, turn * 5, (turn + 1) * 5 + remainder, n, k);
                    break; // 정지 (나머지 0인 경우 조건문 패스하고 바로 밑의 줄 실행하게 됨 바로 아래줄 한번 더 실행)
                }
                indicator = bubbleSort(arr, turn * 5, (turn + 1) * 5, n, k);
            }
        }

        if (!indicator) { // 위의 bubbleSort 실행과정에서 최종적으로 swapNo == k를 만족하지 않게 되는 경우, indicator = false는 변화 없음.
            bw.write("-1");
        } else {
            printArray(bw);
        }

        bw.flush();
        bw.close();
        br.close();
    }


    static boolean bubbleSort(int[] target, int start, int end, int n, int k) throws IOException {
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = start; i < n - 1; i++) {
            for (int j = start; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    ++swapNo;
                    int temp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = temp;
                    printArray(bf);
//                    if(swapNo == k){
//                        return true;
//                    }

                }
            }
        }
        bf.flush();
        bf.close();
        return false;
    }

    static void printArray(BufferedWriter bw) throws IOException {
        for (int i : arr) {
            bw.write(Integer.toString(i));
            bw.write(" ");
        }
        bw.write("\n");
    }

}
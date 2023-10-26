package Baekjoon.Algorithm_Class;

import java.io.*;
import java.util.StringTokenizer;

public class BubbleSort_3_23970 {

    static int[] arr1;
    static int[] arr2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());

        arr1 = new int[n];
        arr2 = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        bubbleSort(n, bw);

        bw.flush();
        bw.close();
        br.close();
    }

    static void bubbleSort(int n, BufferedWriter bw) throws IOException {
        if(isArrayEql(arr1, arr2)){
            bw.write("1");
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if(arr1[j] > arr1[j+1]){
                    int temp = arr1[j];
                    arr1[j] = arr1[j+1];
                    arr1[j+1] = temp; // swapped

                    if(arr1[j] == arr2[j] && arr1[j+1] == arr2[j+1]){
                        // Without Verification between each swapped value - Time Complexity skyrockets to O(N^3)
                        // Swapped된 value가 비교대상과 일치하는지 먼저 거르고 O(n) 단위 ArrayEql 함수 실행 (pruning)
                        if(isArrayEql(arr1, arr2)){
                            bw.write("1");
                            return;
                        }
                    }

                }
            }
        }
        bw.write("0");
        return;
    }


    static boolean isArrayEql(int[] arr1, int[] arr2){
        for(int i = 0; i<arr1.length; i++){
            if(arr1[i] != arr2[i]) return false;
        }
        return true;
    }

}

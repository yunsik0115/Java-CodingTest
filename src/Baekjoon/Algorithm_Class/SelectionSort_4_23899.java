package Baekjoon.Algorithm_Class;

/*
N개의 서로 다른 양의 정수가 저장된 배열 A가 있다.
선택 정렬로 배열 A를 오름차순 정렬할 경우 K 번째 교환되는 수를 구해서 우리 서준이를 도와주자.
크기가 N인 배열에 대한 선택 정렬 의사 코드는 다음과 같다.
 */

import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class SelectionSort_4_23899 {

    static int n;
    static int[] target1;
    static int[] target2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        target1 = new int[n];
        target2 = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        // retrieving array values
        for(int i = 0; i<n; i++){
            target1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        // retrieving array values
        for(int i = 0; i<n; i++){
            target2[i] = Integer.parseInt(st.nextToken());
        }

        boolean result = selectionSort(bw);

        if(result){
            bw.write(Integer.toString(1));
        } else{
            bw.write("0");
        }

        bw.flush();
        bw.close();
        br.close();

    }

    static boolean selectionSort(BufferedWriter bf) throws IOException {
        int i, j;
        int max;

        for(i= target1.length - 2; i > 0; i--){
            max = i;
            for(j=i - 1; j >= 0; j--){
                if(target1[max] < target1[j]){
                    max = j;
                }
            }

            // Here we need to make a swap before checking for array equality
            if(i != max) {
                swap(target1, i, max);
            }

            // Now, we check if the arrays are equal
            if(compareArray(target1, target2)){
                return true;
            }
        }
        return false;
    }


    // target array to swap, index1, index2
    static void swap(int[] swapArray, int a, int b){
        int temp = swapArray[a];
        swapArray[a] = swapArray[b];
        swapArray[b] = temp;
    }

    static boolean compareArray(int[] targetA, int[] targetB){
        for(int i = 0; i < n; i++){
            if(targetA[i] != targetB[i]){
                return false;
            }
        }
        return true;
    }

}

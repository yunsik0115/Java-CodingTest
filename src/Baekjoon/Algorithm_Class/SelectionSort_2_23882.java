package Baekjoon.Algorithm_Class;

/*
N개의 서로 다른 양의 정수가 저장된 배열 A가 있다.
선택 정렬로 배열 A를 오름차순 정렬할 경우 K 번째 교환되는 수를 구해서 우리 서준이를 도와주자.
크기가 N인 배열에 대한 선택 정렬 의사 코드는 다음과 같다.
 */

import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class SelectionSort_2_23882 {

    static int n;
    static int k;
    static int[] target;

    static int swapNo = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        target = new int[n];
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        // retrieving array values
        for(int i = 0; i<n; i++){
            target[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = selectionSort();
        printArray(result, bw);

        bw.flush();
        bw.close();
        br.close();

    }

    static int[] selectionSort() throws IOException {
        int i, j;
        int max;

        for(i= target.length - 1; i > 0; i--){
            max = i;
            for(j=i - 1; j >= 0; j--){
                if(target[max] < target[j]){
                    max = j;
                }
            }
            if(i != max) {
                swap(target, i, max);
                swapNo++;
            }
            if(swapNo == k){
                return target;
            }
        }
        return new int[]{-1};
    }

    // target array to swap, index1, index2
    static void swap(int[] target, int a, int b){
        int temp = target[a];
        target[a] = target[b];
        target[b] = temp;
    }

    static void printArray(int[] target, BufferedWriter bw) throws IOException{
        for(int i = 0; i < target.length; i++){
            bw.write(Integer.toString(target[i]));
            bw.write(" ");
        }
        bw.write("\n");
    }
}

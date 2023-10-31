package Baekjoon.Algorithm_Class;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class InsertionSort_3_24053 {

    static int n;
    static int[] arr1;
    static int[] arr2;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        arr1 = new int[n];
        arr2 = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i<n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i<n; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(Integer.toString(insertion_sort(bw)));
        //bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();


    }

    static int insertion_sort(BufferedWriter bw) throws IOException {
        for(int i = 1; i < n; i++){

            int toCompare = i-1;
            int target = arr1[i];

            while(toCompare >=0 && arr1[toCompare] > target){
                // target보다 큰 값들은 모두 target의 오른쪽에 위치해야함

                arr1[toCompare + 1] = arr1[toCompare];
                toCompare--;
                if(Arrays.equals(arr1, arr2)) {
                    return 1;
                }


                // 해당 원소 왼쪽의 있는 값들을 계속 비교하면서
                // 왼쪽 값보다 오른쪽 값이 큰 순간
            }



            if(toCompare + 1 != i){
                arr1[toCompare+1] = target;
            }

            if(Arrays.equals(arr1, arr2)){ return 1;}




        }

        return 0;
    }
    static void printArray(BufferedWriter bw) throws IOException{
        for(int i = 0; i<n; i++){
            bw.write(Integer.toString(arr1[i]));
            bw.write(" ");
        }
        bw.write("\n");
    }

}

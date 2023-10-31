package Baekjoon.Algorithm_Class;

import java.io.*;
import java.util.StringTokenizer;

public class InsertionSort_2_24052 {
    static int n;
    static int k;

    static int count = 0;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(insertion_sort(bw) == -1){
            bw.write(Integer.toString(-1));
        }
        //bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();


    }

    static int insertion_sort(BufferedWriter bw) throws IOException {
        for(int i = 1; i < n; i++){

            int toCompare = i-1;
            int target = arr[i];

            while(toCompare >=0 && arr[toCompare] > target){
                // target보다 큰 값들은 모두 target의 오른쪽에 위치해야함

                arr[toCompare + 1] = arr[toCompare];
                toCompare--;
                count++;
                if(count == k) {
                    printArray(bw);
                    return 1;
                }


                // 해당 원소 왼쪽의 있는 값들을 계속 비교하면서
                // 왼쪽 값보다 오른쪽 값이 큰 순간
            }



            if(toCompare + 1 != i){
                arr[toCompare+1] = target;
                count++;
            }

            if(k==count){printArray(bw); return 1;}




        }

        return -1;
    }
    static void printArray(BufferedWriter bw) throws IOException{
        for(int i = 0; i<n; i++){
            bw.write(Integer.toString(arr[i]));
            bw.write(" ");
        }
        bw.write("\n");
    }

}

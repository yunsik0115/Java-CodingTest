package Baekjoon.Algorithm_Class;

import java.io.*;
import java.util.StringTokenizer;

public class QuickSort_2_24091 {

    static BufferedReader br;
    static BufferedWriter bw;

    static int count = 0;

    static int n;
    static int k;

    static int[] target;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        target = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<n; i++){
            target[i] = Integer.parseInt(st.nextToken());
        }


        quick_sort(0, n - 1, bw);

        if(count < k) bw.write("-1");

        bw.flush();
        bw.close();
        br.close();

    }


    static void quick_sort(int left, int right, BufferedWriter bw) throws IOException{

        if (left >= right){
            return;
        }

        int nextPivot = partition(left, right, bw);

        quick_sort(left, nextPivot-1, bw);
        quick_sort(nextPivot + 1, right, bw);

    }

    static int partition(int left, int right, BufferedWriter bw) throws IOException{
        int pivot = target[right];

        int i = left - 1;

        for(int j = left; j < right; j++){ // all index array search
            if(target[j] <= pivot){ // less  than pivot value - i 이하 위치로
                ++i;
                swap(i, j, bw);
            }
        }

        int pivotPosition = i + 1;
        if(pivotPosition != right) swap(pivotPosition, right, bw);


        return pivotPosition;
    }

    static void swap(int a, int b, BufferedWriter bw) throws IOException{
        ++count;
        int temp = target[a];
        target[a] = target[b];
        target[b] = temp;
        if(count == k){
            printArray(bw);
        }
    }

    static void printArray(BufferedWriter bw) throws IOException{
        for (int i : target) {
            bw.write(Integer.toString(i));
            bw.write(" ");
        }
    }


}

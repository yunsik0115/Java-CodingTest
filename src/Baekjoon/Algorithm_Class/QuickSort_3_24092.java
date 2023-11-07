package Baekjoon.Algorithm_Class;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class QuickSort_3_24092 {

    static BufferedReader br;
    static BufferedWriter bw;

    static int n;

    static boolean isSame = false;

    static int[] sortTarget;
    static int[] target;

    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());

        sortTarget = new int[n];
        target = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<n; i++){
            sortTarget[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i<n; i++){
            target[i] = Integer.parseInt(st.nextToken());
        }

        if(target[0] == sortTarget[0] && target[n-1] == sortTarget[n-1]){
            if (compareArray()) {
                isSame = true;
            }
        }

            quick_sort(0, n - 1);

        if(isSame){
            bw.write("1");
        } else{
            bw.write("0");
        }

        bw.flush();
        bw.close();
        br.close();
    }


    static void quick_sort(int left, int right) throws IOException{

        if (left >= right || isSame){
            return;
        }

        int nextPivot = partition(left, right);

        quick_sort(left, nextPivot-1);
        quick_sort(nextPivot + 1, right);

    }

    static int partition(int left, int right) throws IOException{
        int pivot = sortTarget[right];

        int i = left - 1;

        for(int j = left; j < right; j++){ // all index array search
            if(sortTarget[j] <= pivot){ // less  than pivot value - i 이하 위치로
                ++i;
                swap(i, j);
            }
        }

        int pivotPosition = i + 1;
        if(pivotPosition != right) {
            swap(pivotPosition, right);
        }
        return pivotPosition;
    }

    static void swap(int a, int b){
        int temp = sortTarget[a];
        sortTarget[a] = sortTarget[b];
        sortTarget[b] = temp;

        if(sortTarget[a] == target[a] && sortTarget[b] == target[b]){
            if(compareArray()){
                isSame = true;
            }
        }
    }


    static boolean compareArray(){
        for(int i = 0; i < n; i++){
            if(target[i] != sortTarget[i]) return false;
        }
        return true;
    }


}

package Baekjoon.Algorithm_Class;

/*
N개의 서로 다른 양의 정수가 저장된 배열 A가 있다.
선택 정렬로 배열 A를 오름차순 정렬할 경우 K 번째 교환되는 수를 구해서 우리 서준이를 도와주자.
크기가 N인 배열에 대한 선택 정렬 의사 코드는 다음과 같다.
 */

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class SelectionSort_3_23883 { // 23883

    static int n;
    static int k;

    static Pair[] arr;

    static int swapNo = 0;


    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        FastWriter fw = new FastWriter();

        n = fr.nextInt();
        k = fr.nextInt();

        arr = new Pair[n];

        for(int i = 0; i<n; i++){
            arr[i] = new Pair(i, fr.nextInt());
        }

        Arrays.sort(arr, Comparator.comparingInt(x -> x.getValue()));

        int swaps = 0;
        for (int i = n - 1; i >= 0; i--) {
            // 현재 원소가 올바른 위치에 있는지 확인
            if (arr[i].getIndex() != i) {
                // 교환 전 원소의 값 저장
                int value1BeforeSwap = arr[i].getValue();
                int value2BeforeSwap = arr[arr[i].getIndex()].getValue();

                // 교환
                Pair temp = arr[i];
                arr[i] = arr[temp.getIndex()];
                arr[temp.getIndex()] = temp;

                swapNo++;

                // k번째 교환인지 확인
                if (swapNo == k) {
                    fw.print(value1BeforeSwap + " " + value2BeforeSwap + "\n");
                    fw.close();
                    return;
                }
            }
        }


        fw.print(-1);

        fw.close();

    }

    static class Pair{
        private int index;
        private int value;

        public Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    static boolean swap(int index1, int index2, FastWriter fw) throws IOException {
        // 교환 전의 두 원소의 값을 저장합니다.
        int value1BeforeSwap = arr[index1].getValue();
        int value2BeforeSwap = arr[index2].getValue();

        // 실제로 교환합니다.
        Pair temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

        // 교환 횟수를 증가시킵니다.
        swapNo++;

        // 만약 이 교환이 k번째 교환이면, 교환 전의 두 원소의 값을 출력하고 true를 반환합니다.
        if (swapNo == k) {
            fw.print(value1BeforeSwap + " " + value2BeforeSwap + "\n");
            return true;
        }

        return false;
    }


    static void printArray(FastWriter fw) throws  IOException{
        for (Pair pair : arr) {
            fw.print(pair.getValue() + " ");
        }
        fw.println(" ");
    }




    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }
}

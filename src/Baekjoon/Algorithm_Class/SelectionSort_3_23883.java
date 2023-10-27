package Baekjoon.Algorithm_Class;

import java.io.*;
import java.util.*;

public class SelectionSort_3_23883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Integer[] sorted = new Integer[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = i;
        }

        Arrays.sort(sorted, Comparator.comparingInt(o -> a[o]));

        int[] map = new int[n];
        for (int i = 0; i < n; i++) {
            map[sorted[i]] = i;
        }

        StringBuilder output = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            if (!sorted[i].equals(i)) {
                sorted[map[i]] = sorted[i];
                int temp = map[sorted[i]];
                map[sorted[i]] = map[i];
                map[i] = temp;

                int swapTemp = a[sorted[i]];
                a[sorted[i]] = a[i];
                a[i] = swapTemp;

                k--;
                if (k == 0) {
                    for (int ai : a) {
                        output.append(ai).append(" ");
                    }
                    break;
                }
            }
        }

        if (k > 0) {
            System.out.println("-1");
        } else {
            System.out.print(output.toString());
        }
    }
}

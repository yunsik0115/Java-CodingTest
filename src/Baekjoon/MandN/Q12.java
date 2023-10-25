package Baekjoon.MandN;

import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q12 {
    static List<String> outputList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] series = new int[n];

        st = new StringTokenizer(br.readLine(), " ");

        int[] output = new int[m];
        for (int i = 0; i < n; i++) {
            series[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(series);

        seriesDFS(series, 0, m, 0, output);
        outputList = outputList.stream().distinct().collect(Collectors.toList());
        for (int i = 0; i < outputList.size(); i++) {
            bw.write(outputList.get(i));
            bw.write("\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    static void seriesDFS(int[] series, int start, int m, int depth, int[] output)
            throws IOException {


        if (depth == m) {
            outputList.add(Arrays.toString(output)
                    .replace("[", "")
                    .replace("]", "")
                    .replace(",", ""));
            return;
        }

        for (int i = start; i < series.length; i++) {

            output[depth] = series[i];
            seriesDFS(series, i, m, depth + 1, output);

        }
    }


}

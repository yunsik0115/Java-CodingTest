package Baekjoon.vsFeRecommendation;

import java.io.*;
import java.util.StringTokenizer;

public class DropOut_14501 {

    static class Appointment{
        int days;
        int value;

        public Appointment(int days, int value) {
            this.days = days;
            this.value = value;
        }

        public int getDays() {
            return days;
        }

        public int getValue() {
            return value;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());

        int[] day = new int[input + 1];
        int[] value = new int[input + 1];
        int[] result = new int[input + 1];

        for(int i = 0; i<input; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            day[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < input; i++) {
            if( i + day[i] <= input ){
                result[i + day[i]] = Math.max(result[i+day[i]], result[i] + value[i]);
                // i + day[i] - 현재 상담 했을때 상담이 종료되는 날짜
                // result[i+day[i]] - 상담이 진행된 경우
                // result[i] + value[i] -
            }

            result[i +1] = Math.max(result[i +1], result[i]);
        }

        bw.write(Integer.toString(result[input]));

        bw.flush();
        br.close();
        bw.close();


    }

    private static void printResult(int[] result, String str) {
        System.out.println(str +" =======");
        for (int i1 : result) {
            System.out.print(" " + i1);
        }
        System.out.println();
        System.out.println(str+" ======= end");
    }

    static void getMaxValue(int maxDays, Appointment[] appointments){

        int numAppointment = appointments.length;
        int[][] cache = new int[numAppointment][maxDays];

        for(int i = 1; i <= maxDays;){ // Grid의 첫 행 채우기

            if(appointments[0].getDays() > maxDays - (i - 1)){
                i++;
                continue;
            }

            cache[0][i - 1] = appointments[0].getValue();
            break;
        }

        for (int[] ints : cache) {
            for (int anInt : ints) {
                System.out.print("  " + anInt);
            }
            System.out.println();
        }

    }

}

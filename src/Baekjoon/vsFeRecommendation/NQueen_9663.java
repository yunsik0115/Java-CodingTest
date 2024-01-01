package Baekjoon.vsFeRecommendation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class NQueen_9663 {

	public static int[] arr;
	public static int N;
	public static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());

		arr = new int[N]; // 각 원소의 index : 열, 원소값이 행에 해당
		nQueen(0);

		bw.write(Integer.toString(count));
		bw.flush();
		br.close();
		bw.close();
	}

	public static void nQueen(int depth) {

		if(depth == N){
			count++;
			return;
		}

		for(int i = 0; i < N; i++){
			arr[depth] = i;
			if(checkValidity(depth)){
				nQueen(depth + 1);
			}
		}

	}

	public static boolean checkValidity(int col){
		for(int i = 0; i < col; i++){
			if(arr[col] == arr[i]){
				// arr[col] - 해당 열의 행
				// arr[i] - 이전에 배치했던 것들 중 겹치는게 생기는 경우
				return false; // 1. 같은 행에 존재한다
			}

			else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])){
				return false; // 2. X의 증가량과 Y의 증가량이 같다 (기울기가 1, -1이다)
			}
		}
		return true;
	}

}

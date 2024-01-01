package Baekjoon.vsFeRecommendation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class MineCraft_18111 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 세로 N
		int m = Integer.parseInt(st.nextToken()); // 가로 M
		int b = Integer.parseInt(st.nextToken()); // 인벤 초기조건

		int[][] arr = new int[n][m];

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int time = Integer.MAX_VALUE;

		for(int i = 0; i < n; i++){
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(arr[i][j], max);
				min = Math.min(arr[i][j], min);
			}
		}
		int height = 0;

		for(int inspection = max; inspection >= min; inspection--){

			int t = 0;
			int itemNo = b;

			for(int i = 0; i < n; i++){
				for(int j = 0; j < m; j++){
					if(arr[i][j] > inspection){
						itemNo += (arr[i][j] - inspection);
						t += 2 * (arr[i][j] - inspection);
					}
					else if(arr[i][j] < inspection){
						itemNo -= (inspection - arr[i][j]);
						t += (inspection - arr[i][j]);
					}
				}
			}

			if(itemNo >= 0 && time > t){
				height = inspection;
				time = t;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(Integer.toString(time));
		sb.append(" ");
		sb.append(Integer.toString(height));

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();

	}
}

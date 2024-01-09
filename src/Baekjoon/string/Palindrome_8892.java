package Baekjoon.string;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Palindrome_8892 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String target = br.readLine();

		int palindrome = palindrome(target);

		bw.write(Integer.toString(palindrome));
		bw.flush();
		bw.close();
		br.close();

	}

	public static int palindrome(String target){
		int start = 0;
		int end = target.length() - 1;

		while(start < end){
			if(Character.isDigit(target.charAt(start))){
				start++;
			}
			if(Character.isDigit(target.charAt(end))){
				end--;
			}

			if(target.charAt(start) == target.charAt(end)){
				start++;
				end--;
			} else{
				return 0;
			}
		}
		return 1;
	}
}

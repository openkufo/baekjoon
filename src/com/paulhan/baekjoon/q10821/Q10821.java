package com.paulhan.baekjoon.q10821;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q10821 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		char[] S = br.readLine().toCharArray();
		int commaCount = 0;
		int SCount = 0;
		
		for(int i = 0; i < S.length; i++) {
			char temp = S[i];
			boolean isInteger = temp >= 49 && temp <= 57 && commaCount == 0;
			if(isInteger) {
				SCount++;
				commaCount++;
			}
			
			if(temp == ',') {
				commaCount = 0;
			}
		}
		
		bw.write(SCount + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}

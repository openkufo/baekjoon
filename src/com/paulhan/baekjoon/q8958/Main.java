package com.paulhan.baekjoon.q8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		
		int[] resultArray = new int[testCaseCount];
		int resultIndex = 0;
		
		while(testCaseCount-- > 0) {
			String testCase = br.readLine();
			
			List<Integer> countList = new ArrayList<Integer>(Arrays.asList(0));
			int countListIndex = 0;
			
			for(int i=0; i<testCase.length(); i++) {
				if(testCase.charAt(i) == 'X') {
					if(i+1 < testCase.length() && testCase.charAt(i+1) == 'O') {
						countList.add(0);
						countListIndex++;
					}
					continue;
				}
				countList.set(countListIndex, countList.get(countListIndex)+1);
			}
			
			resultArray[resultIndex++] = sumOfResult(countList);
		}
		
		for(int i = 0; i < resultArray.length; i++) {
			System.out.println(resultArray[i]);
		}
	}
	
	private static int sumOfResult(List<Integer> countList) {
		int result = 0;
		for(Integer count : countList) {
			result += (1 + count) * count/2;
		}
		
		return result;
	}
}

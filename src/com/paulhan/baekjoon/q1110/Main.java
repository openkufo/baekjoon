package com.paulhan.baekjoon.q1110;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String result = "";
		int count = 0;
		
		Scanner sc = new Scanner(System.in);
		if(!sc.hasNextInt()) {
			System.out.println("숫자가 아닙니다!");
			return;
		}
	
		int num = sc.nextInt();
		boolean allowToNextStep = num >= 0 && num <= 99;
		if(!allowToNextStep) {
			System.out.println("0이상 100미만의 숫자를 입력하세요");
			return;
		}
		
		if(num < 10) {
			result = "0" + num;
		} else {
			result = Integer.toString(num);
		}
		
		boolean isSame = false;
		while(!isSame) {
			int temp = 0;
			for(int i = 0 ; i < result.length(); i++) {
				temp += Integer.parseInt(result.substring(i, i+1));
			}
			
			int lastIndex = result.length()-1;
			result = result.substring(lastIndex);
			
			lastIndex = Integer.toString(temp).length()-1;
			result += Integer.toString(temp).substring(lastIndex);
			
			isSame = num == Integer.parseInt(result);
			count++;
		}
		
		System.out.println(count);
	}

}

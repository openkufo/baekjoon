package com.paulhan.baekjoon.q2941;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	private static final Set<String> CROATIA_ALPHABET = Collections.unmodifiableSet(new HashSet<String>(Arrays.asList("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")));
	public static void main(String[] args) {
		int alphabetCount = 0;
		
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		while(!input.isEmpty()) {
			int index = 0;
			if(index+3 <= input.length()) {
				String temp = input.substring(index, index+3);
				if(CROATIA_ALPHABET.contains(temp)) {
					input = input.replaceFirst(temp, "");
					alphabetCount++;
					continue;
				}
			}
			
			if(index+2 <= input.length()) {
				String temp = input.substring(index, index+2);
				if(CROATIA_ALPHABET.contains(temp)) {
					input = input.replaceFirst(temp, "");
					alphabetCount++;
					continue;
				}
			}
			
			String temp = input.substring(index,index+1);
			input = input.replaceFirst(temp, "");
			alphabetCount++;
		}
		
		System.out.println(alphabetCount);
	}
}

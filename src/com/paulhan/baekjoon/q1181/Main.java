package com.paulhan.baekjoon.q1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] wordArray = new String[n];
        for(int i = 0; i < n; i++){
            wordArray[i] = br.readLine();
        }

        Arrays.sort(wordArray, (o1, o2) -> {
            if(o1.length() > o2.length()){
                return 1;
            } else if(o1.length() < o2.length()){
                return -1;
            }

            return o1.compareTo(o2);
        });
        
        String[] resultArray = Arrays.stream(wordArray).distinct().toArray(String[]::new);
        for(String result : resultArray){
            System.out.println(result);
        }
    }
}

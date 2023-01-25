package com.paulhan.baekjoon.q1654;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        
        //실험할 코드 추가
                
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] cables = new long[k];
        for(int i = 0; i < cables.length; i++){
            cables[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(cables);

        long start = 1;
        long mid = 0;
        long end = cables[cables.length-1];
        long sum = 0;
        long max = 0;
        
        while (start <= end) {
            sum = 0;
            mid = (start + end) / 2;
            for(int i = 0; i < cables.length; i++){
                sum += cables[i] / mid;
            }

            if(sum >= n){
                start = mid + 1;
                System.out.println("mid : " + mid);
                if(max < mid){
                    max = mid;
                }
            } else {
                end = mid-1;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n");
        bw.write(sb.toString());

        System.out.println("test");
        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        long secDiffTime = (afterTime - beforeTime)/1000; //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);
        bw.flush();
        bw.close();
        br.close();
    }
}

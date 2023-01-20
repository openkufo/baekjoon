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
            mid = (start + end) / 2;
            sum = 0;
            for(int i = 0; i < cables.length; i++){
                sum += cables[i] / mid;
            }

            if(sum >= n){
                start = mid + 1;
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

        bw.flush();
        bw.close();
        br.close();
    }
}

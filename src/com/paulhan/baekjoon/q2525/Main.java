package com.paulhan.baekjoon.q2525;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(br.readLine());

        int[] time = addMinute(new int[]{a, b}, c);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < time.length; i++){
            sb.append(time[i]).append(" ");
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
    
    private static int[] addMinute(int[] time, int add){
        int minute = time[1] + add;

        time[0] += minute / 60;
        time[1] = minute % 60;

        time[0] %= 24;
        
        return time;
    }
}

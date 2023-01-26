package com.paulhan.baekjoon.q15903;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());

        Queue<Long> cardQueue = new PriorityQueue<Long>();
        for(int i = 0; i < n; i++){
            cardQueue.add(Long.parseLong(st.nextToken()));
        }
        
        for(int i = 0; i < m; i++){
            long sum = cardQueue.poll() + cardQueue.poll();
            cardQueue.add(sum);
            cardQueue.add(sum);
        }

        Iterator<Long> cardIterator = cardQueue.iterator();
        long result = 0;
        while(cardIterator.hasNext()){
            result += cardIterator.next();
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(result).append("\n");
        bw.write(sb.toString());
        bw.flush();
        
        bw.close();
        br.close();
    }
}

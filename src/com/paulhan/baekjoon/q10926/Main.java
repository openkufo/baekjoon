package com.paulhan.baekjoon.q10926;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    private static final String SURPRISE_WORD = "??!";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        sb.append(br.readLine()).append(SURPRISE_WORD);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}

package com.paulhan.baekjoon.q11720;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String numStr = br.readLine();
        int result = 0;
        for(char number: numStr.toCharArray()){
            result += number - '0';
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}

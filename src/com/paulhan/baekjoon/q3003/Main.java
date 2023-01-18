package com.paulhan.baekjoon.q3003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static final String NEED_PIECE = "1 1 2 2 2 8";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer needPieceToken = new StringTokenizer(NEED_PIECE);
        StringTokenizer inputPieceToken = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(inputPieceToken.hasMoreElements()){
            int needPiece = Integer.parseInt(needPieceToken.nextToken());
            int inputPiece = Integer.parseInt(inputPieceToken.nextToken());

            sb.append(needPiece - inputPiece).append(" ");
        }

        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
        br.close();
    }
}

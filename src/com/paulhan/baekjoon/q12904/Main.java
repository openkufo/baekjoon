package com.paulhan.baekjoon.q12904;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q12904 {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder s = new StringBuilder(bufferedReader.readLine());
        StringBuilder t = new StringBuilder(bufferedReader.readLine());

        for(int tLength = t.length()-1; tLength > s.length()-1; tLength--){
            char target = t.charAt(tLength);
            
            if(target == 'A') {
                t.deleteCharAt(tLength);
            } else if(target == 'B'){
                t.deleteCharAt(tLength);
                t.reverse();
            }
        }
        
        boolean isEquals = t.toString().equals(s.toString());
        int result = isEquals ? 1 : 0;
        
        bufferedWriter.write(result + "\n");
        bufferedWriter.flush();

        bufferedWriter.close();
        bufferedReader.close();
    }
}

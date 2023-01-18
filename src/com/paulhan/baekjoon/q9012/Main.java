package com.paulhan.baekjoon.q9012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine());
        
        for(int i = 0; i < T; i++){
            char[] str = bufferedReader.readLine().toCharArray();
            
            if(isVps(str)){
                bufferedWriter.write("YES\n");
            } else {
                bufferedWriter.write("NO\n");
            }

            bufferedWriter.flush();
        }
        bufferedWriter.close();
        bufferedReader.close();
    }

    // Valid Parenthesis String
    private static boolean isVps(char[] str){
        Stack<String> parenthesisStack = new Stack<String>();
        for(char parenthesis : str){
            if(parenthesisStack.size() == 0 && parenthesis == ')'){
                return false;
            }
            if(parenthesis == '('){
                parenthesisStack.push(Character.toString(parenthesis));
            } else if(parenthesis == ')'){
                parenthesisStack.pop();
            }
        }
        
        return parenthesisStack.isEmpty();
    }
}

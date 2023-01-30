package com.paulhan.baekjoon.q10828;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private int[] stackArray;
    private final int ERROR_CODE = -1;
    public static void main(String[] args) throws NumberFormatException, IOException {
        Main stack = new Main();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            String command = br.readLine();
            switch (command) {
                case "pop":
                    sb.append(stack.pop()).append("\n");
                    break;
                case "size":
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":
                    sb.append(stack.empty()).append("\n");
                    break;
                case "top":
                    sb.append(stack.top()).append("\n");
                    break;
                default:
                    command = command.split(" ")[1];
                    stack.push(Integer.parseInt(command));
                    break;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private void push(int x){
        if(stackArray == null){
            
            stackArray = new int[1];
            stackArray[0] = x;
            return;
        }

        int[] temp = new int[stackArray.length + 1];
        for(int i = 0; i < stackArray.length; i ++){
            temp[i] = stackArray[i];
        }

        temp[stackArray.length] = x;
        stackArray = temp;
    }

    private int pop(){
        if(stackArray == null){
            return ERROR_CODE;
        }

        if(stackArray.length == 1){
            int stack = stackArray[0];
            stackArray = null;
            return stack;
        }

        int[] temp = stackArray;
        stackArray = new int[temp.length-1];

        for(int i = 0; i < stackArray.length; i++){
            stackArray[i] = temp[i];
        }
        
        return temp[temp.length-1];
    }

    private int size(){
        return stackArray == null ? 0 : stackArray.length;
    }
    
    private int empty(){
        return stackArray == null ? 1 : 0;
    }

    private int top(){
        return stackArray == null ? -1 : stackArray[stackArray.length-1];
    }
}

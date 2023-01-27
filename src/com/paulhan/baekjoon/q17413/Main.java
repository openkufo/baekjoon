package com.paulhan.baekjoon.q17413;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Stack<String> stringStack = new Stack<String>();
        StringBuilder sb = new StringBuilder();

        char[] stringArray = s.toCharArray();
        for(int i = 0; i < stringArray.length; i++){
            sb.append(stringArray[i]);

            if(i + 1 == stringArray.length){
                stringStack.push(sb.toString());
                break;
            }

            if(stringArray[i+1] == '<' || stringArray[i] == '>'){
                stringStack.push(sb.toString());
                sb.setLength(0);
            }
        }
        
        StringBuilder reverseBuilder = new StringBuilder();
        
        Iterator<String> stringStackIterator = stringStack.iterator();
        while (stringStackIterator.hasNext()) {
            String str = stringStackIterator.next();
            if(str.charAt(0) != '<'){
                StringTokenizer st = new StringTokenizer(str, " ", true);
                
                while(st.hasMoreTokens()){
                    String strToken = st.nextToken();
                    String temp = strToken.equals(" ") ? " " : new StringBuilder(strToken).reverse().toString();
                    reverseBuilder.append(temp);
                }
                
            } else {
                reverseBuilder.append(str);
            }
        }
        
        bw.write(reverseBuilder.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}

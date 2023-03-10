package com.paulhan.baekjoon.q1036;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private final static int BASE36_CODE_CHAR = 55;
    private final static int BASE36_CODE_A = 65;
    private final static int BASE36_CODE_DIGIT = 48;
    private final static int BASE36 = 36;

    static Map<Integer, List<String>> bufferLengthMap = new HashMap<Integer, List<String>>();
    static StringBuilder bufferTemp = new StringBuilder();
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        // String[] bufferStrings = {"GOOD", "LUCK", "AND", "HAVE", "FUN"};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder bufferBuilder = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++){
            String buffer = br.readLine();
            bufferTemp.append(buffer).append(" ");
            saveList(buffer);
        }

        int k = Integer.parseInt(br.readLine());
        while(k > 0){
            if(bufferLengthMap.isEmpty()){
                break;
            }

            List<Integer> keyList = new ArrayList<Integer>(bufferLengthMap.keySet());
            if(keyList.isEmpty()){
                continue;
            }
            keyList.sort((Integer o1, Integer o2) -> o2.compareTo(o1));

            int key = keyList.get(0);
            List<String> bufferList = bufferLengthMap.get(key);

            bufferList.sort((String o1, String o2) -> o1.compareTo(o2));
            for(int i = 0; i < bufferList.size(); i++){
                String buffer = bufferList.get(i);
                if(buffer.equals("")){
                    break;
                }

                char firstChar = buffer.charAt(0);
                
                buffer = buffer.substring(1);
                
                saveList(buffer);

                boolean hasFirstCharacter = bufferBuilder.indexOf(Character.toString(firstChar)) >= 0;
                if(firstChar == 'Z' || hasFirstCharacter){
                    continue;
                }

                bufferBuilder.append(firstChar).append(" ");
                bufferTemp = new StringBuilder(bufferTemp.toString().replaceAll(Character.toString(firstChar), "Z"));
                k--;

                if(k == 0){
                    break;
                }
            }
            bufferLengthMap.remove(key);
        }

        BigDecimal base36Code = BigDecimal.ZERO;
        StringTokenizer bufferTokenizer = new StringTokenizer(bufferTemp.toString());
        
        while(bufferTokenizer.hasMoreElements()){
            base36Code = base36Code.add(decodeBase36(bufferTokenizer.nextToken()));
        }
        
        System.out.println("testcase : " + encodeBase36(BigDecimal.valueOf(16)));
        System.out.println("test : " +base36Code.toString());
        System.out.println("bufferBuilder : " + bufferBuilder.toString());
        System.out.println("bufferTemp : " + bufferTemp.toString());

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(encodeBase36(base36Code) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    private static void saveList(String buffer){
        if(bufferLengthMap.containsKey(buffer.length())){
            bufferLengthMap.get(buffer.length()).add(buffer);
        } else {
            bufferLengthMap.put(buffer.length(), new ArrayList<String>(Arrays.asList(buffer)));
        }
    }

    private static BigDecimal decodeBase36(String base36){
        int position = 0;
        BigDecimal decimal = BigDecimal.ZERO;
        for(int index = base36.length(); index > 0; index--){
            long base36ByIndex = base36.charAt(index-1);
            base36ByIndex = base36ByIndex >= BASE36_CODE_A ? base36ByIndex - BASE36_CODE_CHAR : base36ByIndex - BASE36_CODE_DIGIT;
            decimal = decimal.add(BigDecimal.valueOf(base36ByIndex).multiply(BigDecimal.valueOf(BASE36).pow(position++)));
        }
        return decimal;
    }

    // private long decodeBase36(String base36){
    //     int position = 0;
    //     long decimal = 0;
    //     for(int index = base36.length(); index > 0; index--){
    //         long base36ByIndex = base36.charAt(index-1);
    //         base36ByIndex = base36ByIndex >= BASE36_CODE_A ? base36ByIndex - BASE36_CODE_CHAR : base36ByIndex - BASE36_CODE_DIGIT;
    //         decimal += base36ByIndex * Math.pow(BASE36, position++);
    //     }
    //     return decimal;
    // }

    // BigDecimal??? ????????? ???
    private static String encodeBase36(BigDecimal decimal){
        StringBuilder sb = new StringBuilder();
        if(decimal.compareTo(BigDecimal.ZERO) == 0){
            sb.append((char) BASE36_CODE_DIGIT);
            return sb.toString();
        }

        for(BigDecimal quotient = decimal; quotient.compareTo(BigDecimal.ZERO) > 0; quotient = quotient.divide(BigDecimal.valueOf(BASE36),0, RoundingMode.FLOOR)){
            long remainder = quotient.remainder(BigDecimal.valueOf(BASE36)).longValue();
            remainder = remainder >= 10 ? remainder + BASE36_CODE_CHAR : remainder + BASE36_CODE_DIGIT;
            sb.append((char)remainder);
        }
        
        return sb.reverse().toString();
    }
    // private static String encodeBase36(long decimal){
    //     StringBuilder sb = new StringBuilder();
    //     for(long quotient = decimal; quotient > 0; quotient/=BASE36){
    //         long remainder = quotient % BASE36;
    //         remainder = remainder >= 10 ? remainder + BASE36_CODE_CHAR : remainder + BASE36_CODE_DIGIT;
    //         sb.append((char)remainder);
    //     }
    //     return sb.reverse().toString();
    // }
}

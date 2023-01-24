package com.paulhan.baekjoon.q1036;

public class Main {

    private final int BASE36_CODE_CHAR = 55;
    private final int BASE36_CODE_A = 65;
    private final int BASE36_CODE_DIGIT = 48;
    private final int BASE36 = 36;
    public static void main(String[] args) {
        String[] bufferStrings = {"GOOD", "LUCK", "AND", "HAVE", "FUN"};
        int k = 7;
        long TO = new Main().decodeBase36("ZZZD");
        long BE = new Main().decodeBase36("ZZCK");
        long OR = new Main().decodeBase36("ZND");
        long NOT = new Main().decodeBase36("ZZVE");
        long TO2 = new Main().decodeBase36("ZZN");
        // long BE2 = new Main().decodeBase36("BE");

        System.out.println(TO + BE + OR + NOT + TO2);
        System.out.println("test : " + new Main().decodeBase36("31YUB"));
        System.out.println("test3 : " + new Main().encodeBase36(5130659));

        while(k > 0){
            int maxIndex = 0;
            int minIndex = 0;
            for(int i = 0; i < bufferStrings.length; i++){
                
            }
            k--;
        }
    }

    private long decodeBase36(String base36){
        int position = 0;
        long decimal = 0;
        for(int index = base36.length(); index > 0; index--){
            long base36ByIndex = base36.charAt(index-1);
            base36ByIndex = base36ByIndex >= BASE36_CODE_A ? base36ByIndex - BASE36_CODE_CHAR : base36ByIndex - BASE36_CODE_DIGIT;
            decimal += base36ByIndex * Math.pow(BASE36, position++);
        }
        return decimal;
    }

    private String encodeBase36(long decimal){
        StringBuilder sb = new StringBuilder();
        for(long quotient = decimal; quotient > 0; quotient/=BASE36){
            long remainder = quotient % BASE36;
            remainder = remainder >= 10 ? remainder + BASE36_CODE_CHAR : remainder + BASE36_CODE_DIGIT;
            sb.append((char)remainder);
        }
        return sb.reverse().toString();
    }

}

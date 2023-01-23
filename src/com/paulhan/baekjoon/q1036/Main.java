package com.paulhan.baekjoon.q1036;

public class Main {

    private final int BASE36_CODE = 55;
    private final int BASE36 = 36;
    public static void main(String[] args) {
        long TO = new Main().decodeBase36("TO");
        long BE = new Main().decodeBase36("BE");
        long OR = new Main().decodeBase36("OR");
        long NOT = new Main().decodeBase36("NOT");
        long TO2 = new Main().decodeBase36("TO");
        long BE2 = new Main().decodeBase36("BE");
        
        System.out.println(TO + BE + OR + NOT + TO2 + BE2);
        System.out.println((char) (55 + 26));
        System.out.println((char) (55 + 23));
        System.out.println((char) (55 + 24));
        System.out.println(new Main().encodeBase36(34548));
    }

    private long decodeBase36(String base36){
        int position = 0;
        long decimal = 0;
        for(int index = base36.length(); index > 0; index--){
            decimal += ((long) base36.charAt(index-1) - BASE36_CODE) * Math.pow(BASE36, position++);
        }
        return decimal;
    }

    private String encodeBase36(long decimal){
        StringBuilder sb = new StringBuilder();
        for(long quotient = decimal; quotient > 0; quotient/=BASE36){
            long remainder = quotient % BASE36;
            sb.append((char)(remainder + BASE36_CODE));
        }
        return sb.reverse().toString();
    }

}

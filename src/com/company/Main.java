package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static Boolean isLuckyTicket(String number){
        Integer sum1 = 0, sum2 = 0;
        for (int i = 0; i < number.length(); i++) {
            if (i<3){
                sum1 += Integer.valueOf(number.substring(i,i+1));
            }else{
                sum2 += Integer.valueOf(number.substring(i,i+1));
            }
        }
        return sum1 == sum2;
    }

    public static Boolean isLuckyTicket2(String str){
        List<Integer> list = new ArrayList<>();
        String[] strSplit = str.split("");
        //array = (List<Integer>) Arrays.stream(str).mapToInt(el -> Integer.valueOf(el)).collect(Collectors.toList());
        for (int i = 0; i < strSplit.length; i++) {
           list.add(Integer.valueOf(strSplit[i]));
        }
        int sum1 = list.get(0) + list.get(1) + list.get(2);
        int sum2 = list.get(3) + list.get(4) + list.get(5);
        return sum1 == sum2;
    }

    //1->000 001
    //10->000 010

    public static String convertToSixNumber(int number){
        String prefix = "";
        String numberAsString = String.valueOf(number);
        switch (numberAsString.length()){
            case 1: prefix = "00000"; break;
            case 2: prefix = "0000"; break;
            case 3: prefix = "000"; break;
            case 4: prefix = "00"; break;
            case 5: prefix = "0"; break;
        }
        return prefix + numberAsString;
    }

    public static void main(String[] args) {
	    String number = "123456";
	    //1+2+3 = 4+5+6
        int counter = 0;
//      System.out.println(isLuckyTicket("123456"));
        System.out.println(isLuckyTicket2("123006"));
        for (int i = 0; i < 1000000; i++) {
            String numberAsString = convertToSixNumber(i);
            if (isLuckyTicket2(numberAsString)){
//                System.out.println(numberAsString);
                counter++;
            }
        }
        System.out.println(counter);
    }
}

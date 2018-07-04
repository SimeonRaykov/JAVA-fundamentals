package com.company;
import java.util.Arrays;
import java.util.Scanner;

public class ModifyBits {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            int[] array = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();

            int numberToConvert = array[0];

            int position = array[1];
            String fix = String.valueOf(array[2]);
            char fixed = fix.charAt(0);

            String convertedNumber = Integer.toString(numberToConvert, 2);
            convertedNumber = String.format("%0" + (16 - convertedNumber.length()) + "d%s", 0, convertedNumber);

            convertedNumber = reverse(convertedNumber);

            StringBuilder sb = new StringBuilder();
            sb.append(convertedNumber);
            sb.setCharAt(position, fixed);
            sb.reverse();

            int result = 0;

            while (!isParsable(sb.toString())) {

sb.replace(0,1,"");
            }

            boolean isZero=false;



            StringBuilder finalResult = new StringBuilder();
            finalResult.append(sb.toString().replaceFirst("^0+(?!$)", ""));

            if(finalResult.toString().equals("")){
                finalResult.append("0");
                isZero=true;
            }

            int finalResultToInt = Integer.parseInt(finalResult.toString(), 2);

            System.out.println(finalResultToInt);


        }
        catch (Exception e){

        }
    }

    private static String reverse(String input){
        char[] in = input.toCharArray();
        int begin=0;
        int end=in.length-1;
        char temp;
        while(end>begin){
            temp = in[begin];
            in[begin]=in[end];
            in[end] = temp;
            end--;
            begin++;
        }
        return new String(in);
    }
    public static String removeFirstChar(String s){
        return s.substring(1);
    }
    private static boolean isParsable(String input){
        boolean parsable = true;
        try{
            Integer.parseInt(input,2);
        }catch(Exception e){
            parsable = false;
        }
        return parsable;
    }
}


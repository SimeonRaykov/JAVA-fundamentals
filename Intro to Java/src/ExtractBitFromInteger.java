import java.util.Scanner;

public class ExtractBitFromInteger {
    public static void main(String[] args) {

        Scanner Scanner=new Scanner(System.in);

        int firstNumber=Scanner.nextInt();
       String binaryNumber= Integer.toBinaryString(firstNumber);
binaryNumber=("0000000000000000" + binaryNumber).substring(binaryNumber.length());

        int position=Scanner.nextInt();
        binaryNumber=reverse(binaryNumber);

        char result=binaryNumber.charAt(position);

        System.out.println(result);

    }
    public static String reverse(String input){
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
}

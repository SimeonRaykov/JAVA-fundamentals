import java.util.Arrays;
import java.util.Scanner;

public class BalancedParenthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isFalse = false;
        String[] parenthesis = sc.nextLine().split("");
        String []arr=new String[100];
        String helper=" ";

        for (int i = 0; i <100 ; i++) {
            arr[i]=helper;
            helper+=" ";
        }

        if (parenthesis.length % 2 != 0) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < parenthesis.length; i++) {

            String current = parenthesis[i];
            String last = parenthesis[parenthesis.length - i - 1];
            if (current.equals("(")) {
                if (last.equals(")")) {

                } else {
                    isFalse = true;
                    break;
                }
            } else if (current.equals("{")) {
                if (last.equals("}")) {

                } else {
                    isFalse = true;
                    break;
                }
            } else if (current.equals("[")) {
                if (last.equals("]")) {

                } else {
                    isFalse = true;
                    break;
                }
            }
           else if (Arrays.asList(arr).contains(current) && Arrays.asList(arr).contains(last)){
               if(!last.equals(current)){
                   isFalse=true;
                   break;
               }
            }
        }
        if (isFalse) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

    }
}

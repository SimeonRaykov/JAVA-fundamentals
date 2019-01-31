import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numsArr = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(sc.nextLine());
        UnaryOperator<int[]> reverseArray = x -> {
            for (int i = 0; i < x.length / 2; i++) {
                int temp = x[x.length - i - 1];
                x[x.length - i - 1] = x[i];
                x[i] = temp;
            }
            return x;
        };

        BiFunction<int[],Integer,int[]> removeNumbersDivisibleByN = (x,y) -> {
            for (int i = 0; i < x.length; i++) {
               if(x[i]%y == 0){
                   x[i] = 0;
               }
            }
            return x;
        };

        reverseArray.apply(numsArr);
        removeNumbersDivisibleByN.apply(numsArr,n);
        for (int i : numsArr) {
            if(i!=0){
                System.out.print(i+" ");
            }
        }


    }
}

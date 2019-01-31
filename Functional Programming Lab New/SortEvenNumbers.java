import java.util.Scanner;
import java.util.Arrays;

public class SortEvenNumbers {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int[]nums = Arrays.stream(sc.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        nums = Arrays.stream(nums).filter(x->x%2==0).toArray();
        printArray(nums);
        System.out.println();
        Arrays.sort(nums);
       printArray(nums);

    }
    public static void printArray(int[] array){
        for (int i = 0; i <array.length ; i++) {
            if(i == array.length-1){
                System.out.print(array[i]+" ");
            }
            else{
                System.out.print(array[i]+", ");
            }
        }
    }
}

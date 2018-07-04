import java.util.Scanner;

public class ReadInput {

    public static void main(String[] args) {
	Scanner Scanner=new Scanner(System.in);

	String words=Scanner.next("\\w+");
        String words2=Scanner.next("\\w+");
	int firstInt=Scanner.nextInt();
	int secondInt=Scanner.nextInt();
	int thirdInt=Scanner.nextInt();

	int[]array={firstInt,secondInt,thirdInt};
	Scanner.nextLine();
        String words3=Scanner.next("\\w+");


int sum=0;

        for (int i = 0; i <3 ; i++) {

            sum+=array[i];

        }

        System.out.println(words+" "+words2+" "+words3+" "+sum);


    }
}

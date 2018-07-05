import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner Scanner=new Scanner(System.in);

        String[] inputString=Scanner.nextLine().split(", ");
        List<Integer>numbersList=new ArrayList<>();

        for(int i=0;i<inputString.length;i++){
            int currentNumber=Integer.parseInt(inputString[i]);
            if(currentNumber%2==0){
                numbersList.add(0,currentNumber);
            }

        }
        Collections.reverse(numbersList);

        StringBuilder sb=new StringBuilder();

        for (int i = 0; i <numbersList.size() ; i++) {

           sb.append(numbersList.get(i).toString()).append(", ");

        }
        sb.setLength(sb.length() - 2);
        System.out.println(sb.toString());

        Collections.sort(numbersList);
        sb.setLength(0);
        for (int i = 0; i <numbersList.size() ; i++) {
            sb.append(numbersList.get(i).toString()).append(", ");
        }
        sb.setLength(sb.length()-2);
        System.out.println(sb.toString());

    }
}

import java.util.*;

public class CountSameValuesInArray {
    public static void main(String[] args) {

        Scanner Scanner=new Scanner(System.in);

        String[] input=Scanner.nextLine().split(" ");
        HashMap<String,Integer>numbersCount=new HashMap<>();

        for (int i = 0; i <input.length ; i++) {
            String currentNumberStr=input[i];

            if(!numbersCount.containsKey(currentNumberStr)){

                numbersCount.put(currentNumberStr,1);

            }
            else if(numbersCount.containsKey(currentNumberStr)){

                numbersCount.put(currentNumberStr,numbersCount.get(currentNumberStr)+1);

            }



        }



        for(Map.Entry<String, Integer> entry : numbersCount.entrySet()) {
            String number = entry.getKey();
            Integer count = entry.getValue();

            System.out.printf("%s - %d times%n",number,count);

        }




    }


}

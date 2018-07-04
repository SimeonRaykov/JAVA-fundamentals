import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GetFirstOddOrEvenElements {
    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);

        List<Integer> listInput = new ArrayList<>();
        while (Scanner.hasNextInt()) {
            listInput.add(Scanner.nextInt());
        }
        List<Integer> listInputCopy = new ArrayList<>(listInput);
        List<Integer> intList = new ArrayList<>();

        List<String> listCommands = new ArrayList<>();
        while (Scanner.hasNext()) {
            listCommands.add(Scanner.next());
            if (listCommands.size() == 3) {
                break;
            }
        }
        String X = listCommands.get(1);
        int numbersToGet = Integer.parseInt(X);

        List<Integer> resultCollection = new ArrayList<>();

        int counter = 0;


        if (listCommands.contains("odd")) {
            while (true) {

                for (int i = 0; i < listInput.size(); i++) {

                    int currentNumber = listInput.get(i);

                    if (currentNumber % 2 != 0) {

                        listInputCopy.remove(0);
                        numbersToGet -= 1;
                        resultCollection.add(currentNumber);
                    }

                    if (numbersToGet == 0 || listInputCopy.size() == 0) {
                        break;
                    }
                    counter += 1;
                    if (counter == listInput.size()) {
                        break;
                    }


                }
                if (numbersToGet == 0 || listInputCopy.size() == 0 || counter == listInput.size()) {
                    break;
                }


            }


        } else {

            while (true) {


                for (int i = 0; i < listInput.size(); i++) {

                    int currentNumber = listInput.get(i);

                    if (currentNumber % 2 == 0) {

                        listInputCopy.remove(0);
                        numbersToGet -= 1;
                        resultCollection.add(currentNumber);
                    }

                    if (numbersToGet == 0 || listInputCopy.size() == 0) {
                        break;
                    }

                    counter += 1;
                    if(counter==listInput.size()){
                        break;
                    }
                }
                if (numbersToGet == 0 || listInputCopy.size() == 0 || counter == listInput.size()) {
                    break;
                }


            }
        }
        List<String> stringResult = resultCollection.stream().map(Object::toString)
                .collect(Collectors.toList());

        String result = String.join(" ", stringResult);

        System.out.println(result);


    }


}

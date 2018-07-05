import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        int n = Integer.parseInt(Scanner.nextLine());

        Map<String, Integer> personsMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {

            String[] input = Scanner.nextLine().split(", ");

            String name = input[0];
            int age = Integer.parseInt(input[1]);

            if(!personsMap.containsKey(name)){
                personsMap.put(name, age);
            }

        }

        String condition = Scanner.nextLine();
        int age = Integer.parseInt(Scanner.nextLine());

        String formatSort = Scanner.nextLine();

        for (Map.Entry<String, Integer> entry : personsMap.entrySet()) {

            String personsName = entry.getKey();
            Integer personsAge = entry.getValue();

            if (condition.equals("younger")) {

                if (personsAge < age) {

                    if(formatSort.equals("age")){

                        System.out.printf("%s%n",personsAge);

                    }
                    else if(formatSort.equals("name")){

                        System.out.printf("%s%n",personsName);

                    }
                    else if(formatSort.equals("name age")){

                        System.out.printf("%s - %s%n",personsName,personsAge);

                    }

                }


            } else if (condition.equals("older")) {

                if (personsAge >=age){


                    if(formatSort.equals("age")){

                        System.out.printf("%s%n",personsAge);

                    }
                    else if(formatSort.equals("name")){

                        System.out.printf("%s%n",personsName);

                    }
                    else if(formatSort.equals("name age")){

                        System.out.printf("%s - %s %n",personsName,personsAge);

                    }
                }
            }
        }
    }
}

import java.util.Scanner;

public class GameOfNames {

    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);

        int n = Integer.parseInt(Scanner.nextLine());
        String winner = "";
        long maxPoints = 0;

        for (int i = 0; i < n; i++) {
            String currentName = Scanner.nextLine();
            long startingPoints = 0;
            for (int j = 0; j < currentName.length(); j++) {

                char currentChar = currentName.charAt(j);
                long pointsOfcurrentChar = (long) currentChar;
                if (pointsOfcurrentChar % 2 == 0) {
                    startingPoints += pointsOfcurrentChar;
                } else {
                    startingPoints -= pointsOfcurrentChar;
                }

            }

            startingPoints += Long.parseLong(Scanner.nextLine());
if(maxPoints<startingPoints){
    maxPoints=startingPoints;
    winner=currentName;
}
        }

        System.out.printf("The winner is %s - %d points",winner,maxPoints);


    }
}

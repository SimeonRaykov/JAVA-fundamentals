import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {

        Scanner Scanner=new Scanner(System.in);
        Map<String,Double>gradesCollection=new TreeMap<>();


        int n=Integer.parseInt(Scanner.nextLine());

        for (int i = 0; i <n ; i++) {

            String currentName=Scanner.nextLine();
            String[] tokens=Scanner.nextLine().split(" ");
            int rotations=tokens.length;
            Double average;
            Double sum=0.0;

            for (int j = 0; j <rotations ; j++) {

                Double currentGrade=Double.parseDouble(tokens[j]);
                sum+=currentGrade;

            }
            average=sum/rotations;

            gradesCollection.put(currentName,average);

        }

        for(Map.Entry<String, Double> entry : gradesCollection.entrySet()) {
            String name = entry.getKey();
            Double gradeAverage = entry.getValue();
            DecimalFormat df = new DecimalFormat("0.######################");

            System.out.printf("%s is graduated with %s%n",name,df.format(gradeAverage));

        }

    }


}

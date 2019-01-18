import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<String> products = new ArrayDeque<>();
        String[] robotsLine = sc.nextLine().split(";");
        ArrayList<String> robots = new ArrayList<>();
        ArrayList<Integer> processingTimeArr = new ArrayList<>();
        ArrayList<Boolean> assigned = new ArrayList<>();
        ArrayList<Integer> dynamicTime = new ArrayList<>();

        for (int i = 0; i < robotsLine.length; i++) {
            String robot = robotsLine[i].split("-")[0];
            String processingTime = robotsLine[i].split("-")[1];
            robots.add(robot);
            assigned.add(false);
            dynamicTime.add(0);
            processingTimeArr.add(Integer.parseInt(processingTime));
        }
        String[] startTime = sc.nextLine().split(":");

        long hours = Long.parseLong(startTime[0]);
        long minutes = Long.parseLong(startTime[1]);
        long seconds = Long.parseLong(startTime[2]);

        String commandProduct = sc.nextLine();
        while (!commandProduct.equals("End")) {
            products.offer(commandProduct);
            commandProduct = sc.nextLine();
        }

        boolean isNotTaken = true;

        seconds += hours * 60 * 60;
        seconds += minutes * 60;


        System.out.println();
        while (!products.isEmpty()) {
            seconds += 1;
            for (int j = 0; j < robots.size(); j++) {
                String currentRobot = robots.get(j);

                if (!assigned.get(j)) {
                    assigned.set(j, true);
                    DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss");
                    System.out.println(currentRobot + " - " + products.poll()+ " " + formatHHMMSS(seconds));
                    isNotTaken = false;
                    dynamicTime.set(j, dynamicTime.get(j) + 1);
                    break;
                } else if (processingTimeArr.get(j) == dynamicTime.get(j) + 1) {
                    assigned.set(j, false);
                    dynamicTime.set(j, 0);
                    continue;
                }
                dynamicTime.set(j, dynamicTime.get(j) + 1);
                if (j == robots.size() - 1) {
                    isNotTaken = true;
                }
            }
            if (isNotTaken) {
                String product = products.poll();
                products.offer(product);
                isNotTaken = true;
            }
        }
    }

    public static String formatHHMMSS(long secondsCount) {
        DecimalFormat df = new DecimalFormat("00");
        //Calculate the seconds to display:
        long seconds = secondsCount % 60;
        secondsCount -= seconds;
        //Calculate the minutes:
        long minutesCount = secondsCount / 60;
        long minutes = minutesCount % 60;
        minutesCount -= minutes;
        //Calculate the hours:
        long hoursCount = minutesCount / 60;
        //Build the String
        return "[" + df.format(hoursCount) + ":" + df.format(minutes) + ":" + df.format(seconds) + "]";
    }
}

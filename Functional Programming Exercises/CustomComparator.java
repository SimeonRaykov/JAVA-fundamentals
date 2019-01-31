import java.util.*;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        List<Integer> oddNumbers = new ArrayList<>();
        List<Integer> evenNumbers = new ArrayList<>();

        for (int num : nums) {
            if (num % 2 == 0) {
                evenNumbers.add(num);
            } else {
                oddNumbers.add(num);
            }
        }

        Collections.sort(evenNumbers);
        Collections.sort(oddNumbers);

        for (Integer evenNumber : evenNumbers) {
            System.out.print(evenNumber+" ");
        }
        for (Integer oddNumber : oddNumbers) {
            System.out.print(oddNumber+" ");
        }

    }
}

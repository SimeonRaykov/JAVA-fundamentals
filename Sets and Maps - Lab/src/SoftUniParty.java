import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class SoftUniParty {
    public static void main(String[] args) {

        Scanner Scanner = new Scanner(System.in);

        String input = Scanner.nextLine();

        HashSet<String> vipsSet = new HashSet<>();
        HashSet<String> partySet = new HashSet<>();
        HashSet<String> noPartySet = new HashSet<>();

        while (!input.equals("PARTY")) {

            String currentGuest = input;
            char firstChar = currentGuest.charAt(0);
            if (Character.isDigit(firstChar)) {
                vipsSet.add(currentGuest);
            }
            noPartySet.add(currentGuest);

            input = Scanner.nextLine();
        }

        input = Scanner.nextLine();

        while (!input.equals("END")) {

            String currentGuest = input;
            if (vipsSet.contains(currentGuest)) {
                vipsSet.remove(currentGuest);
            }
            partySet.add(currentGuest);
            if(partySet.contains(currentGuest)){
                noPartySet.remove(currentGuest);
           }




            input = Scanner.nextLine();
        }

        System.out.println(noPartySet.size());

        Iterator iter = noPartySet.iterator();
        while (iter.hasNext()) {

            String obj = (String) iter.next();
            if (vipsSet.contains(obj)) {
                System.out.printf("%s%n", obj);
                vipsSet.remove(obj);
                noPartySet.remove(obj);
            }


        }

        Iterator iterz = noPartySet.iterator();

        while (iterz.hasNext()) {

            String obj = (String) iterz.next();
            if (!vipsSet.contains(obj)) {
                System.out.printf("%s %n", obj);
            }


        }
        System.out.println();
    }

}


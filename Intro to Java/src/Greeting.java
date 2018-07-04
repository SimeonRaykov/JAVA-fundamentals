import java.util.Scanner;

public class Greeting{
    public static void main(String[] args) {

        Scanner Scanner=new Scanner(System.in);

        String firstName=Scanner.nextLine();
        String secondName=Scanner.nextLine();

if(firstName.isEmpty()){
    firstName="*****";
}
if(secondName.isEmpty()){
    secondName="*****";
}

    System.out.println("Hello, "+firstName+" " +secondName+"!");

    }

}
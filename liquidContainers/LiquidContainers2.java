
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        Container first = new Container();
        Container second = new Container();


        while (true) {
            //System.out.print("> ");
            System.out.println("First: " + first);
            System.out.println("Second: " + second);

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            
            String[] data = input.split(" ");
            int amount = Integer.valueOf(data[1]);
            
            if (data[0].equals("add")) {
                first.add(amount);
            } else if (data[0].equals("move")) {
                int firstContent = first.contains();
                if (amount >= firstContent) {
                    first.remove(firstContent);
                    second.add(firstContent);
                } else if (amount >= 0) {
                    first.remove(amount);
                    second.add(amount);
                }
            } else if (data[0].equals("remove")) {
                second.remove(amount);
            }

        }
    }

}

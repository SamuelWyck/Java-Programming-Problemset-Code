
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();
        
        System.out.println("Input numbers, type 'end' to stop");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }
            inputs.add(input);
        }
        
        System.out.println("Print the average of the negative or the positive numbers? (n/p)");
        String input = scanner.nextLine();
        
        if (input.equals("n")) {
            double average = inputs.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(num -> num < 0)
                    .average()
                    .getAsDouble();
            System.out.println("Average of the negativev numbers: " + average);
        } else if (input.equals("p")) {
            double average = inputs.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(num -> num > -1)
                    .average()
                    .getAsDouble();
            System.out.println("Average of the positive numbers: " + average);
        }

    }
}

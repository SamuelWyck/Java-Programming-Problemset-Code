
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GradeBook grades = new GradeBook();
        
        UserInterface ui = new UserInterface(scanner, grades);
        
        ui.start();
    }
}

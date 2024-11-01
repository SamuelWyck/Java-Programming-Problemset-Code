import java.util.Scanner;

public class mainProgram {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        BirdBook manager = new BirdBook();
        
        UserInterface ui = new UserInterface(scan, manager);
        
        ui.start();

    }

}

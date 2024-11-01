import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
    private Scanner scanner;
    private BirdBook manager;
    
    public UserInterface(Scanner scanner, BirdBook manager) {
        this.scanner = scanner;
        this.manager = manager;
    }
    
    public void start() {
        this.runLoop();
    }
    
    private void runLoop() {
        
        System.out.println("Commands:");
        System.out.println("Add - adds a bird");
        System.out.println("Observation - adds an observation");
        System.out.println("All - prints all birds");
        System.out.println("One - prints one bird");
        System.out.println("Quit - ends the program");
        
        while (true) {
            System.out.println("");
            System.out.println("?");
            String command = this.scanner.nextLine();
            
            if (command.equals("Quit")) {
                break;
            }
            
            if (command.equals("Add")) {
                this.addBird();
            } else if (command.equals("Observation")) {
                this.addObservation();
            } else if (command.equals("All")) {
                this.printAll();
            } else if (command.equals("One")) {
                this.printOne();
            }
        }
    }
    
    private void addBird() {
        System.out.println("Name: ");
        String name = this.scanner.nextLine();
        
        System.out.println("Name in Latin: ");
        String latinName = this.scanner.nextLine();
        
        this.manager.addBird(name, latinName);
    }
    
    private void addObservation() {
        System.out.println("Bird? ");
        String bird = this.scanner.nextLine();
        
        int result = this.manager.addObservation(bird);
        if (result == -1) {
            System.out.println("Not a bird!");
        }
    }
    
    private void printAll() {
        ArrayList<Bird> birds = this.manager.getBirds();
        for (Bird bird : birds) {
            System.out.println(bird);
        }
    }
    
    private void printOne() {
        System.out.println("Bird?");
        String name = this.scanner.nextLine();
        
        String bird = this.manager.searchByName(name);
        System.out.println(bird);
    }
}

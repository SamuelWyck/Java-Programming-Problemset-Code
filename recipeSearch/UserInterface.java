import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private FileManager manager;
    
    public UserInterface(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public void start() {
        try {
            this.getFile();
            this.runLoop();
        } catch (FileNotFoundException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    private void runLoop() {
        System.out.println("Commands:");
        System.out.println("list - lists recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");
        
        while (true) {
            System.out.println("");
            System.out.println("Enter command: ");
            String command = this.scanner.nextLine();
            System.out.println("");
            if (command.equals("stop")) {
                break;
            }
            
            if (command.equals("list")) {
                this.listRecipes();
            } else if (command.equals("find name")) {
                this.searchByName();
            } else if (command.equals("find cooking time")) {
                this.searchByTime();
            } else if (command.equals("find ingredient")) {
                this.searchByIngredient();
            }
        }
    }
    
    private void getFile() throws FileNotFoundException {
        System.out.println("File to read: ");
        String fileName = this.scanner.nextLine();
        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        this.manager = new FileManager(reader);
    }
    
    private void listRecipes() {
        System.out.println("Recipes:");
        this.manager.printRecipes();
    }
    
    private void searchByName() {
        System.out.println("Searched word: ");
        String name = this.scanner.nextLine();
        ArrayList<String> matches = this.manager.findByName(name);
        System.out.println("");
        System.out.println("Recipes:");
        for (String string : matches) {
            System.out.println(string);
        }
    }
    
    private void searchByTime() {
        System.out.println("Max cooking time: ");
        int time = Integer.valueOf(this.scanner.nextLine());
        System.out.println("");
        ArrayList<String> matches = this.manager.findByTime(time);
        System.out.println("Recipes:");
        for (String string : matches) {
            System.out.println(string);
        }
    }
    
    private void searchByIngredient() {
        System.out.println("Ingredient: ");
        String ingredient = this.scanner.nextLine();
        System.out.println("");
        ArrayList<String> matches = this.manager.findByIngredient(ingredient);
        System.out.println("Recipes:");
        for (String string : matches) {
            System.out.println(string);
        }
    }
}

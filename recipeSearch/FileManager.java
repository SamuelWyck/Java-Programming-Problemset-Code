import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
    private Scanner reader;
    private ArrayList<ArrayList<String>> recipes;
    
    public FileManager(Scanner reader) {
        this.reader = reader;
        this.recipes = this.readFile();
    }
    
    private ArrayList<ArrayList<String>> readFile() {
        ArrayList<ArrayList<String>> recipes = new ArrayList<>();
        
        ArrayList<String> recipe = new ArrayList<>();
        while (this.reader.hasNextLine()) {
            String line = this.reader.nextLine();
            
            if (line.isEmpty()) {
                recipes.add(recipe);
                recipe = new ArrayList<>();
                continue;
            }
            
            recipe.add(line);
        }
        recipes.add(recipe);
        return recipes;
    }
    
    public void printRecipes() {
        for (ArrayList<String> list : this.recipes) {
            System.out.println(list.get(0) + ", cooking time: " + list.get(1));
        }
    }
    
    public ArrayList<String> findByName(String name) {
        ArrayList<String> matches = new ArrayList<>();
        
        for (ArrayList<String> list : this.recipes) {
            if (list.get(0).contains(name)) {
                String match = list.get(0) + ", cooking time: " + list.get(1);
                matches.add(match);
            }
        }
        return matches;
    }
    
    public ArrayList<String> findByTime(int time) {
        ArrayList<String> matches = new ArrayList<>();
        
        for (ArrayList<String> list : this.recipes) {
            if (Integer.valueOf(list.get(1)) <= time) {
                String match = list.get(0) + ", cooking time: " + list.get(1);
                matches.add(match);
            }
        }
        return matches;
    }
    
    public ArrayList<String> findByIngredient(String ingredient) {
        ArrayList<String> matches = new ArrayList<>();
        
        for (ArrayList<String> list : this.recipes) {
            for (int i = 2; i < list.size(); i += 1) {
                if (list.get(i).equals(ingredient)) {
                    String match = list.get(0) + ", cooking time: " + list.get(1);
                    matches.add(match);
                    break;
                }
            }
        }
        return matches;
    }
}

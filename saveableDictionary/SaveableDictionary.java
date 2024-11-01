
package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SaveableDictionary {
    private HashMap<String, String> dict;
    private String fileName;
    
    public SaveableDictionary() {
        this.dict = new HashMap<>();
    }
    
    public SaveableDictionary(String fileName) {
        this.dict = new HashMap<>();
        this.fileName = fileName;
    }
    
    public void add(String word, String translation) {
        this.dict.putIfAbsent(word, translation);
        this.dict.putIfAbsent(translation, word);
    }
    
    public String translate(String word) {
        return this.dict.get(word);
    }
    
    public void delete(String word) {
        this.dict.remove(this.dict.get(word));
        this.dict.remove(word);
    }
    
    public boolean load() {
        try {
            
            Scanner scanner = new Scanner(Paths.get(this.fileName));
            
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(":");
                this.dict.put(words[0], words[1]);
                this.dict.put(words[1], words[0]);
            }
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean save() {
        try {
            
            PrintWriter writer = new PrintWriter(this.fileName);
            
            ArrayList<String> lines = new ArrayList<>();
            for (String word : this.dict.keySet()) {
                String line = word + ":" + this.dict.get(word);
                lines.add(line);
            }
            
            ArrayList<String> seen = new ArrayList<>();
            for (String string : lines) {
                String[] data = string.split(":");
                if (!(seen.contains(data[0])) && !(seen.contains(data[1]))) {
                    writer.println(string);
                    seen.add(data[0]);
                    seen.add(data[1]);
                }
            }
            writer.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}

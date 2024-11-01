import java.util.ArrayList;

public class BirdBook {
    private ArrayList<Bird> birds;
    
    public BirdBook() {
        this.birds = new ArrayList<>();
    }
    
    public void addBird(String name, String latinName) {
        boolean found = false;
        for (Bird bird : this.birds) {
            if (bird.getName().equals(name)) {
                found = true;
                break;
            }
        }
        if (!found) {
            this.birds.add(new Bird(name, latinName));
        }
    }
    
    public int addObservation(String name) {
        for (Bird bird : this.birds) {
            if (bird.getName().equals(name)) {
                bird.addObservation();
                return 0;
            }
        }
        return -1;
    }
    
    public String searchByName(String name) {
        for (Bird bird : this.birds) {
            if (bird.getName().equals(name)) {
                return bird.toString();
            }
        }
        return "Bird not found";
    }
    
    public ArrayList<Bird> getBirds() {
        return this.birds;
    }
}

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private GradeBook gradeBook;
    
    public UserInterface(Scanner scanner, GradeBook gradeBook) {
        this.scanner = scanner;
        this.gradeBook = gradeBook;
    }
    
    public void start() {
        this.runLoop();
        this.average();
        this.passingAverage();
        this.passingPercent();
        this.gradeBook.gradeDistribution();
    }
    
    private void runLoop() {
        System.out.println("Enter point totals, -1 stops: ");
        
        while (true) {
            String input = this.scanner.nextLine();
            
            if (input.equals("-1")) {
                break;
            }
            
            int points = Integer.valueOf(input);
            this.gradeBook.addGradeFromPoints(points);
        }
    }
    
    private void average() {
        double avg = this.gradeBook.pointAverage();
        System.out.println("Point average (all): " + avg);
    }
    
    private void passingAverage() {
        double avg = this.gradeBook.passingPointAverage();
        if (avg == -1) {
            System.out.println("Point average (passing): -");
        } else {
            System.out.println("Point average (passing): " + avg);
        }
    }
    
    private void passingPercent() {
        double percent = this.gradeBook.passingPercentage();
        System.out.println("Pass percentage: " + percent);
    }
}

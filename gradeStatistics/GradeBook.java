import java.util.ArrayList;

public class GradeBook {
    private ArrayList<Integer> examPoints;
    private ArrayList<Integer> grades;
    
    public GradeBook() {
        this.examPoints = new ArrayList<>();
        this.grades = new ArrayList<>();
    }
    
    public void addGradeFromPoints(int points) {
        if (points >= 0 && points <= 100) {
            this.examPoints.add(points);
            this.grades.add(this.pointsToGrade(points));
        }
    }
    
    private int pointsToGrade(int points) {
        if (points < 50) {
            return 0;
        } else if (points < 60) {
            return 1;
        } else if (points < 70) {
            return 2;
        } else if (points < 80) {
            return 3;
        } else if (points < 90) {
            return 4;
        } else {
            return 5;
        }
    }
    
    public double pointAverage() {
        if (!(this.examPoints.isEmpty())) {
            int sum = 0;
            int total = this.examPoints.size();
            for (int points : this.examPoints) {
                sum += points;
            }
            return sum / (total * 1.0);
        }
        return -1;
    }
    
    public double passingPointAverage() {
        if (!(this.examPoints.isEmpty())) {
            int sum = 0;
            int total = 0;
            for (int points : this.examPoints) {
                if (points >= 50) {
                    sum += points;
                    total += 1;
                }
            }
            return sum / (total * 1.0);
        }
        return -1;
    }
    
    public double passingPercentage() {
        int grades = this.examPoints.size();
        int passingGrades = 0;
        for (int points : this.examPoints) {
            if (points >= 50) {
                passingGrades += 1;
            }
        }
        return (100 * (passingGrades / (grades * 1.0)));
    }
    
    private String gradeDistributionStars(int grade) {
        String stars = "";
        for (int points : this.grades) {
            if (points == grade) {
                stars += "*";
            }
        }
        return stars;
    }
    
    public void gradeDistribution() {
        System.out.println("Grade distribution:");
        
        for (int i = 5; i > -1; i -= 1) {
            String stars = this.gradeDistributionStars(i);
            System.out.println(i + ": " + stars);
        }
    }
}

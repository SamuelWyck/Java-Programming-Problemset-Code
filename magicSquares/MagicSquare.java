
import java.util.ArrayList;
import java.util.Collections;

public class MagicSquare {

    private int[][] square;

    // ready constructor
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }

        this.square = new int[size][size];
    }

    // implement these three methods
    public ArrayList<Integer> sumsOfRows() {
        ArrayList<Integer> sums = new ArrayList<>();
        
        for (int row = 0; row < this.square.length; row += 1) {
            
            int sum = 0;
            
            for (int col = 0; col < this.square[row].length; col += 1) {
                sum += this.square[row][col];
            }
            sums.add(sum);
        }
        
        return sums;
    }

    public ArrayList<Integer> sumsOfColumns() {
        ArrayList<Integer> sums = new ArrayList<>();
        
        for (int row = 0; row < this.square.length; row += 1) {
            for (int col = 0; col < this.square[row].length; col += 1) {
                if (row == 0) {
                    sums.add(this.square[row][col]);
                } else {
                    sums.set(col, sums.get(col) + this.square[row][col]);
                }
            }
        }
        
        return sums;
    }

    public ArrayList<Integer> sumsOfDiagonals() {
        ArrayList<Integer> sums = new ArrayList<>();
        
        int dag1 = 0;
        int dag2 = 0;
        
        int r1 = 0;
        int c1 = 0;
        int r2 = 0;
        int c2 = this.square[0].length - 1;
        
        for (int row = 0; row < this.square.length; row += 1) {
            for (int col = 0; col < this.square[row].length; col += 1) {
                if (row == r1 && col == c1) {
                    dag1 += this.square[row][col];
                    r1 += 1;
                    c1 += 1;
                }
                if (row == r2 && col == c2) {
                    dag2 += this.square[row][col];
                    r2 += 1;
                    c2 -= 1;
                }
            }
        }
        
        sums.add(dag1);
        sums.add(dag2);
        return sums;
    }

    // ready-made helper methods -- don't touch these
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return - 1;
        }

        return this.square[y][x];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}

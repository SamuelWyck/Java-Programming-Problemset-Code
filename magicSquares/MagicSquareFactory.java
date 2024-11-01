
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here
        int row = 0;
        int col = ((size - 1)/ 2);
        int sequence = 1;
        while (true) {
            if (square.readValue(row, col) != 0) {
                break;
            }
            square.placeValue(row, col, sequence);
            sequence += 1;
            
            int possibleRow = this.clampIndex(row - 1, size);
            int possibleCol = this.clampIndex(col + 1, size);
            
            if (square.readValue(possibleRow , possibleCol) == 0) {
                row = possibleRow;
                col = possibleCol;
            } else {
                row = this.clampIndex(row + 1, size);
            }
        }
         
        return square;
    }
    
    private int clampIndex(int index, int size) {
        if (index < 0) {
            return size - 1;
        }
        if (index > size - 1) {
            return 0;
        }
        return index;
    }

}

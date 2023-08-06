/** This program was designed to place all the cards in 
 * the deck in a grid format
 * 
 * @author Riya Gunda
 * @version 1.0
 */
public class Grid {
    
    /**
     * Private instance variable for the number of rows in
     * the grid
     */
    private int rows;

    /**
     * Private instance variable for the number of columns in
     * the grid
     */
    private int cols;

    /**
     * Private instance variable for the array in which
     * the cards will be stacked
     */
    private Card[][] cards;

    /**
     * This is the constructor for the grid class. It sets the 
     * values for rows, cols, and initializes the cards 2D array
     * and its size
     * @param rows number of rows in the grid
     * @param cols number of columns in the grid
     * @throws IllegalArgumentException with the message "Invalid rows/cols" 
     * if the inputted value is less then 1
     */
    public Grid(int rows, int cols) {
        if(rows < 1 || cols < 1){
            throw new IllegalArgumentException("Invalid rows/cols");
        }
        this.rows = rows;
        this.cols = cols; 
        this.cards = new Card[rows][cols];
    }

    /**
     * This method sets the value of card in the array at
     * the given row and column value
     * 
     * @param row the row in which the card should be placed
     * @param col the column in which the card shoule be placed
     * @param card the value of the card being added to
     * the grid
     * 
     * @throws IllegalArgumentException with the message "Null cards"
     * if the card variable is null
     * @throws IllegalArgumentExcpetion with the message "Invalid row"
     * if the row variable is not valid
     * @throws IllegalArgumentException with the message "Invalid col"
     * if the column variable is not valid
     */
    public void setCard(int row, int col, Card card) {
        if(card == null) {
            throw new IllegalArgumentException("Null card");
        }

        if(row < 0 || row >= rows) {
            throw new IllegalArgumentException("Invalid row");
        }

        if(col < 0 || col >= cols) {
            throw new IllegalArgumentException("Invalid col");
        }
        cards[row][col] = card;
    }

    /**
     * This is getter method for the card variable
     * 
     * @param row the row in which the card is
     * @param col the column in which the card is
     * 
     * @return the card value at the given row and column
     * 
     * @throws IllegalArgumentExcpetion with the message "Invalid row"
     * if the row variable is not valid
     * @throws IllegalArgumentException with the message "Invalid col"
     * if the column variable is not valid
     */
    public Card getCard(int row, int col) {
        if(row < 0 || row >= rows) {
            throw new IllegalArgumentException("Invalid row");
        }

        if(col < 0 || col >= cols) {
            throw new IllegalArgumentException("Invalid col");
        }
        return cards[row][col];
    }

    /**
     * This method converts the deck into a string
     * @return a string of the deck contents
     */
    public String toString() {
        String print = "";
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j++){
                if(j != cols - 1) {
                    print += cards[i][j] + " ";
                } else {
                    print += cards[i][j];
                }
            }
            print += "\n";
        }
        return print;
    }
}


/** This program was designed to check if the 
 * cards found are a match or not. It also 
 * increments the total number of guess, correct
 * guesses, and guessing average.
 * 
 * @author Riya Gunda
 * @version 1.0
 */
public class MatchGame {
    /** Variable for the total number of rows the grid can have */
    public static final int ROWS = 4;

    /** Variable for the total number of columns the grid can have */
    public static final int COLS = 13;

    /** Private instance variable for the deck object */
    private Deck deck;

    /** Private instance variable for the grid object */
    private Grid grid;

    /** 
     * Private instance variable for the total number of 
     * correct guesses
     */
    private int numberOfCorrectGuesses;

    /** Private instance variable for the total number of 
     * guesses
     */
    private int numberOfGuesses;

    /** Private instance variable for the game difficulty */
    private boolean isEasy;

    /**
     * This is the constructor for this class. It shuffles the
     * deck and creates the final grid of cards.
     * 
     * @param isTesting boolean variable for whether the program
     * is being tested or not
     * @param isEasy boolean variable for the difficulty of the game
     */
    public MatchGame(boolean isTesting, boolean isEasy) {
        this.isEasy = isEasy;
        deck = new Deck();
        if(isTesting == false) {
            deck.shuffle();
        } 
        grid = new Grid(ROWS, COLS);
        for(int i = 0; i < ROWS; i++) {
            for(int j = 0; j < COLS; j++) {
                grid.setCard(i, j, deck.nextCard());
            }
        }
    }

    /**
     * Getter method for numberOfGuesses variable
     * 
     * @return numberOfGuesses
     */
    public int getNumberOfGuesses() {
        return numberOfGuesses;
    }

    /**
     * Getter method for numberOfCorrectGuesses variable
     * 
     * @return numberOfCorrectGuesses
     */
    public int getNumberOfCorrectGuesses() {
        return numberOfCorrectGuesses;
    }

    /**
     * This method outputs the average correctness
     * or the accuracy of the players guesses
     * 
     * @return the average value of their accuracy
     */
    public double getGuessAverage() {
        if(numberOfGuesses == 0) {
            return 0;
        }
        double avg = (double) numberOfCorrectGuesses / numberOfGuesses;
        return avg;
    }

    /**
     * This method returns the card selected
     * 
     * @param row the row in which the card is
     * @param col the column in which the card is
     * 
     * @return a string of the card value
     * 
     * @throws IllegalArgumentExcpetion with the message "Invalid row"
     * if the row variable is not valid
     * @throws IllegalArgumentException with the message "Invalid col"
     * if the column variable is not valid
     */
    public String getCardName(int row, int col) {
        if(row < 0 || row >= ROWS) {
            throw new IllegalArgumentException("Invalid row");
        }

        if(col < 0 || col >= COLS) {
            throw new IllegalArgumentException("Invalid col");
        }

        return grid.getCard(row, col).toString();
    }

    /**
     * This method checks if the card has been found yet.
     * 
     * @param row the row in which the card is
     * @param col the column in which the card is
     * 
     * @return a boolean value on whether the card has been found
     * or not
     * 
     * @throws IllegalArgumentExcpetion with the message "Invalid row"
     * if the row variable is not valid
     * @throws IllegalArgumentException with the message "Invalid col"
     * if the column variable is not valid
     */
    public boolean hasBeenFound(int row, int col) {
        if(row < 0 || row >= ROWS) {
            throw new IllegalArgumentException("Invalid row");
        }

        if(col < 0 || col >= COLS) {
            throw new IllegalArgumentException("Invalid col");
        }

        if(grid.getCard(row, col).hasBeenFound()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method checks if the 2 cards selected are the same
     * 
     * @param card1Row row value of card 1
     * @param card1Col column value of card 1
     * @param card2Row row value fo card 2
     * @param card2Col column value of card 2
     * 
     * @return a boolean value to see if the cards are a match or not
     * 
     * @throws IllegalArgumentExcpetion with the message "Invalid card1Row"
     * if the row variable for card 1 is not valid
     * @throws IllegalArgumentException with the message "Invalid card1Col"
     * if the column variable for card 1 is not valid
     * @throws IllegalArgumentExcpetion with the message "Invalid card2Row"
     * if the row variable for card 2 is not valid
     * @throws IllegalArgumentException with the message "Invalid card2Col"
     * if the column variable for card 2 is not valid
     */
    public boolean isMatch(int card1Row, int card1Col, int card2Row, int card2Col) {
        if(card1Row < 0 || card1Row >= ROWS) {
            throw new IllegalArgumentException("Invalid card1Row");
        }

        if(card1Col < 0 || card1Col >= COLS) {
            throw new IllegalArgumentException("Invalid card1Col");
        }

        if(card2Row < 0 || card2Row >= ROWS) {
            throw new IllegalArgumentException("Invalid card2Row");
        }

        if(card2Col < 0 || card2Col >= COLS) {
            throw new IllegalArgumentException("Invalid card2Col");
        }

        if(!hasBeenFound(card1Row, card1Col) && !hasBeenFound(card2Row, card2Col)) {
            numberOfGuesses++;
            if(!isEasy) {
                if(grid.getCard(card1Row, card1Col).hasSameValueAndColor(grid.getCard(card2Row, 
                    card2Col))){
                    numberOfCorrectGuesses++;
                    grid.getCard(card1Row, card1Col).setHasBeenFound(true);
                    grid.getCard(card2Row, card2Col).setHasBeenFound(true);
                    return true;    
                }
            } else {
                if(grid.getCard(card1Row, card1Col).hasSameValue(grid.getCard(card2Row, card2Col))){
                    numberOfCorrectGuesses++;
                    grid.getCard(card1Row, card1Col).setHasBeenFound(true);
                    grid.getCard(card2Row, card2Col).setHasBeenFound(true);
                    return true;    
                }
            }
        } else {    
            numberOfGuesses++;
        }
        return false;
    }

    /**
     * Getter method for the deck variable
     * @return the deck
     */
    public Deck getDeck() {
        return deck;
    }

    /**
     * Getter method for the grid variable
     * @return the grid
     */
    public Grid getGrid() {
        return grid;
    }
}
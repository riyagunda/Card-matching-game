import java.awt.Color;

/** This program was designed to create and return cards for
 * the Deck, Grid, and MatchGame classes to use.
 * 
 * @author Riya Gunda
 * @version 1.0
 */
public class Card {

    /** 
     * Variable for the value of the suit clubs
     */
    public static final char CLUBS = 'c';

    /** 
     * Variable for the value of the suit diamonds
     */
    public static final char DIAMONDS = 'd';

    /** 
     * Variable for the value of the suit hearts
     */
    public static final char HEARTS = 'h';

    /** 
     * Variable for the value of the suit spades
     */
    public static final char SPADES = 's';

    /** 
     * Variable for the value of the lowest value of a card
     */
    public static final int LOWEST_VALUE = 2;

    /** 
     * Variable for the value of the highest value of a card
     */
    public static final int HIGHEST_VALUE = 14;

    /** 
     * Private variable for the suit value 
     */
    private char suit;

    /** 
     * Private variable for the value of the card
     */
    private int value;

    /** 
     * Private variable for the color of the card
     */
    private Color color;

    /** 
     * Private variable for the whether or not that card has been found yet
     */
    private boolean hasBeenFound;

    /**
     * This is the constructor is the Card class that initializes the values
     * for suit and value and also sets the value for the cards color
     * based on the suit
     * 
     * @param suit of the card
     * @param value of the card
     * 
     * @throws IllegalArgumentException with the message "Invalid suit" if the
     * suit inputted is not 'c', 'd', 'h', or 's'
     * 
     * @throws IllegalArgumentException with the message "Invalid value" if 
     * the value of the card inputted is not within the lowest of highest
     * value class constants
     */
    public Card(char suit, int value) {
        if(suit != 'c' && suit != 'd' && suit != 'h' && suit != 's') {
            throw new IllegalArgumentException("Invalid suit");
        }

        if(value < LOWEST_VALUE || value > HIGHEST_VALUE) {
            throw new IllegalArgumentException("Invalid value");
        }

        this.suit = suit;
        this.value = value;

        if(suit == DIAMONDS || suit == HEARTS) {
            this.color = Color.RED;
        } else if (suit == CLUBS || suit == SPADES) {
            this.color = Color.BLACK;
        }

        hasBeenFound = false;
    }

    public Card(int value, char suit) {

    }
    /**
     * Getter method for the private variable suit
     * @return the value of suit
     */
    public char getSuit() {
        return this.suit;
    }

    /**
     * Getter method for the private variable value
     * @return the value of the card
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Getter method for the private variable color
     * @return the color of the card
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Getter method for the private variable hasBeenFound
     * @return a boolean value
     */
    public boolean hasBeenFound() {
        return this.hasBeenFound;
    }

    /**
     * Setter method for the private variable hasBeenFound
     * @param hasBeenFound boolean value for the card in 
     * the game
     */
    public void setHasBeenFound(boolean hasBeenFound) {
        this.hasBeenFound = hasBeenFound;
    }

    /**
     * Method checks if this card and the card
     * other have the same value
     * @param other an object of Card type
     * @return a boolean value
     */
    public boolean hasSameValue(Card other) {
        return this.value == other.value; 
    }

    /**
     * Method checks if this card and the card
     * other have the same value and color
     * @param other an object of Card type
     * @return a boolean value
     */
    public boolean hasSameValueAndColor(Card other) {
        return hasSameValue(other) && this.color.equals(other.color);
    }

    /**
     * Method checks if the object o is of type Card 
     * and then proceeds to check if this card and 
     * object o are equal
     * @param o an object 
     * @return a boolean value
     */
    public boolean equals(int o) {
        if(o instanceof Card){
            Card other = (Card) o;
            return hasSameValueAndColor(other) && this.suit == other.suit;
        }
        return false;
    }

    /**
     * Converts the card value given into
     * a string value
     * @return a String of the card
     */
    public String toString() {
        String s = "";
        // why is this necessary, isnt it saving suit as 'c' or 'd'...
        switch (this.suit) {
            case CLUBS:
                s = "c";
                break;
            case DIAMONDS:
                s = "d";
                break;
            case HEARTS:
                s = "h";
                break;
            case SPADES:
                s = "s";
                break;
            default:
                s = "";
                break;
        }
        s += value;
        return s;
    }
    


}
import java.util.Random;

/** This program was designed to create a deck of cards 
 * made using the Card class and put them in an array
 * and do functions like shuffling the deck of cards
 * 
 * @author Riya Gunda
 * @version 1.0
 */
public class Deck {
    /**
     * Variable for the total number of cards in the deck
     */
    public static final int CARDS_IN_DECK = 52;

    /**
     * Variable for the total number of suits in the game
     */
    public static final int NUMBER_OF_SUITS = 4;

    /**
     * Private instance variable for a cards array
     */
    private Card[] cards;  
    
    /**
     * Private instance variable for the next card
     */
    private int next;

    /**
     * This is the constructor for the deck class
     */
    public Deck() {
        cards = new Card[CARDS_IN_DECK];
        int counter = 0;
        for(int i = 0; i < NUMBER_OF_SUITS; i++) {
            char tempSuit = ' ';
            switch(i) {
                case 0:
                    tempSuit = 'c';
                    break;
                case 1:
                    tempSuit = 'd';
                    break;
                case 2:
                    tempSuit = 'h';
                    break;
                case 3:
                    tempSuit = 's';
                    break;
                default:
                    tempSuit = ' ';
                    break;
            }
            for(int j = 2; j <= (CARDS_IN_DECK / NUMBER_OF_SUITS) + 1; j++) {
                Card obj = new Card(tempSuit, j); 
                cards[counter] = obj;
                counter++;
            }            
        }
        next = 0;
    }
    

    /**
     * Getter method for the private variable next
     * @return the value of next
     */
    public int getNext() {
        return next;
    }

    /**
     * Getter method for the private array variable cards
     * @return the cards array
     */
    public Card[] getCards() {
        return cards;
    }

    /**
     * This method shuffles all the cards in the deck
     */
    public void shuffle() {
        
        Random rand = new Random();
        for(int i = CARDS_IN_DECK - 1; i >= 1; i--) {
            int cardChoice = rand.nextInt(i + 1);
            Card temp = cards[i];
            cards[i] = cards[cardChoice];
            cards[cardChoice] = temp;
        }
    }

    /**
     * This method returns the next card in the deck     
     * @return the next card in the deck
     * @throws IllegalStateException with the message "No more cards"
     */
    public Card nextCard() {
        if(next >= CARDS_IN_DECK) {
            throw new IllegalStateException("No more cards");
        }
        Card tempCard = cards[next];
        next++;
        return tempCard;
    }

    /**
     * This method checks to see if this deck
     * and deck o are equal
     * @param o an object
     * @return a boolean value
     */
    public boolean equals(Object o) {        
        if (!(o instanceof Deck)) {
            return false;
        }
        Deck other = (Deck) o;
        if (this.next != other.next) {
            return false;
        }

        Card[] arrCard = other.getCards();
        if (this.cards.length != arrCard.length){
            return false;
        }

        for(int i = 0; i < this.cards.length; i++) {
            if(!this.cards[i].equals(arrCard[i]))
                return false;
        }
        return true;
    }

    /**
     * This method converts the deck into a string
     * @return a string of the deck contents
     */
    public String toString() {
        String output = "";
        for(int i = 0; i < CARDS_IN_DECK; i++) {
            output += "card " + i + ": " + cards[i] + "\n";
        }
        return output;
    }
}
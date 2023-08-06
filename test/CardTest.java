import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;


/**
 * Tests Card class
 * @author Suzanne Balik
 * @author Riya Gunda
 */
public class CardTest {

    /** card two of hearts for testing */
    private Card twoOfHearts;

    /** card five of clubs for testing */
    private Card fiveOfClubs;

    /**
     * Create cards for testing
     */
    @BeforeEach
    public void setUp() {
        twoOfHearts = new Card('h', 2);
        fiveOfClubs = new Card('c', 5);
    }

    /**
     * Tests constants
     */
    @Test
    public void testConstants() {
        assertEquals('c', Card.CLUBS, "CLUBS");
        assertEquals('d', Card.DIAMONDS, "DIAMONDS");
        assertEquals('s', Card.SPADES, "SPADES");
        assertEquals('h', Card.HEARTS, "HEARTS");
        assertEquals(2, Card.LOWEST_VALUE, "LOWEST_VALUE");
        assertEquals(14, Card.HIGHEST_VALUE, "HIGHEST_VALUE]");
    }

    /**
     * Tests constructor preconditions
     */
    @Test
    public void testConstructorPreConditions() {
        // Testing constructor with low invalid value
        Exception exception = assertThrows(IllegalArgumentException.class,
            () -> new Card('h', 1), "Constructor value 1");
        assertEquals("Invalid value", exception.getMessage(),
                "Testing value 1 message");
                
        // Testing constructor with high invalid value
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Card('s', 15), "Constructor value 15");
        assertEquals("Invalid value", exception.getMessage(),
                "Testing value 15 message");
                
        // Testing constructor with invalid suit and invalid value
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Card('w', 0), "Constructor suit w value 0");
        assertEquals("Invalid suit", exception.getMessage(),
                "Testing suit w value 0 message");
                
        // Testing constructor with invalid lowercase suit
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Card('x', 5), "Constructor suit x");
        assertEquals("Invalid suit", exception.getMessage(),
                "Testing suit x message");
                
        // Testing constructor with invalid uppercase suit
        exception = assertThrows(IllegalArgumentException.class,
            () -> new Card('D', 5), "Constructor suit D");
        assertEquals("Invalid suit", exception.getMessage(),
                "Testing suit D message");
    }
    
    /**
     * Test getSuit() for two of hearts
     */
    @Test
    public void testGetSuitTwoOfHearts() {
        assertEquals('h', twoOfHearts.getSuit(), "twoOfHearts suit");
    }

    /**
     * Test getSuit() for five of clubs
     */
    @Test
    public void testGetSuitFiveOfClubs() {
        assertEquals('c', fiveOfClubs.getSuit(), "fiveOfClubs suit");
    }

    /**
     * Test getValue() for two of hearts
     */
    @Test
    public void testGetValueTwoOfHearts() {
        assertEquals( 2, twoOfHearts.getValue(), "twoOfHearts value");
    }

    /**
     * Test getValue() for five of clubs
     */
    @Test
    public void testGetValueFiveOfClubs() {
        assertEquals( 5, fiveOfClubs.getValue(), "fiveOfClubs value");
    }

    /**
     * Test getColor() for two of hearts
     */
    @Test
    public void testGetColorTwoOfHearts() {
        assertEquals(Color.RED, twoOfHearts.getColor(), "twoOfHearts color");
    }

    /**
     * Test getColor() for five of clubs
     */
    @Test
    public void testGetColorFiveOfClubs() {
        assertEquals(Color.BLACK, fiveOfClubs.getColor(), "fiveOfClubs color");
    }

    /**
     * Test toString() for two of hearts
     */
    @Test
    public void testToStringTwoOfHearts() {
        assertEquals("h2", twoOfHearts.toString(), "twoOfHearts toString");
    }

    /**
     * Test toString() for five of clubs
     */
    @Test
    public void testToStringFiveOfClubs() {
        assertEquals("c5", fiveOfClubs.toString(), "fiveOfClubs toString");
    }
  
    /**
     * Test hasBeenFound() for two of hearts
     */
    @Test
    public void testHasBeenFoundTwoOfHearts() {
        assertFalse(twoOfHearts.hasBeenFound(), "twoOfHearts hasBeenFound");
    }

    /**
     * Test hasBeenFound() for five of clubs
     */
    @Test
    public void testHasBeenFoundFiveOfClubs() {
        assertFalse(fiveOfClubs.hasBeenFound(), "fiveOfClubs hasBeenFound");
    }

    /**
     * Test setHasBeenFound() for two of hearts
     */
    @Test
    public void testSetHasBeenFoundTwoOfHearts() {
        twoOfHearts.setHasBeenFound(true);
        assertTrue(twoOfHearts.hasBeenFound(), "twoOfHearts setHasBeenFound true");
        twoOfHearts.setHasBeenFound(false);
        assertFalse(twoOfHearts.hasBeenFound(), "twoOfHearts setHasBeenFound false");
    }

    /**
     * Test setHasBeenFound() for fiveOfClubs
     */
    @Test
    public void testSetHasBeenFoundFiveOfClubs() {
        fiveOfClubs.setHasBeenFound(true);
        assertTrue(fiveOfClubs.hasBeenFound(), "fiveOfClubs setHasBeenFound true");
        fiveOfClubs.setHasBeenFound(false);
        assertFalse(fiveOfClubs.hasBeenFound(), "fiveOfClubs setHasBeenFound false");
    }

    /**
     * Test hasSameValue() for two of hearts
     */
    @Test
    public void testHasSameValue() {
        assertTrue(twoOfHearts.hasSameValue(new Card('c', 2)), "twoOfHearts has same value");
        assertFalse(twoOfHearts.hasSameValue(new Card('s', 3)), "twoOfHearts has different value");
    }

    /**
     * Test hasSameValue() for five of clubs
     */
    @Test
    public void testHasSameValueFiveOfClubs() {
        assertTrue(fiveOfClubs.hasSameValue(new Card('h', 5)), "fiveOfClubs has same value");
        assertFalse(fiveOfClubs.hasSameValue(new Card('s', 3)), "fiveOfClubs has different value");
    }

    /**
     * Test hasSameValueAndColor() for two of hearts
     */
    @Test
    public void testHasSameValueAndColor() {
        assertTrue(twoOfHearts.hasSameValueAndColor(new Card('d', 2)),
                   "twoOfHearts has same value and color");
        assertFalse(twoOfHearts.hasSameValueAndColor(new Card('s', 3)),
                    "twoOfHearts has different value and color");
        assertFalse(twoOfHearts.hasSameValueAndColor(new Card('d', 8)),
                    "twoOfHearts has different value and same color");
        assertFalse(twoOfHearts.hasSameValueAndColor(new Card('s', 2)), 
                    "twoOfHearts has same value and different color");
    }

    /**
     * Test hasSameValueAndColor() for five of clubs
     */
    @Test
    public void testHasSameValueAndColorFiveOfClubs() {
        assertTrue(fiveOfClubs.hasSameValueAndColor(new Card('s', 5)),
                   "fiveOfClubs has same value and color");
        assertFalse(fiveOfClubs.hasSameValueAndColor(new Card('h', 3)),
                    "fiveOfClubs has different value and color");
        assertFalse(fiveOfClubs.hasSameValueAndColor(new Card('s', 8)),
                    "fiveOfClubs has different value and same color");
        assertFalse(fiveOfClubs.hasSameValueAndColor(new Card('d', 5)), 
                    "fiveOfClubs has same value and different color");
    }

    /**
     * Test equals() for two of hearts
     */
    @Test
    public void testEqualsTwoOfHearts() {
        assertTrue(twoOfHearts.equals(twoOfHearts), "twoOfHearts equals with same instance");
        assertTrue(twoOfHearts.equals(new Card('h', 2)), 
                   "twoOfHearts equals with different instances");
        assertFalse(twoOfHearts.equals(new Card('h', 4)), "twoOfHearts with different value");
        assertFalse(twoOfHearts.equals(new Card('s', 2)), "twoOfHearts with different suit");
        assertFalse(twoOfHearts.equals(new Card('c', 5)), 
                    "twoOfHearts with different value and suit");
        assertFalse(twoOfHearts.equals(null), "twoOfHearts compared to null object");
        assertFalse(twoOfHearts.equals("twoOfHearts"), "twoOfHearts compared to String");
    }

    /**
     * Test equals() for five of clubs
     */
    @Test
    public void testEqualsFiveOfClubs() {
        assertTrue(fiveOfClubs.equals(fiveOfClubs), "fiveOfClubs equals with same instance");
        assertTrue(fiveOfClubs.equals(new Card('c', 5)), 
                   "fiveOfClubs equals with different instances");
        assertFalse(fiveOfClubs.equals(new Card('c', 4)), "fiveOfClubs with different value");
        assertFalse(fiveOfClubs.equals(new Card('d', 5)), "fiveOfClubs with different suit");
        assertFalse(fiveOfClubs.equals(new Card('h', 3)), 
                    "fiveOfClubs with different value and suit");
        assertFalse(fiveOfClubs.equals(null), "fiveOfClubs compared to null object");
        assertFalse(fiveOfClubs.equals("fiveOfClubs"), "fiveOfClubs compared to String");
    }
}
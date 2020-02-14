package model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Objects;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestItemOrder {
    /**
     * Private item and order fields to do the testing
     * */
    Item item1;
    Item item2;
    ItemOrder order1;
    ItemOrder order2;

    /**
     * Re initializes the fields before each test
     * */
    @BeforeEach
    void setUp() throws Exception {
        item1 = new Item("Test 1", new BigDecimal(12.10));
        item2 = new Item("Test 2", new BigDecimal(11.10));
        order1 = new ItemOrder(item1, 6);
        order2 = new ItemOrder(item2, 5);
    }


    /**
     * A method to test the toString method of the ItemOrder class.
     * */
    @Test
    void testToString() {
        //Testing equality
        String expected = "Test 1, $12.10 Quantity: 6";
        assertEquals(expected, order1.toString());
        //Testing inequality
        assertFalse(order1.toString().equals(order2.toString()));
    }
    
    /**
     * A method to test the hashCode method of the ItemOrder class.
     * */
    @Test 
    void testTestHashCode() {
        //Testing if it is an integer.
        assertTrue((Integer) order1.hashCode() instanceof Integer);
        //Testing if its equal to objects.hash
        assertEquals(Objects.hash(order1.getItem(),order1.getQuantity()), order1.hashCode());
    }
    
    @Test
    void testEquals() {
        //Testing orders to see if they aren't equal
        assertFalse(order1.equals(order2));
        //Null case
        assertEquals(false, order1.equals(null));
        //Testing the same order
        assertTrue(order1.equals(order1));
        //Testing equal orders
        order2 = new ItemOrder(item1, 6);
        assertTrue(order1.equals(order2));
        
    }
    
    /**
     * A method to test to compareTo method of the ItemOrder class.
     * */
    @Test
    void testCompareTo() {
        //Testing the base two orders, should return 1
        assertEquals(-1, order1.compareTo(order2));
        //Testing the equal orders, should return 0
        order2 = new ItemOrder(item1, 6);
        assertEquals(0, order1.compareTo(order2));
        //Testing the set of orders that should return -1
        order2 = new ItemOrder(item2, 5);
        assertEquals(1, order2.compareTo(order1));
        //Testing the null case
        assertEquals(0, order2.compareTo(null));
        
    }
}

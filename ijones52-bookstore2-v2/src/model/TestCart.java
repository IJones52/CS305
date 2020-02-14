package model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Objects;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCart {
    
    /**
     * Private item, order, and cart fields to do the testing
     * */
    Item item1;
    Item item2;
    ItemOrder order1;
    ItemOrder order2;
    Cart cart1;
    Cart cart2;
   
    /**
     * A method that reinitializes new cart, order, and item fields before each Test method
     * */
    @BeforeEach
    void setUp() throws Exception {
        item1 = new Item("Test 1", new BigDecimal(12.10));
        item2 = new Item("Test 2", new BigDecimal(11.10));
        order1 = new ItemOrder(item1, 6);
        order2 = new ItemOrder(item2, 5);
        cart1 = new Cart();
        cart2 = new Cart();
        cart1.add(order1);
        cart2.add(order2);
    }

    /**
     * A method that tests the toString method of the cart class
     * */
    @Test
    void testToString() {
        //Testing equality
        String expected  = "[Test 1, $12.10 Quantity: 6] ";
        assertEquals(expected, cart1.toString());
        //Testing inequality
        assertFalse(cart1.toString().equals(cart2.toString()));
        
    }
    
    /**
     * A method that tests the hashCode() method of the cart class.
     * */
     @Test
    void testToHashCode() {
         //Testing the output is an integer
         assertTrue((Integer)cart1.hashCode() instanceof Integer);
         //Testing if the output is equal to Objects.hash
         assertEquals(Objects.hash(cart1.getMembershipStatus(),cart1.getOrders()), cart1.hashCode());
         
     }
    
    

}

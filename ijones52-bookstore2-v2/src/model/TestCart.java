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
     * A method that tests the hashCode method of the cart class.
     * */
     @Test
    void testHashCode() {
         //Testing the output is an integer
         assertTrue((Integer)cart1.hashCode() instanceof Integer);
         //Testing if the output is equal to Objects.hash
         assertEquals(Objects.hash(cart1.getMembershipStatus(),cart1.getOrders()), cart1.hashCode());
         
     }
     
     /**
      * A method that tests the equals method of the cart class.
      * */
     @Test
     void testEquals() {
         //Testing for same object
         assertTrue(cart1.equals(cart1));
         //Testing for not matching carts
         assertFalse(cart1.equals(cart2));
         cart2.add(order1);
         assertFalse(cart1.equals(cart2));
         //Testing for matching carts
         cart2.clear();
         cart2.add(order1);
         assertTrue(cart1.equals(cart2));
         //Testing null case
         assertFalse(cart1.equals(null));
         
     }
     
     /**
      * A method that tests the compareTo method of the cart class.
      * */
     @Test
     void testCompareTo(){
         //Testing the null case
         assertEquals(0,cart1.compareTo(null));
         //Testing the base carts
         assertEquals(-1, cart1.compareTo(cart2));
         //Testing for the same cart
         assertEquals(0,cart1.compareTo(cart1));
         //Testing for the last combination
         assertEquals(1,cart2.compareTo(cart1));
     }
    
    

}

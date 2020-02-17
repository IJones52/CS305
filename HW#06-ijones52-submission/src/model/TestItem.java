package model;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Objects;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestItem {
    /**
     * Fields that contain items for testing.
     * */
    private Item item1;
    private Item item2;
    

    /**
     * Creates two non-identical items before each test is ran
     * */
    @BeforeEach
    void setUp() throws Exception {
        item1 = new Item("Test 1", new BigDecimal(12.10));
        item2 = new Item("Test 2", new BigDecimal(11.10));
    }


    /**
     * A method that checks if the hashCode method of he item class works. 
     * */
    @Test
    void testHashCode() {
        //Check if its an int, and check if its equal
        assertTrue((Integer) Objects.hash(item1.getName(),item1.getPrice(),item1.getBulkQuantity(),item1.getBulkPrice()) instanceof Integer);
        assertEquals(Objects.hash(item1.getName(),item1.getPrice(),item1.getBulkQuantity(),item1.getBulkPrice()), item1.hashCode());
    }
    
    /**
     * A method that tests the toString method in the item class
     * */
    @Test
    void testToString() {
        //Check if its equal
        String expected = "Test 1, $12.10";
        assertEquals(expected, item1.toString());
        //Check if its not equal
        assertFalse(expected.replace("1", "2").equals(item1.toString()));
        //Check if its equal for bulk pricing
        item1 = new Item("Test 1", new BigDecimal(12.10),2,new BigDecimal(5.0));
        expected = "Test 1, $12.10 (2 for $5.00)";
        assertEquals(expected, item1.toString());
    }
    
    /**A method that tests the equals method of the item class*/
    @Test
    void testEquals() {
        //Check if an item is equal to itself
        assertEquals(item1,item1);
        assertTrue(item1.equals(item1));
        //Check for non-equality
        assertFalse(item1.equals(item2));
        //Check if an item is equal to a new unique item
        Item test = new Item("Test 1", new BigDecimal(12.10));
        assertTrue(item1.equals(test));
    }
    
    /**
     * A method that tests the compareTo method of the item class
     * */
    @Test
    void testCompareTo() {
        //Testing the two base items, should return 1.
        assertEquals(0,item1.compareTo(item2));
        //Testing two equal items, should return 0
        item2 = new Item("Best 1", new BigDecimal(12.10));
        assertEquals(-1,item1.compareTo(item2));
        //Testing the last combination should return -1.
        item2 = new Item("Rest 0", new BigDecimal(12.10));
        assertEquals(1,item2.compareTo(item1));
        //Testing the null case
        assertEquals(0,item2.compareTo(null));
        
    }
    
    /**
     * A method that tests the compare method of the item class
     * */
    @Test
    void testCompare() {
      //Testing the two base items, should return 1.
        assertEquals(0,item1.compare(item1,item2));
        //Testing two equal items, should return 0
        item2 = new Item("Best 1", new BigDecimal(12.10));
        assertEquals(-1,item1.compare(item1,item2));
        //Testing the last combination should return -1.
        item2 = new Item("Rest 0", new BigDecimal(12.10));
        assertEquals(1,item2.compare(item2,item1));
        //Testing the null cases
        assertEquals(0,item2.compare(null,null));
        assertEquals(0,item2.compare(item1,null));
        assertEquals(0,item2.compare(null,item2));

    }
    
    /**
     * This one is just an accessor so I don't think i need to test it but i'n doing it for more coverage
     * */
    @Test
    void testIsBulk() {
        assertEquals(item1.isBulk(),false);
        item1 =  new Item("Test 1", new BigDecimal(12.10),2,new BigDecimal(5.0));
        assertEquals(item1.isBulk(), true);
    }

     

}

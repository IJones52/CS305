package model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Objects;

public class Test {
    
    /**A Class containing methods to test the item class*/
    
    public class TestItem{
        /**
         * A method that creates an item object and tests the toString method, by comparing it to an expected string
         * */
        public void test_toString() {
            System.out.println("toString test for the Item Class \n Inputs: Test Name, 12.10");
            Item item = new Item("Test Name", new BigDecimal(12.10));
            String expected ="Test Name, $12.10";
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + item.toString());
            if(expected.equals(item.toString())) {
                System.out.println("Success");          
            }
            else {System.out.println("Failure");}
        }
        
        /**
         * A method that creates two identical item objects and compares them two each other using the equals method
         * */
        public void test_equals() {
            System.out.println("equals test for the Item Class \n Inputs: Test Name, 12.10");
            Item item = new Item("Test Name", new BigDecimal(12.10));
            Item item2 = new Item("Test Name", new BigDecimal(12.10));
            System.out.println(item);
            System.out.println(item2);
            if(item.equals(item2)) {
                System.out.println("Success");          
            }
            else {System.out.println("Failure");}
            
        }
        
        /**
         * A method that creates an item object and tests the hashCode method by comparing it to Objects.hash on its fields
         * */
        public void test_hashCode() {
            System.out.println("hashCode test for the Item Class \n Inputs: Test Name, 12.10");
            Item item = new Item("Test Name", new BigDecimal(12.10));
            int expected = Objects.hash(item.getName(),item.getPrice(),item.getBulkQuantity(),item.getBulkPrice());
            int actual = item.hashCode();
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            if(expected == actual) {
                System.out.println("Success");          
            }
            else {System.out.println("Failure");}
        }
        
        /**
         * A method that creates two item objects to be compared to one another using the compare to method.
         * */
        public void test_comapreTo() {
            System.out.println("compareTo test for the Item Class \n Inputs: Test Name, 12.10 and New Name, 12.10");
            Item item = new Item("Test Name", new BigDecimal(12.10));
            Item item2 = new Item("New Name", new BigDecimal(12.10));
            int expected = -1;
            int actual = item.compareTo(item2);
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            if(expected == actual) {
                System.out.println("Success");          
            }
            else {System.out.println("Failure");}
           

        }
        
        /**
         * A method that tests the compare method of the item class. Takes two objects and compares them to each other*/
        public void test_compare() {
            System.out.println("compare test for the Item Class \n Inputs: Test Name, 12.10 and New Name, 12.10");
            Item item = new Item("Test Name", new BigDecimal(12.10));
            Item item2 = new Item("New Name", new BigDecimal(12.10));
            int expected = -1;
            int actual = item.compare(item,item2);
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            if(expected == actual) {
                System.out.println("Success");          
            }
            else {System.out.println("Failure");}
        }
            
       }
        
    
    /**A class containing methods that test out the methods for ITemOrder*/
    public class TestItemOrder{
        
        /**
         * A method that creates an ItemOrder and tests its toString method by comparing it an expected string
         * */
        public void test_ToString() {
            System.out.println("toString test for the ItemOrder class \nInputs: Item(TestItem, 12.10), 6 ");
            ItemOrder order = new ItemOrder(new Item("Test Item", new BigDecimal(12.10)), 6);
            String expected = "Test Item, $12.10 Quantity: 6";
            String actual = order.toString();
            System.out.println("Expected: " + expected);
            System.out.println("Actual: "+actual);
            if(expected.equals(actual)) {
                System.out.println("Success");
            }
            else {System.out.println("Failure");}
            
        }
        
        /**
         * A method that Creates two identical item orders and compares them by using the equals method
         * */
        //Needs fixing
        public void test_equals(){
            System.out.println("equals test for the ItemOrder class \nInputs: Item(TestItem, 12.10), 6 ");
            ItemOrder order = new ItemOrder(new Item("Test Item", new BigDecimal(12.10)), 6);
            ItemOrder order2 = new ItemOrder(new Item("Test Item", new BigDecimal(12.10)), 6);
            System.out.println(order);
            System.out.println(order2);
            if(order.equals(order2)) {
                System.out.println("Success");          
            }
            else {System.out.println("Failure");}
        }
        
        /**
         * A method that tests the ItemOrders hashcode method by comparing it aginsts Objects.hash on its fields
         * */
        public void test_hashCode() {
            System.out.println("hashCode test for the ItemOrder class \n Inputs: Item(Test Item, 12.10), 6");
            ItemOrder order = new ItemOrder(new Item("Test Item", new BigDecimal(12.10)), 6);
            System.out.println(order);
            int expected = Objects.hash(order.getItem(), order.getQuantity());
            int actual = order.hashCode();
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            if(expected == actual) {
                System.out.println("Success");          
            }
            else {System.out.println("Failure");}
            
        }
        
        /**
         * A method that creates two ItemOrders and compares them against each other using the compareTo method
         * */
        public void testComapreTo() {
            System.out.println("equals test for the ItemOrder class \nInputs: Item(Test Item, 12.10), 6. Item(New Item, 12.10), 6 ");
            ItemOrder order = new ItemOrder(new Item("Test Item", new BigDecimal(12.10)), 6);
            ItemOrder order2 = new ItemOrder(new Item("New Item", new BigDecimal(12.10)), 6);
            int expected = 1;
            int actual = order.compareTo(order2);
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            if(expected == actual) {
                System.out.println("Success");          
            }
            else {System.out.println("Failure");}
            
        }
        
    }
    
    /**A  class that contains methods to test out the methods of the cart class*/
    public class TestCart{
        
        /**
         * A method to test Carts toString method. Compares toString against a known expected string
         * */
        public void test_ToString() {
            System.out.println("toString test for the Cart class \nInputs: ItemOrder(Item(Test Item, 12.10), 6), ItemOrder(Item(New Item, 12.10), 6 )");
            Cart cart = new Cart();
            cart.add(new ItemOrder(new Item("Test Item", new BigDecimal(12.10)), 6));
            cart.add(new ItemOrder(new Item("New Item", new BigDecimal(12.10)), 6));
            String expected = "[Test Item, $12.10 Quantity: 6] [New Item, $12.10 Quantity: 6]";
            String actual = cart.toString();
            System.out.println("Expected: " + expected);
            System.out.println("Actual: "+actual);
            if(actual.compareTo(expected)==1) {
                System.out.println("Success");
            }
            else {System.out.println("Failure");}
        }
        
        /**
         * A method to test the equals method in the cart class. Creates two identical carts and uses equals to compare the two
         * */
        //Need fixing
        public void test_equals() {
            System.out.println("equals test for the Cart class \nInputs: ItemOrder(Item(Test Item, 12.10), 6), ItemOrder(Item(New Item, 12.10), 6 )");
            Cart cart = new Cart();
            Cart cart2 = new Cart();
            cart.add(new ItemOrder(new Item("Test Item", new BigDecimal(12.10)), 6));
            cart.add(new ItemOrder(new Item("New Item", new BigDecimal(12.10)), 6));
            cart2.add(new ItemOrder(new Item("Test Item", new BigDecimal(12.10)), 6));
            cart2.add(new ItemOrder(new Item("New Item", new BigDecimal(12.10)), 6));
            System.out.println(cart);
            System.out.println(cart2);
            if(cart.equals(cart2)) {
                System.out.println("Success");
            }
            else {System.out.println("Failure");}
            
        }
        
        /**
         * A method to test the hashCode method of the cart class. Compares Objects.hash on the fields against cart.hashCode
         * */
        public void test_hashCode(){
            System.out.println("hashCode test for the Cart class \nInputs: ItemOrder(Item(Test Item, 12.10), 6), ItemOrder(Item(New Item, 12.10), 6 )");
            Cart cart = new Cart();
            cart.add(new ItemOrder(new Item("Test Item", new BigDecimal(12.10)), 6));
            cart.add(new ItemOrder(new Item("New Item", new BigDecimal(12.10)), 6));
            int expected = Objects.hash(cart.getMembershipStatus(),cart.getOrders());
            int actual = cart.hashCode();
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            if(expected == actual) {
                System.out.println("Success");          
            }
            else {System.out.println("Failure");}
            
        }
        
        /**
         * A method to test the compareTo method of the Cart class. Creates two cart objects and compares them using compareTo
         * */
        public void test_compareTo() {
            System.out.println("compareTo test for the Cart class \nInputs: ItemOrder(Item(Test Item, 12.10), 6), ItemOrder(Item(New Item, 12.10), 6 )");
            Cart cart = new Cart();
            Cart cart2 = new Cart();
            cart.add(new ItemOrder(new Item("Test Item", new BigDecimal(12.10)), 6));
            cart.add(new ItemOrder(new Item("Test Item", new BigDecimal(12.10)), 6));
            cart2.add(new ItemOrder(new Item("New Item", new BigDecimal(12.10)), 6));
            cart2.add(new ItemOrder(new Item("New Item", new BigDecimal(12.10)), 6));
            int expected = 1;
            int actual = cart.compareTo(cart2);
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            if(expected == actual) {
                System.out.println("Success");          
            }
            else {System.out.println("Failure");}
            
        }
        
        /**
         * A method to test the compare method of the Cart class. Creates two Cart objects and compares them using Compare
         * */
        public void test_compare() {
            System.out.println("compare test for the Cart class \nInputs: ItemOrder(Item(Test Item, 12.10), 6), ItemOrder(Item(New Item, 12.10), 6 )");
            Cart cart = new Cart();
            Cart cart2 = new Cart();
            cart.add(new ItemOrder(new Item("Test Item", new BigDecimal(12.10)), 6));
            cart.add(new ItemOrder(new Item("Test Item", new BigDecimal(12.10)), 6));
            cart2.add(new ItemOrder(new Item("New Item", new BigDecimal(12.10)), 6));
            cart2.add(new ItemOrder(new Item("New Item", new BigDecimal(12.10)), 6));
            int expected = 1;
            int actual = cart.compare(cart, cart2);
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            if(expected == actual) {
                System.out.println("Success");          
            }
            else {System.out.println("Failure");}
 
        }
        
    }
    
    /**A main class for creating objects and running methods*/
    public static class run {
        /**The main method*/
        public static void main(String[] args) {
            
            Test test = new Test();
            Test.TestItem itemTest = test.new TestItem();
            
            //item methods
            itemTest.test_comapreTo();
            itemTest.test_equals();
            itemTest.test_hashCode();
            itemTest.test_toString();
            itemTest.test_compare();
            System.out.println("");
            
            //itemOrder methods
            Test.TestItemOrder orderTest = test.new TestItemOrder();
            orderTest.test_equals();
            orderTest.test_hashCode();
            orderTest.test_ToString();
            orderTest.testComapreTo();
            System.out.println("");
            
            //cart methods
            Test.TestCart cartTest = test.new TestCart();
            cartTest.test_equals();
            cartTest.test_ToString();
            cartTest.test_compare();
            cartTest.test_compareTo();
            cartTest.test_hashCode();
            
        }
        
    }

}

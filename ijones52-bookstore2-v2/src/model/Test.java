package model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Objects;

public class Test {
    
    public class TestItem{
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
            
       }
        
    
    
    public class TestItemOrder{
        public void test_ToString() {
        }
    }
    
    public class TestCart{
        public void test_ToString() {

        }
    }
    
    public static class run {
        public static void main(String[] args) {
            Test test = new Test();
            Test.TestItem itemTest = test.new TestItem();
            itemTest.test_comapreTo();
            itemTest.test_equals();
            itemTest.test_hashCode();
            itemTest.test_toString();
        }
        
    }

}

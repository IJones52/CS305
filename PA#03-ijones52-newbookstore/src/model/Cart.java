package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

/**
 *The Cart class holds information about all orders, calculates totals, and tracks membership
 *  
 *@author Ismael Jones
 *@version 1/15/20  
 * */

public class Cart implements Comparable, Comparator{
    /**
     * private fields to store order and membership values
     * */
    private ArrayList<ItemOrder> orders = new ArrayList<ItemOrder>();
    private boolean isMember;
    /**
     * Creates an empty shopping cart. Has no parameters and sets no values.    
     * 
     * */
    public Cart() {

    }
    
    /**
     * A method that returns the ItemOrders in the cart
     * 
     * @return the list of ItemOrders
     * */
    public ArrayList<ItemOrder> getOrders() {
        return orders;
    }
    
    /**
     * Add an itemOrder object to the list of orders
     * 
     * @param an itemOrder to add
     * */
    public void add(final ItemOrder theOrder) {
        boolean isHandled = false;
        for(int i =0; i < orders.size(); i++) {
            if(orders.get(i).getItem().equals(theOrder.getItem())) {
                orders.set(i, theOrder);
                isHandled = true;
            }
         
        }
        if(!isHandled) {
            orders.add(theOrder);}
        }
        
    
    /**
     * Sets the membership value of the user
     * 
     * @param the membership value of the user
     * */
    public void setMembership(final boolean theMembership) {
        isMember = theMembership;
        calculateTotal();
    }
    
    /**
     * A method that returns the membership status of the user
     * 
     * @return the membership status
     * */
    public boolean getMembershipStatus() {
        return isMember;
    }
    
    /**
     * A method to calculate the total of all item orders. Checks for bulk pricing availability,
     * if bulk then we add bulk * bulkTotal of the item, then do normal pricing for the remainder.
     * Otherwise we just do normal pricing.
     * 
     * @return a BigDecimal representing the sum of all orders
     * */
    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.valueOf(0);
        for(int i = 0; i < orders.size(); i++) {
         if(orders.get(i).getItem().isBulk() && isMember) {
             if(orders.get(i).getQuantity() >= orders.get(i).getItem().getBulkQuantity()){
                 int bulkQuantity = orders.get(i).getQuantity()/orders.get(i).getItem().getBulkQuantity();
                 int normalQuantity = orders.get(i).getQuantity() % orders.get(i).getItem().getBulkQuantity();
                 
                 total = total.add(orders.get(i).getItem().getBulkPrice().multiply( BigDecimal.valueOf(bulkQuantity)));
                 total = total.add(orders.get(i).getItem().getPrice().multiply( BigDecimal.valueOf(normalQuantity)));
             }
             else {
                 total = total.add(orders.get(i).getItem().getPrice().multiply( BigDecimal.valueOf(orders.get(i).getQuantity())));

             }
         }
         else {
             total = total.add(orders.get(i).getItem().getPrice().multiply( BigDecimal.valueOf(orders.get(i).getQuantity())));
         }
        }
        return total;
    }
    
    /**
     * A method that empties out a cart entirely
     * */
    public void clear() {
       orders = new ArrayList<ItemOrder>();
    }
    
    /**A method that returns the number of item orders in the cart
     * 
     * @return a number representing the cart size
     * */
    public int getCartSize() {
        return orders.size();
    }

    /**
     * A method that creates a list of all the item orders in a readable fashion.
     * 
     * @return a string with all orders
     * */
    @Override
    public String toString() {
        String toString = "";
        //Need to sort based on campus, check for a campus specific item? then sort based on that... Assuming it prints after all items are loaded
        for(int i = 0; i < orders.size(); i++) {
            toString = toString + "[" + orders.get(i).toString() + "] ";
        }
        
        return toString;
    }
    
    /**
     * A method that compares the Cart to another object
     * 
     * @param an object to compare to
     * @return true if the same ItemOrders and membership status, false otherwise
     * */
    @Override 
    public boolean equals(Object other) {
       if(other instanceof Cart) {
           if(((Cart)other).getOrders().size() == orders.size() && ((Cart)other).getMembershipStatus() == isMember) {
               for(int i = 0; i <orders.size(); i ++){
                   if(!(orders.get(i).equals(((Cart)other).getOrders().get(i)))) {
                       return false;
                   }
               }
               return true;
           }
           else {
               return false;
           }
       }
       else {
           return false;
       }
    }
    
    /**
     * A method that generates a hash code for a cart object
     * 
     * @return the hash code
     * 
     * */
    public int hashCode(){
        return Objects.hash(isMember,orders);
    }
    
    
    /**
     * A method that compares two objects
     * 
     * @param the two object to compare
     * @return the result of comparint the p
     * */
    @Override
    public int compare(Object o1, Object o2) {
        if((o1 != null && o1 instanceof Cart) && (o2 != null && o2 instanceof Cart)){
            return ((Cart)o1).compareTo((Cart)o2);
        }
        return 0;
    }
    
    /**
     * A method that compares an object to a cart
     * 
     * @param an object to be compared
     * @return an int between -1 and 1 that refers to the relationship of the object and the int
     * 
     * */

    @Override
    public int compareTo(Object other) {
        if(other != null && other instanceof Cart){
            if(((Cart)other).hashCode() == this.hashCode()) {
                return 0;
            }
            else if(((Cart)other).hashCode() > this.hashCode()) {
                return 1;
            }
            else {
                return -1;
            }
            
        }
        return 0;
    }
}

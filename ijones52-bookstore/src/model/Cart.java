package model;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 *The Cart class holds information about all orders, calculates totals, and tracks membership
 *  
 *@author Ismael Jones
 *@version 1/15/20  
 * */

public class Cart {
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
        for(int i = 0; i < orders.size(); i++) {
            toString = toString + "[" + orders.get(i).toString() + "] ";
        }
        
        return toString;
    }

}

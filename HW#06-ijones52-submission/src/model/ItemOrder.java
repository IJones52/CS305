package model;

import java.util.Objects;

/**
 *  The item order class contains methods to handle ordering multiple objects
 *  
 *   @author Ismael Jones
 *   @version 2/5/20
 * 
 * */

public final class ItemOrder implements Comparable {
    /**
     * 
     * private fields to store the item of the ordrr and its quantity
     * */
    private Item item;
    private int quantity;
    
    /**
     *  Creates a basic item order
     *  
     *  @param theItem, an Item the order should consist of
     *  @param theQuantity, the number of items of that kind  
     * */
    public ItemOrder(final Item theItem, final int theQuantity) {
        item = theItem;
        quantity = theQuantity;
        
 
        
    }

    /**
     *  A method that accesses the type of item for the order
     *  
     *  @return an item object
     * */
    public Item getItem() {
        return item;
    }
    
    /**
     *  A method that accesses the number of items in the order
     *  
     *  @return an int representing the number of items in the order
     * */

    public int getQuantity() {
        return quantity;
    }
    
    /**
     * A method that returns the information about an order of an item
     * 
     * @return a String containing order information
     * */
    @Override
    public String toString() {

        return item.toString() + " Quantity: " + quantity;
    }
    
    /**
     * A method that checks the equality of itemOrders
     * 
     * @param An object to compare against
     * @return true if the same false if not
     * 
     * */
    @Override 
    public boolean equals(Object other) {
        
        if(other != null && other instanceof ItemOrder && ((ItemOrder)other).getItem().equals(item) && ((ItemOrder)other).getQuantity() == quantity) {
            return true;
        }
        return false;
        
    }
    
    /**
     * A method that generates a hash code for the ItemOrder
     * 
     * @return the hash code for the object
     * */
    public int hashCode() {
        return Objects.hash(item,quantity);
        
    }
    
    /**
     * A method that compares an object to an ItemOrder based on hashCodes
     * 
     * @param an object to compare to
     * @return an int between -1 and 1 that refers to what the object is relative to the itemOrder
     * */
    
    @Override
    public int compareTo(Object other) {
        if(other != null && other instanceof ItemOrder) {
            if(((ItemOrder)other).hashCode() == this.hashCode()) {
                return 0;
            }
            else if(((ItemOrder)other).hashCode() > this.hashCode()) {
                return 1;
            }
            else {
                return -1;
            }
            
        }
        return 0;
    }

}

package model;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Item class creates a new object that stores data such as price name and bulk information.
 * 
 * @author Ismael Jones
 * @version 2/5/20
 * */
public final class Item implements Comparable, Comparator {
    /**
     * private fields for all of the parmeters that make up either an item, or an item with bulk discounts
     * 
     * */
    private String name;
    private BigDecimal price;
    private boolean isBulk = false;
    private int bulkQuantity;
    private BigDecimal bulkPrice;
    /**
     * Creates a new Item object
     * 
     * @param theName, a name for the item
     * @param thePrice, a price for the item
     * 
     * */
    public Item(final String theName, final BigDecimal thePrice) {
        name = theName;
        price = thePrice;
    }

    /**
     * Creates a new Item object with bulk quantities
     * 
     * @param theName, a name for the item
     * @param thePrice, a price for the item
     * @param theBulkQuantity, the quantity required to be bought in bulk
     * @param theBulkPrice, the price for the item in bulk
     * 
     * */
    public Item(final String theName, final BigDecimal thePrice, final int theBulkQuantity,
                final BigDecimal theBulkPrice) {
        name = theName;
        price = thePrice;
        isBulk = true;
        bulkQuantity = theBulkQuantity;
        bulkPrice = theBulkPrice;
    }
    /**
     * A method that accesses the name of an item
     * 
     * @return the name of the item
     * */
    public String getName() {
        return name;    
    }
    /**
     * A method that returns a price of an item.
     * 
     * @return the price of the item object
     * */
    public BigDecimal getPrice() {
        return price;
    }
       
    /**
     * A method that returns the quantity required to be bulk
     * 
     * @return the bulk quantity
     * */
    public int getBulkQuantity() {
        return bulkQuantity;
    }

    /**
     * A method that returns the price of an item when bulk
     * 
     * @return the bulk price
     * */
    public BigDecimal getBulkPrice() {
        return bulkPrice;
    }

    /**
     * A method that tells if the item has bulk options available.
     * 
     * @return true if bulk and false if not
     * */
    public boolean isBulk() {
        return isBulk;
    }

    /**
     * A method that returns some of the data held in the item object
     * 
     * @return a string containing the name, price of an item, and bulk information
     * */
    @Override
    public String toString() {
        NumberFormat nf =  NumberFormat.getCurrencyInstance(Locale.US);
        if(!isBulk) {
        return name + ", " +  nf.format(price);
        }
        else {
            return name + ", " + nf.format(price) + " (" + bulkQuantity + " for " + nf.format(bulkPrice) + ")";
        }
    }
    /**
     * A method that checks if an item is equal to another
     * 
     * @param item, an item object to compare to
     * @return the truth value pertaining to item equality
     * */
    @Override
    public boolean equals(Object item) {
        if(item != null && item instanceof Item && name.equals(((Item) item).getName()) && price.equals(((Item) item).getPrice())&& bulkQuantity == ((Item) item).getBulkQuantity() && bulkPrice == ((Item)item).getBulkPrice()){
            return true;
        }
        else {return false;}
    }
    
    /**
     * A method that returns a unique hash code for an item object
     * 
     * @return the hash code
     * */
    @Override
    public int hashCode() {

        return Objects.hash(name,price,bulkQuantity, bulkPrice);
    }
    
    /**
     * A method that compares an object to an the Item. Checks if the object is an item first.
     * 
     * @param an object to compare to
     * @return a number -1, 0, or 1 that refers to what the item is relative to the other object.
     * */
    public int compareTo(Object other) {
        
        if(other != null && other instanceof Item) {
            if(((Item) other).getName().replace("\'", "").toLowerCase().charAt(0) == name.toLowerCase().charAt(0)) {
                return 0;
            }
            else if(((Item) other).getName().replace("\'", "").toLowerCase().charAt(0) > name.toLowerCase().charAt(0)) {
                return 1;
            }
            else {
                return -1;
            }
        }
        return 0;    
    }
    
    /**
     * The compare method for the item class. Compares two objects, will make the comparison if they are both items.
     * @param two objects to compare
     * @return a number -1, 0, or 1 that refers to what the object is relative to the other.
     * */
    @Override
    public int compare(Object o1, Object o2) {
        if((o1 != null && o1 instanceof Item) && (o2 != null && o2 instanceof Item)){
            return ((Item)o1).compareTo((Item)o2);
        }
        return 0;
    }

}

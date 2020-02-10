package main;

import java.util.Date;

public class Battery implements Cloneable {
	
	/**The fields for the battery class*/
	private int batteryNumber;
	private String manufacturer;
	private Date expiration;
	
	
	/**
	 * The constructor for creating a new battery. Sets the fields to the given values
	 * 
	 * @param a identifying number for the battery
	 * @param the company that manufactured the battery
	 * @param the date the battery expires
	 * */
	public Battery(int number, String company, Date expires) {
		batteryNumber = number;
		manufacturer = company;
		expiration = expires;
	}
	
	/**
	 * A method to access the battery's identifier number
	 * 
	 * @return the battery's identifier number
	 * */
	public int getNumber() {
		return batteryNumber;
	}
	
	/**
	 * A method to access the battery's manufacturer
	 * 
	 * @return the company that manufactured the battery
	 * 
	 * */
	public String getManufacturer() {
		return manufacturer;
	}
	
	/**
	 * A method to access the battery's expiration date
	 * 
	 * @return the date the battery expires
	 * */
	public Date getExpiration() {
		return expiration;
	}
	
	/**
	 * A method that allows a user to set the expiration date of the battery
	 * 
	 * @param The desired expiration date.
	 * 
	 * */
	public void setExpiration(Date date) {
		expiration = date;
	}
	
	/**
	 *A method that allows a user to set the manufacturer of the battery
	 * */
	public void setCompany(String company) {
		manufacturer = company;
	}
	
	/**
	 * A method that overrides the object's toString() function and gives a string containing the battery's info.
	 * 
	 * @return a string of the form Battery (number)  Manufacutrer: (comapny) Expires: (Date)
	 * 
	 * */

	@Override
	public String toString() {
		return "Battery "+batteryNumber + " Manuafacturer: " + manufacturer + " Expires: " + expiration; 
	}
	
	/**
	 * A method that does deep copying on a battery object.
	 * 
	 * @exception CloneNotSupportedException
	 * @return a deep copy of the Battery object
	 * */
	
	public Battery clone() {
		try {
			Battery clone = (Battery) super.clone();
			clone.setExpiration((Date) expiration.clone()); 
			return clone;
		}
		catch (CloneNotSupportedException e) {return null;}
	}	
}

package main;

import java.util.Arrays;

public class Toy implements Cloneable {
	/**Fields for the Toy class*/
	private String name;
	private Battery[] batteries;
	
	/**
	 * The constructor for the toy class.
	 * 
	 * @param A name for the toy
	 * @param An array of batteries
	 * */
	public Toy(String toyName, Battery[] batteryArr){
		name = toyName;
		batteries = batteryArr;
	}
	
	/**
	 * A method that returns a toy's name
	 * 
	 * @return the name of the toy
	 * */
	public String getName() {
		return name;
	}
	
	/**
	 * A method that returns an array of the toy's batteries
	 * 
	 * @return the array of batteries
	 * */
	public Battery[] getBatteries() {
		return batteries;
	}
	
	/**
	 * A method that set the array of batteries to a give array
	 * 
	 * @param the array of batteries to set to the toy
	 * */
	public void setBatteries(Battery[] bats) {
		batteries = bats;
		
	}
	
	/**
	 * A method that makes a string representation of a toy, including its battery status.
	 * 
	 * @return the name of the toy, and information on all of the batteries within the toy.
	 * */
	@Override
	public String toString() {
		String value = name + "\nBattery Info\n";
		for(int i = 0; i < batteries.length; i++) {
			value = value + batteries[i].toString() + "\n";
		}
		return value;
	} 
	
	/**
	 * A method that makes a deep copy of a toy and all of its batteries
	 * 
	 * @return a toy object
	 * */
	
	public Toy clone() {
		try {
			Toy clone = (Toy) super.clone();			
			clone.batteries = batteries.clone();
			return clone;
			
		}
		catch(CloneNotSupportedException e) {
			return null;
		}
		
	}
}

package main;

public class Toy {
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
	 * A method that makes a string representation of a toy, including its battery status.
	 * 
	 * @return the name of the toy, and information on all of the batteries within the toy.
	 * */
	public String toString() {
		String value = name + "\nBattery Info\n";
		for(int i = 0; i < batteries.length; i++) {
			value = value + batteries[i].toString() + "\n";
		}
		return value;
	} 
}

package test;
import main.Battery;
import main.Toy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class TestClass {
	
	/**
	 * A method that tests the deep copying of a battery object
	 * */
	@Test
	void batteryCloneTest() {
		long time = System.currentTimeMillis() - 1000;
		Battery bat = new Battery(01234, "Buh", new Date(time));
		Battery clone = bat.clone();
		clone.setCompany("Duh");
		long newTime = System.currentTimeMillis();
		clone.setExpiration(new Date(newTime));
		System.out.println("The Clone's Expiration date: " + clone.getExpiration() + " The expected date: " + new Date(newTime) );
		System.out.println("The Battery's Expiration date: "+bat.getExpiration() + " The expected date: " + new Date(time) );
		assertEquals(bat.getExpiration(), new Date(time));
		assertFalse(bat.getExpiration() == clone.getExpiration());
	}
	
	@Test
	void toyCloneTest(){
		long time = System.currentTimeMillis() - 1000;
		Battery bat = new Battery(01230, "Buh", new Date(time));
		Battery bat2 = new Battery(01231, "Buh", new Date(time));
		Battery bat3 = new Battery(01232, "Buh", new Date(time));
		Battery bat4 = new Battery(01233, "Buh", new Date(time));
		Battery[] batteries = {bat, bat2,bat3,bat4};
		Toy toy = new Toy("Toy", batteries);
		Toy clone = toy.clone();
		clone.setName("New Toy");
		long newTime = System.currentTimeMillis() - 2000;
		for(int i = 0; i < clone.getBatteries().length; i ++) {
			clone.getBatteries()[i].setExpiration(new Date(newTime));
			clone.getBatteries()[i].setCompany("Duh");
		}
	
		System.out.println("The Clone's Batteries Expiration Dates: \n" + clone.toString() + "\nThe Expected Expiration Date: " + new Date(newTime) + "\nThe expected batttery name: Duh" + "\nThe name of the toy: " + clone.getName());
		System.out.println("The Toy's Batteries Expiration Dates: \n" + toy.toString() + "\nThe Expected Expiration Date: " + new Date(time) + "\nThe expected battery name: Buh" + "\nThe name of the toy: " + toy.getName());
		
		assertEquals(toy.getBatteries()[0].getExpiration(), new Date(time));
		assertFalse(toy.getBatteries()[0].getExpiration() == clone.getBatteries()[0].getExpiration());
		
	
	}

}

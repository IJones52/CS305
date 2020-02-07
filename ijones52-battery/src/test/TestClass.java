package test;
import main.Battery;
import main.Toy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

class TestClass {
	
	@Test
	void batteryCloneTest() {
		long time = System.currentTimeMillis();
		Battery bat = new Battery(01234, "Buh", new Date(time));
		Battery clone = bat.clone();
		clone.setCompany("Duh");
		clone.setExpiration(new Date());
		assertEquals(bat.getExpiration(), new Date(time));
		assertFalse(bat.getExpiration() == clone.getExpiration());
	}
	
	@Test
	void toyCloneTest(){
		long time = System.currentTimeMillis();
		Battery bat = new Battery(01230, "Buh", new Date(time));
		Battery bat2 = new Battery(01231, "Buh", new Date(time));
		Battery bat3 = new Battery(01232, "Buh", new Date(time));
		Battery bat4 = new Battery(01233, "Buh", new Date(time));
		Battery[] batteries = {bat, bat2,bat3,bat4};
		Toy toy = new Toy("Toy", batteries);
		Toy clone = toy.clone();
		
		for(int i = 0; i < clone.getBatteries().length; i ++) {
			clone.getBatteries()[i].setExpiration(new Date());
		}
		System.out.println(toy.getBatteries()[0].getExpiration());
		System.out.println(new Date());
		System.out.println(clone.getBatteries()[0].getExpiration());
		
		assertEquals(toy.getBatteries()[0].getExpiration(), new Date(time));
		//assertFalse(toy.getBatteries()[0].getExpiration() == clone.getBatteries()[0].getExpiration());
		
	
	}

}

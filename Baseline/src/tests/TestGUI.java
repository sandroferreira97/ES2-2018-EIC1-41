package tests;

import optimizationOnDemand.Gui;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestGUI {
	
	@Test
	public void testGetQuantity() {
		
		Gui.getQuantity();
					
	}
	
	@Test
	public void testGetMinRange() {
		
		Gui.getMinRange();
					
	}
	
	@Test
	public void testGetMaxRange() {
		
		Gui.getMaxRange();
					
	}
	
	@Test
	public void testGetPath() {
		
		Gui subjects = new Gui();
	
		subjects.getPath();
					
	}
	
}

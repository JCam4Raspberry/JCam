package org.raspberry.jcam4rasp.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ExposureModeTest {
	
	private ExposureMode testobj;
	
	@Before
	public void before(){
		testobj = new ExposureMode();
	}

	@Test
	public void testDefault() {
		String expected = " --exposure off ";
		
		assertTrue(expected.equals(testobj.toString()));
	}
	
	@Test
	public void testSportsMode(){
		//given 
		String expected = " --exposure sports ";
		//when
		testobj.setMode(testobj.EXPOSURE_MODE_SPORTS);
		
		assertTrue(expected.equals(testobj.toString()));
	}

}

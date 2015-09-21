package org.raspberry.jcam4rasp.entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CamSettingsTest {
	
	private String FILENAME = "test.jpg";
	private CamSettings testObj;
	
	@Before
	public void before() {
		testObj = new CamSettings(FILENAME);
	}

	@Test
	public void testCommand() {
		//given
		String expected = "raspistill -o test.jpg --encoding jpg --exposure sports --timeout 1 --nopreview --rotation 90";

		//when
		testObj.setRotation(90);
		testObj.setEncoding("jpg");
		testObj.setExposureMode(new ExposureMode(ExposureMode.EXPOSURE_MODE_SPORTS));
		testObj.setTimeout(1);
		
		//then
		assertTrue(expected.equals(testObj.toString()));
	}

}

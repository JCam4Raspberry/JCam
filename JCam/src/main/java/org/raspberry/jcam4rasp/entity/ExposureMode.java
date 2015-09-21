package org.raspberry.jcam4rasp.entity;

public class ExposureMode {
	
	//Settings for exposure mode
	public String EXPOSURE_MODE_OFF = "off";
	public String EXPOSURE_MODE_AUTO = "auto";
	public String EXPOSURE_MODE_NIGHT = "night";
	public String EXPOSURE_MODE_NIGHT_PREVIEW = "nightpreview";
	public String EXPOSURE_MODE_BACKLIGHT = "backlight";
	public String EXPOSURE_MODE_SPOTLIGHT = "spotlight";
	public String EXPOSURE_MODE_SPORTS = "sports";
	public String EXPOSURE_MODE_SNOW = "snow";
	public String EXPOSURE_MODE_BEACH = "beach";
	public String EXPOSURE_MODE_VERY_LONG = "verylong";
	public String EXPOSURE_MODE_FIXED_FPS = "fixedfps";
	public String EXPOSURE_MODE_ANTI_SHAKE = "antishake ";
	public String EXPOSURE_MODE_FIREWORKS = "fireworks";

	//value of the selected mode - default is "off"
	String mode = "off";
	
	/**
	 * Creates an instance with set mode. Please use the prepared
	 * exposure mode strings. 
	 */
	public ExposureMode(String mode) {
		this.mode = mode;
	}
	
	/**
	 * Creates an instance with default mode "off"
	 */
	public ExposureMode() {
		//default mode
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
    public String toString() {
		return " --exposure " + mode + " ";
    }
	
	
}

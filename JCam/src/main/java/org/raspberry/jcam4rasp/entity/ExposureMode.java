package org.raspberry.jcam4rasp.entity;

public class ExposureMode {
	
	//Settings for exposure mode
	public static final String EXPOSURE_MODE_OFF = "off";
	public static final String EXPOSURE_MODE_AUTO = "auto";
	public static final String EXPOSURE_MODE_NIGHT = "night";
	public static final String EXPOSURE_MODE_NIGHT_PREVIEW = "nightpreview";
	public static final String EXPOSURE_MODE_BACKLIGHT = "backlight";
	public static final String EXPOSURE_MODE_SPOTLIGHT = "spotlight";
	public static final String EXPOSURE_MODE_SPORTS = "sports";
	public static final String EXPOSURE_MODE_SNOW = "snow";
	public static final String EXPOSURE_MODE_BEACH = "beach";
	public static final String EXPOSURE_MODE_VERY_LONG = "verylong";
	public static final String EXPOSURE_MODE_FIXED_FPS = "fixedfps";
	public static final String EXPOSURE_MODE_ANTI_SHAKE = "antishake";
	public static final String EXPOSURE_MODE_FIREWORKS = "fireworks";

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
		return " --exposure " + mode;
    }
	
	
}

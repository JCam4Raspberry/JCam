package org.raspberry.jcam4rasp.entity;
/**
 * This class holds the configuration for the raspberry camera. The settings
 * will create the string that can be used to create the raspistill command
 * for the command line. 
 *
 */
public class CamSettings {
	
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

	//image height
	private int height;
	//image width
	private int width;
	//quality in range [0 , 100]
	private int quality = 100;
	//encoding jpg, bmp, gif, png
	private String encoding = "jpg";
	//set preview on video output
	private boolean fullPreview;
	//selects the camera - default is 0
	private String camselect = "0";
	//camera mode - toString() returns raspistill command
	private ExposureMode exposureMode;
	
}

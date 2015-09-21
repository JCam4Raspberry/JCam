package org.raspberry.jcam4rasp.entity;
/**
 * This class holds the configuration for the raspberry camera. The settings
 * will create the string that can be used to create the raspistill command
 * for the command line. 
 *
 */
public class CamSettings {

	//image height
	private int height = -1;
	//image width
	private int width = -1;
	//quality in range [0 , 100]
	private int quality = 100;
	//encoding jpg, bmp, gif, png
	private String encoding = "jpg";
	//set preview on video output
	private boolean preview;
	//selects the camera - default is 0
	private String camselect = "0";
	//camera mode - toString() returns raspistill command
	private ExposureMode exposureMode;
	
	private String fileName;
	
	//private constructor
	private CamSettings() {

	}
	
	public CamSettings(String filename) {
		this.fileName = filename;
	}
	
	@Override
    public String toString() {
		StringBuilder builder = new StringBuilder(50);
		builder.append("raspistill -o ").append(fileName).append('.').append(this.encoding);
		
		//exposure mode
		builder.append(exposureMode.toString());
		
		//preview
		if (!preview){
			builder.append(" --nopreview");
		}
		
		
		return builder.toString();
    }
}

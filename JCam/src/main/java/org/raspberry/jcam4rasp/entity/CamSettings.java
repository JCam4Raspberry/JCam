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
	//file name of image
	private String fileName;
	//set image rotation
	private int rotation = 0;
	//set waiting time - it 0 process will run forever
	private int timeout = 1;

	public CamSettings(String filename) {
		this.fileName = filename;
	}
	
	@Override
    public String toString() {
		StringBuilder builder = new StringBuilder(50);
		
		builder.append("raspistill -o ").append(fileName);
		builder.append(" --encoding ").append(this.encoding);
		
		//exposure mode
		builder.append(exposureMode.toString());
		
		//timeout
		builder.append(" --timeout ").append(this.timeout);
		
		//preview
		if (!preview){
			builder.append(" --nopreview");
		}
		
		if (rotation != 0) {
			builder.append(" --rotation ").append(this.rotation);
		}
		
		return builder.toString();
    }

	public void setHeight(int height) {
		this.height = height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

	public void setPreview(boolean preview) {
		this.preview = preview;
	}

	public void setCamselect(String camselect) {
		this.camselect = camselect;
	}

	public void setExposureMode(ExposureMode exposureMode) {
		this.exposureMode = exposureMode;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}
	
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
}

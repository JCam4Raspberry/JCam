package org.raspberry.jcam4rasp;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.raspberry.jcam4rasp.entity.CamSettings;
import org.raspberry.jcam4rasp.entity.ExposureMode;

public class CameraStreamer {
	
	private CamSettings settings;

	public static void getImage(OutputStream stream) {
	    System.out.println("START PROGRAM");
	    
	    long start = System.currentTimeMillis();
	    try
	    {
	      Process p = Runtime.getRuntime().exec("raspistil -w 100 -h 100 -n -t 10000 -o -");
	      BufferedInputStream bis = new BufferedInputStream(p.getInputStream());
	      //Direct methode p.getInputStream().read() also possible, but BufferedInputStream gives 0,5-1s better performance

	      System.out.println("start writing");
	      int read = bis.read();
	      stream.write(read);

	      while (read != -1)
	      {
	        read = bis.read();
	        stream.write(read);
	      }
	      System.out.println("end writing");
	      bis.close();
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	    
	    
	    System.out.println("END PROGRAM");
	    System.out.println("Duration in ms: " + (System.currentTimeMillis() - start));
	}
	
	public void getImageAsBufferedImageFromFile(OutputStream stream) {
		
		System.out.println("START");

		long start = System.currentTimeMillis();

		try {
			Process p = Runtime.getRuntime().exec("raspistill -rot 90 -t 1 -n -ex sports -o -");

			BufferedInputStream bis = new BufferedInputStream(p.getInputStream());

			File file = File.createTempFile("jcam", ".jpg");

			OutputStream fos = new FileOutputStream(file);

			System.out.println("start writing file");
			int read = bis.read();
			fos.write(read);

			while (read != -1) {
				read = bis.read();
				fos.write(read);
			}
			
			System.out.println("end writing file");
			bis.close();
			fos.close();
			
			System.out.println("file exists? " + file.exists());
			System.out.println("temp file: " + file.getAbsolutePath());

			BufferedImage img = ImageIO.read(new FileInputStream(file));
			ImageIO.write(img, "jpg", stream);

		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("END");
		System.out.println("Duration in ms: " + (System.currentTimeMillis() - start));
	}
	
	public void getImageAsBufferedImage(OutputStream stream) {

		long start = System.currentTimeMillis();

		try {
			Process p = Runtime.getRuntime().exec("raspistill -rot 90 -t 1 -n -ex sports -o -");

			BufferedImage img = ImageIO.read(p.getInputStream());
			ImageIO.write(img, "jpg", stream);

		} catch (Exception e) {
			System.out.println(e);
		}

		System.out.println("Duration in ms: " + (System.currentTimeMillis() - start));
	}
	
	public void getImageAsBufferedImageWithBetterFrameRate(OutputStream stream) {
		
		try {
			File file = File.createTempFile(Long.toString(System.currentTimeMillis()), ".jpg");
			
			long start = System.currentTimeMillis();
			
			Process p = Runtime.getRuntime().exec(getDefaultSettings(file.getAbsolutePath()).toString());
			p.waitFor();
			
			System.out.println("Process finished in ms: " + (System.currentTimeMillis() - start));
			
			start = System.currentTimeMillis();
			
			BufferedImage img = ImageIO.read(file);
			ImageIO.write(img, "jpg", stream);
			
			System.out.println("File opening time in ms: " + (System.currentTimeMillis() - start));

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private CamSettings getDefaultSettings(String filename) {
	    settings = new CamSettings(filename);
	    settings.setRotation(90);
	    settings.setPreview(false);
	    settings.setEncoding("jpg");
	    settings.setExposureMode(new ExposureMode(ExposureMode.EXPOSURE_MODE_NIGHT));
	    
	    return settings;
    }
}

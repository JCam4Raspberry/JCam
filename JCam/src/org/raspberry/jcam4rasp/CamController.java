package org.raspberry.jcam4rasp;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CamController {

	@RequestMapping(value = "/welcome")
	public ModelAndView helloWorld(HttpServletResponse response) {

		String message = "<br><div style='text-align:center;'>"
		        + "<h3>********** Hello World, Spring MVC Tutorial</h3>This message is coming from CrunchifyHelloWorld.java **********</div><br><br>";
		return new ModelAndView("welcome", "message", message);
	}

	@RequestMapping(value = "/cam", method = RequestMethod.GET)
	public void getCamPicture(HttpServletResponse response) throws Exception {

		response.setContentType("image/jpg");

		// version 1
		// CameraStreamer.getImage(stream);

		// version 2 - load from disk for test case
		// BufferedImage img = ImageIO.read(getClass().getResourceAsStream("test2.jpg"));
		// ImageIO.write(img, "jpg", response.getOutputStream());

		// version 3 - saves image in temp file
		// new CameraStreamer().getImageAsBufferedImageFromFile(response.getOutputStream());

		// new CameraStreamer().getImageAsBufferedImage(response.getOutputStream());

		new CameraStreamer().getImageAsBufferedImageWithBetterFrameRate(response.getOutputStream());
	}
	
	@RequestMapping(value = "/image.jpg", method = RequestMethod.GET)
	public void getCamPictureAsImage(HttpServletResponse response) throws Exception {

		response.setContentType("image/jpg");
		new CameraStreamer().getImageAsBufferedImageWithBetterFrameRate(response.getOutputStream());
	}
}

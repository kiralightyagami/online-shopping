package net.sg.onlineshopping.util;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import net.sg.onlineshopping.controller.ManagementController;

public class FileUploadUtility {
    //replace all forward slash in path to either double slash or backward slash for escape sequences
	private static final String ABS_PATH="C:\\Users\\shefali\\git\\online-shopping_00\\onlineshopping\\src\\main\\webapp\\assests\\images";
	private static String REAL_PATH="";
	private static final Logger logger=LoggerFactory.getLogger(FileUploadUtility.class);
	public static void uploadfile(HttpServletRequest request, MultipartFile file, String code) {
	//get a real path is where the servlet tomcat has deployed our application
		REAL_PATH=request.getSession().getServletContext().getRealPath("/assests/images/");
		logger.info(REAL_PATH);
		//to make sure all directories exist if not then create directories
		
		
	}
	
}

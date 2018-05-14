package net.sg.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

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
		if(!new File(ABS_PATH).exists())
		{
			//create the dir
			new File(ABS_PATH).mkdirs();
		}
		if(!new File(REAL_PATH).exists())
		{
			//create the dir
			new File(REAL_PATH).mkdirs();
		}
		
		try {
			
			//server upload
			file.transferTo(new File(REAL_PATH+code+".jpg"));
			//project dir upload
			file.transferTo(new File(ABS_PATH+code+".jpg"));
		}catch(IOException ex)
		{
			
			
		}
		
		
	}
	
}

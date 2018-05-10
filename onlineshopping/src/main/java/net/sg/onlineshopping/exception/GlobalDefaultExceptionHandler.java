package net.sg.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException()
	{
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle", "The page is not contructed");
		mv.addObject("errorDescription", "The page your are accessing is not contructed");
		mv.addObject("title", "404 Error Page");
		
		
		return mv;
		
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException()
	{
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle", "Product Not available");
		mv.addObject("errorDescription", "The product you are looking for is not available");
		mv.addObject("title", "Prduct available");
		
		
		return mv;
		
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex)
	{
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("errorTitle", "Contact your Admin");
		
		//only for debuuger
		
		StringWriter sw=new StringWriter();
		PrintWriter pw=new PrintWriter(sw);
		ex.printStackTrace(pw);
		mv.addObject("errorDescription",sw.toString());
		mv.addObject("title", "Error!");
		
		
		return mv;
		
	}
}

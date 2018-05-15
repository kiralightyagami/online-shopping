package net.sg.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.sg.onlineshopping.util.FileUploadUtility;
import net.sg.onlineshopping.validator.ProductValidator;
import net.sg.shoppingbackend.dao.CategoryDAO;
import net.sg.shoppingbackend.dao.ProductDAO;
import net.sg.shoppingbackend.dto.Category;
import net.sg.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	private static final Logger logger=LoggerFactory.getLogger(ManagementController.class);
	@RequestMapping(value="/products" ,method=RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name="operation", required=false) String operation) {
		ModelAndView mv=new ModelAndView("page");
		
		mv.addObject("userClickManageProduct", true);
		mv.addObject("title", "Manage Products");
		Product nProduct=new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mv.addObject("product", nProduct);
		if(operation!=null)
		{
			if(operation.equals("product"))
			{
				mv.addObject("message", "Product submitted successfully");
			}
		}
		
		
		return mv;
	}
	@RequestMapping(value="/{id}/product" ,method=RequestMethod.GET)
	public ModelAndView showEditProduct(@PathVariable int id) {
		ModelAndView mv=new ModelAndView("page");
		
		mv.addObject("userClickManageProduct", true);
		mv.addObject("title", "Manage Products");
		//fetch the product from db
		Product nProduct=productDAO.get(id);
		//set the product fetched from db
		mv.addObject("product", nProduct);
		
		
		
		return mv;
	}
	
	
	
	//handling product submission
	@RequestMapping(value="/products" ,method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct,BindingResult results,Model model,
			HttpServletRequest request) {
		
		if(mProduct.getId()==0) {
		//handle image validation for new product
		new ProductValidator().validate(mProduct, results);
		}
		else
		{
			//validate only if there is an image for product
			if(!mProduct.getFile().getOriginalFilename().equals(""))
			{
				new ProductValidator().validate(mProduct, results);	
			}
		}
		//check if there are any errors
		if(results.hasErrors())
		{
			model.addAttribute("userClickManageProduct", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failded for product submission");
			return "page";
		}
		logger.info(mProduct.toString());
		
		//check for update or add
		if(mProduct.getId()==0) {
			//create a new record if id=0
		productDAO.add(mProduct);
		}
		else
		{
			//else just update the product if id is not 0
			productDAO.update(mProduct);
		}
		
		//check whether there is file or not
		if(!mProduct.getFile().getOriginalFilename().equals(""))
		{
			FileUploadUtility.uploadfile(request,mProduct.getFile(),mProduct.getCode());
		}
		return "redirect:/manage/products?operation=product";
	}
	//actiavtion of product
	@RequestMapping(value="/product/{id}/activation", method=RequestMethod.POST)
	@ResponseBody
	public String handleProductActivation(@PathVariable int id)
	{
		//fetch product from database
		
		Product product=productDAO.get(id);
		boolean isActive=product.isActive();
		
		product.setActive(!product.isActive());
		
		productDAO.update(product);
		
		return (isActive)?"You have successfully deactivated the product"+product.getId():"You have successfully activated the product"+product.getId();
	}
	//returning categories for all requests
	@ModelAttribute("categories")
	public List<Category> getCategory()
	{
		return categoryDAO.list();
	}
	
	
	
}

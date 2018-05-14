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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//handling product submission
	@RequestMapping(value="/products" ,method=RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct,BindingResult results,Model model,
			HttpServletRequest request) {
		//call the validator
		
		new ProductValidator().validate(mProduct, results);
		//check if there are any errors
		
		if(results.hasErrors())
		{
			model.addAttribute("userClickManageProduct", true);
			model.addAttribute("title", "Manage Products");
			model.addAttribute("message", "Validation failded for product submission");
			return "page";
		}
		logger.info(mProduct.toString());
		productDAO.add(mProduct);
		
		//check whether there is file or not
		if(!mProduct.getFile().getOriginalFilename().equals(""))
		{
			FileUploadUtility.uploadfile(request,mProduct.getFile(),mProduct.getCode());
		}
		return "redirect:/manage/products?operation=product";
	}
	//returning categories for all requests
	@ModelAttribute("categories")
	public List<Category> getCategory()
	{
		return categoryDAO.list();
	}
}

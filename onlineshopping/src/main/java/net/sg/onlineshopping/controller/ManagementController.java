package net.sg.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.sg.shoppingbackend.dao.CategoryDAO;
import net.sg.shoppingbackend.dto.Category;
import net.sg.shoppingbackend.dto.Product;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;
	@RequestMapping(value="/products" ,method=RequestMethod.GET)
	public ModelAndView showManageProducts() {
		ModelAndView mv=new ModelAndView("page");
		
		mv.addObject("userClickManageProduct", true);
		mv.addObject("title", "Manage Products");
		Product nProduct=new Product();
		nProduct.setSupplierId(1);
		nProduct.setActive(true);
		mv.addObject("product", nProduct);
		
		
		return mv;
	}
	//returning categories for all requests
	@ModelAttribute("categories")
	public List<Category> getCategory()
	{
		return categoryDAO.list();
	}
}

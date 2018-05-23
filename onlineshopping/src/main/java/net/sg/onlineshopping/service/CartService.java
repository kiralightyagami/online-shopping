package net.sg.onlineshopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sg.onlineshopping.model.UserModel;
import net.sg.shoppingbackend.dao.CartLineDAO;
import net.sg.shoppingbackend.dto.Cart;
import net.sg.shoppingbackend.dto.CartLine;

@Service("cartService")
public class CartService {
	
	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private HttpSession session;
	
	//returns cart of user who has logged in
	private Cart getCart()
	{
		return ((UserModel)session.getAttribute("userModel")).getCart();
	}
	//returns the entire cart lines
	public List<CartLine> getCartLines()
	{
		Cart cart=this.getCart();
		return cartLineDAO.list(cart.getId());
		
	}

}

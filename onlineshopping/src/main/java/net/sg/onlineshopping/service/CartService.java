package net.sg.onlineshopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.sg.onlineshopping.model.UserModel;
import net.sg.shoppingbackend.dao.CartLineDAO;
import net.sg.shoppingbackend.dao.ProductDAO;
import net.sg.shoppingbackend.dto.Cart;
import net.sg.shoppingbackend.dto.CartLine;
import net.sg.shoppingbackend.dto.Product;

@Service("cartService")
public class CartService {
	
	@Autowired
	private CartLineDAO cartLineDAO;
	@Autowired
	private ProductDAO productDAO;
	
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
	public String updateCartLine(int cartLineId, int count) {
		CartLine cartLine=cartLineDAO.get(cartLineId);
		if(cartLine==null)
		{
			return "result=error";
		}
		else
		{
			Product product=cartLine.getProduct();
			double oldTotal=cartLine.getTotal();
			if(product.getQuantity()<=count)
				count=product.getQuantity();
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(count*product.getUnitPrice());
			cartLineDAO.update(cartLine);
			Cart cart=this.getCart();
			cart.setGrandTotal(cart.getGrandTotal()-oldTotal+cartLine.getTotal());
			cartLineDAO.updateCart(cart);
			return "result=updated";
		}
		
	}
	public String deleteCartLine(int cartLineId) {
		CartLine cartLine=cartLineDAO.get(cartLineId);
		if(cartLine==null)
		{
			return "result=error";
		}
		else
		{
			//update the cart
			Cart cart=this.getCart();
			cart.setGrandTotal(cart.getGrandTotal()-cartLine.getTotal());
			cart.setCartLines(cart.getCartLines()-1);
			cartLineDAO.updateCart(cart);
			//remove the cartLine
			cartLineDAO.delete(cartLine);
			return "result=deleted";
		}
		
	}
	public String addCartLine(int productId) {
		String response=null;
		
		Cart cart=this.getCart();
		CartLine cartLine=cartLineDAO.getByCartAndProduct(cart.getId(), productId);
		if(cartLine==null)
		{
			//add a new cartLine
			cartLine=new CartLine();
			//fetch the product
			Product product=productDAO.get(productId);
			cartLine.setCartId(cart.getId());
			cartLine.setProduct(product);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setProductCount(1);
			cartLine.setTotal(product.getUnitPrice());
			cartLine.setAvailable(true);
           cartLineDAO.add(cartLine);
           
           //update cart
           cart.setCartLines(cart.getCartLines()+1);
           cart.setGrandTotal(cart.getGrandTotal()+cartLine.getTotal());
           cartLineDAO.updateCart(cart);
           response="result=added";
		}
		return response;
	}

}

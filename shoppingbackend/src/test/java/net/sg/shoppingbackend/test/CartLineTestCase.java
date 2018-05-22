package net.sg.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.sg.shoppingbackend.dao.CartLineDAO;
import net.sg.shoppingbackend.dao.ProductDAO;
import net.sg.shoppingbackend.dao.UserDAO;
import net.sg.shoppingbackend.dto.Cart;
import net.sg.shoppingbackend.dto.CartLine;
import net.sg.shoppingbackend.dto.Product;
import net.sg.shoppingbackend.dto.User;



public class CartLineTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CartLineDAO cartLineDAO=null;
	private CartLine cartLine=null;
	private static ProductDAO productDAO=null;
	private static UserDAO userDAO=null;
	private Product product=null;
	private User user=null;
	private Cart cart=null;
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("net.sg.shoppingbackend");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
		userDAO=(UserDAO)context.getBean("userDAO");
		cartLineDAO=(CartLineDAO)context.getBean("cartLineDAO");
	}
	@Test
	public void testAddNewCartLine()
	{
		user=userDAO.getByEmail("rj@gmail.com");
		cart=user.getCart();
		product=productDAO.get(1);
		
		cartLine=new CartLine();
		cartLine.setBuyingPrice(product.getUnitPrice()+1);
		cartLine.setTotal(cartLine.getProductCount()*product.getUnitPrice());
		cartLine.setAvailable(true);
       cartLine.setCartId(cart.getId());
       cartLine.setProduct(product);
       
       assertEquals("failed to add cartLine",true,cartLineDAO.add(cartLine));
       //update cart
		cart.setGrandTotal(cart.getGrandTotal()+cartLine.getTotal());
		cart.setCartLines(cart.getCartLines()+1);
		assertEquals("failed to update cartLine",true,cartLineDAO.updateCart(cart));
		
	}
	
}

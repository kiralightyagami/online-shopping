package net.sg.shoppingbackend.dao;

import java.util.List;

import net.sg.shoppingbackend.dto.Cart;
import net.sg.shoppingbackend.dto.CartLine;



public interface CartLineDAO {

	CartLine get(int id);
	List<CartLine> list(int cartId);
	boolean add(CartLine cartLine);
	boolean update(CartLine cartLine);
	boolean delete(CartLine cartLine);
	//other business methods
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId,int productId);
	boolean updateCart(Cart cart);
}

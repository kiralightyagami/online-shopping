package net.sg.shoppingbackend.dao;

import java.util.List;

import net.sg.shoppingbackend.dto.Address;
import net.sg.shoppingbackend.dto.Cart;
import net.sg.shoppingbackend.dto.User;

public interface UserDAO {

	boolean addUser(User user);
	User getByEmail(String email);
	boolean addAddress(Address address);
	Address getBilingAddress(User user);
	List<Address> listShippingAddress(User user);
	boolean updateCart(Cart cart);
}

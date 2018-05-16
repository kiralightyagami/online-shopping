package net.sg.shoppingbackend.dao;

import net.sg.shoppingbackend.dto.Address;
import net.sg.shoppingbackend.dto.Cart;
import net.sg.shoppingbackend.dto.User;

public interface UserDAO {

	boolean addUser(User user);
	boolean addAddress(Address address);
	boolean addCart(Cart cart);
}

package net.sg.onlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.sg.onlineshopping.model.RegisterModel;
import net.sg.shoppingbackend.dao.UserDAO;
import net.sg.shoppingbackend.dto.Address;
import net.sg.shoppingbackend.dto.Cart;
import net.sg.shoppingbackend.dto.User;

@Component
public class RegisterHandler {
	@Autowired
	private UserDAO userDAO;

	public RegisterModel init()
	{
		return new RegisterModel();
	}
	public void addUser(RegisterModel registerModel,User user)
	{
		registerModel.setUser(user);
	}
	public void addBilling(RegisterModel registerModel,Address billing)
	{
		registerModel.setBilling(billing);
	}
	
	public String saveAll(RegisterModel registerModel)
	{
		String transitionValue="success";
		//fetch the user
	User user=registerModel.getUser();
	if(user.getRole().equals("USER"))
	{
		Cart cart=new Cart();
		cart.setUser(user);
		user.setCart(cart);
		
	}
	//save the user
		
	userDAO.addUser(user);
	
	//get the address
	
	Address billing = registerModel.getBilling();
	billing.setUser(user);
	billing.setBilling(true);
	//save the address
	userDAO.addAddress(billing);
	
	
		return transitionValue;
		
	}
}

package net.sg.shoppingbackend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sg.shoppingbackend.dao.UserDAO;
import net.sg.shoppingbackend.dto.Address;
import net.sg.shoppingbackend.dto.Cart;
import net.sg.shoppingbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addUser(User user) {
		try {
			
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try {
			
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addCart(Cart cart) {
		try {
			
			sessionFactory.getCurrentSession().persist(cart);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}

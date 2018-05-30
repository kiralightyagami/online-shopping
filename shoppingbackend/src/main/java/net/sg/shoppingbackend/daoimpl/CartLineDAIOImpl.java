package net.sg.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.sg.shoppingbackend.dao.CartLineDAO;
import net.sg.shoppingbackend.dto.Cart;
import net.sg.shoppingbackend.dto.CartLine;

@Repository("cartLineDAO")
@Transactional
public class CartLineDAIOImpl implements CartLineDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public CartLine get(int id) {
		try {
			
			return sessionFactory.getCurrentSession().get(CartLine.class, Integer.valueOf(id));
		} catch (Exception ex) {
			ex.printStackTrace();
			
		}
		return null;
		
	}

	@Override
	public List<CartLine> list(int cartId) {
		String query="FROM CartLine WHERE cartId=:cartId";
		return sessionFactory.getCurrentSession().createQuery(query,CartLine.class).setParameter("cartId",cartId).getResultList();
	}

	@Override
	public boolean add(CartLine cartLine) {
		try {
			
			sessionFactory.getCurrentSession().persist(cartLine);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(CartLine cartLine) {
		try {
			
			sessionFactory.getCurrentSession().update(cartLine);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(CartLine cartLine) {

		
		try {
			cartLine.setAvailable(false);
			
			return this.update(cartLine);
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	
	}

	

	@Override
	public List<CartLine> listAvailable(int cartId) {
		String query="FROM CartLine WHERE cartId=:cartId AND available=:available";
		return sessionFactory.getCurrentSession().createQuery(query,CartLine.class).setParameter("cartId",cartId).setParameter("available", true).getResultList();
	}

	@Override
	public CartLine getByCartAndProduct(int cartId, int productId) {
		String query="FROM CartLine WHERE cartId=:cartId AND product.id=:productId";
		try {
		return sessionFactory.getCurrentSession().createQuery(query,CartLine.class).setParameter("cartId",cartId).setParameter("productId", productId).getSingleResult();
		}catch(Exception ex)
		{
			return null;
		}
	}

	//related to the cart
	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}

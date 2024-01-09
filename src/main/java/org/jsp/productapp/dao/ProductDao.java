package org.jsp.productapp.dao;

import java.util.Collections;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.jsp.productapp.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.NestedRuntimeException;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	@Autowired
	private EntityManager manager;

	public Product saveProduct(Product p) {
		EntityTransaction t = manager.getTransaction();
		manager.persist(p);
		t.begin();
		t.commit();
		return p;
	}

	public List<Product> getProducts() {
		try {
			Query q = manager.createQuery("select p from Product p");
			List<Product> products = q.getResultList();
			return products;
		} catch (Exception e) {
			e.printStackTrace(); // or log the exception
			return Collections.emptyList(); // or handle the exception appropriately
		}
	}

	public Product findById(int id) {
		return manager.find(Product.class, id);
	}

	public boolean deleteProduct(int id) {
		Product u = findById(id);
		if (u != null) {
			EntityTransaction t = manager.getTransaction();
			manager.remove(u);
			t.begin();
			t.commit();
			return true;
		}
		return false;
	}

	public Product updateProduct(int id,Product p) {
		EntityTransaction t = manager.getTransaction();
	Product dbProduct=	manager.find(Product.class, id);
		dbProduct.setDescription(p.getDescription());
		dbProduct.setProductname(p.getProductname());
		dbProduct.setPrice(p.getPrice());
		t.begin();
		t.commit();
		return dbProduct;
	}
}

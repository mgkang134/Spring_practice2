package com.example.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.example.demo.domain.Order;

@Repository
public class OrderRepository {
	
	@PersistenceContext
	private EntityManager em;

	public void save(Order order) {
		em.persist(order);
	}
	
	public Order findOne(Long id) {
		return em.find(Order.class, id);
	}
	
//	public List<Order> findAll(OrderSearch orderSearch){
//		
//	}
	
	
	
}

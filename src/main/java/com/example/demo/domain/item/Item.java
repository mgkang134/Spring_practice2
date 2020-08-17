package com.example.demo.domain.item;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.example.demo.domain.Category;
import com.example.demo.exception.NotEnoughStockException;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dtype")
public abstract class Item {
	
	@Id
	@GeneratedValue
	@Column(name="item_id")
	private Long id;
	
	private String name;
	private int price;
	private int stockQuantity;
	
	@ManyToMany(mappedBy = "items")
	private List<Category> categories = new ArrayList<>();
	
	
	//==비즈니스 로직==//
	
	//재고 수량 증가
	public void addStock(int quantity) {
		this.stockQuantity += quantity;
	}
	
	//재고 수량 감소
	public void removeStock(int quantity) {
		int restStock = this.stockQuantity - quantity;
		if(restStock < 0) {
			throw new NotEnoughStockException("need more stock");
		}else {
			this.stockQuantity = restStock;
		}
		
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
	
	
}

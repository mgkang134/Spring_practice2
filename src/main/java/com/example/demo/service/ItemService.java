package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.item.Book;
import com.example.demo.domain.item.Item;
import com.example.demo.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
public class ItemService {

	private final ItemRepository itemRepository;

	@Autowired
	public ItemService(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	@Transactional
	public void saveItem(Item item) {
		itemRepository.save(item);
	}
	
	@Transactional
	public void updateItem(Long itemId, Book param) {
		Item findItem = itemRepository.findOne(itemId);
		findItem.setPrice(param.getPrice());
		findItem.setName(param.getName());
		findItem.setStockQuantity(param.getStockQuantity());
		itemRepository.save(findItem);
	}
	
	public List<Item> findItems(){
		return itemRepository.findAll();
	}
	
	public Item findOne(Long id) {
		return itemRepository.findOne(id);
	}
	
	
	
}

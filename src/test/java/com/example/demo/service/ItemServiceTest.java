package com.example.demo.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.item.Album;
import com.example.demo.repository.ItemRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ItemServiceTest {

	@Autowired private ItemService itemService;
	@Autowired private ItemRepository itemRepository;
	
	@Test
	void 아이템추가() {
		//given
		Album item = new Album();
		item.setArtist("윤도현");
		
		//when
		itemService.saveItem(item);
		
		//then
		assertThat(itemRepository.findAll().size()).isEqualTo(1);
	}

	@Test
	void testSaveItem() {
	}

	@Test
	void testFindItem() {
	}

	@Test
	void testFindOne() {
	}

}

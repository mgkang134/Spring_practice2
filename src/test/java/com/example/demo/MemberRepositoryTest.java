package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
class MemberRepositoryTest {

	@Autowired MemberRepository memberRepository;

	@Transactional
	@Test
	public void testMember() throws Exception{
		//given
		Member member = new Member();
		member.setUsername("memberA");
		
		
		//when
		Long save = memberRepository.save(member);
		 
		
		//then
		Member findMember = memberRepository.find(save);
		Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
		Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());
		
	}
}

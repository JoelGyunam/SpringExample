package com.joelinseoul.spring.ex.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joelinseoul.spring.ex.database.domain.UsedGoods;
import com.joelinseoul.spring.ex.database.repository.UsedGoodsRepository;

// 로직 담당 (business)
@Service
public class UsedGoodsService {

	@Autowired
	private UsedGoodsRepository usedGoodsRepository;
	
	// usedgoods 리스트 조회 기능
	public List<UsedGoods> getUsedGoodsList() {
		List<UsedGoods> usedGoodsList = usedGoodsRepository.selectUsedGoodsList();
		
		return usedGoodsList;
	}
}

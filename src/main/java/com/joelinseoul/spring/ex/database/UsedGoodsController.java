package com.joelinseoul.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.joelinseoul.spring.ex.database.domain.UsedGoods;
import com.joelinseoul.spring.ex.database.service.UsedGoodsService;

// request, response 처리 담당
@Controller
public class UsedGoodsController {

	@Autowired
	private UsedGoodsService usedGoodsService;
	
	
	// usedgoods 목록 조회
	@RequestMapping("/db/usedgoods/list")
	@ResponseBody
	public List<UsedGoods> usedGoodsList() {
		List<UsedGoods> usedGoodsList = usedGoodsService.getUsedGoodsList();
		
		return usedGoodsList;
	}
}

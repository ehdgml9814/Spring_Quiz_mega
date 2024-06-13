package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;

@Service // Spring bean 등록
public class StoreBO {

	// input: X
	// output: List<Store>
	
	@Autowired
	private StoreMapper storeMapper;
	
	public List<Store> getStoreList() {
		return storeMapper.selectStoreList();
	}
}

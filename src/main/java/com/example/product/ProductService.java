package com.example.product;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface ProductService {
	
	@Transactional
	void buyProcut(String userId, String proId, int count);
}

package com.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.user.UserJDBCDao;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private UserJDBCDao userJDBCDao;
	
	@Override
	@Transactional
	public void buyProcut(String userId, String proId, int count){
		Double total = 0.0;
		//1.获取商品信息
		Product product = productDao.getProductById(proId);
		//2.商品库存 - count
		productDao.updateRepertoryById(proId, count);
		//3.用户账户金额 - 单价*数量
		total = count * product.getPrice();
		userJDBCDao.updateBanlanceById(userId, total);		
	}
}

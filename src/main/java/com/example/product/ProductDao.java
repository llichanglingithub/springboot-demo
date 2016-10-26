package com.example.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	/**
	 * 根据Id获取商品的信息
	 * @return
	 */
	public Product getProductById(String id){
		String sql = "select id, name, price, repertory from product where id = ?";
		RowMapper<Product> rowMapper = new BeanPropertyRowMapper<>(Product.class) ;
		Product product = jdbcTemplate.queryForObject(sql, rowMapper, Long.parseLong(id));
		return product;
	}
	/**
	 * 根据Id更新库存数量
	 */
	public void updateRepertoryById(String id, int count){
		
		Product product = getProductById(id);
		int repertory = product.getRepertory();
		if(repertory < count){
			throw new ProductStoreException("库存不足。。。");
		}
		String sql = "update product set repertory = repertory - ? where id = ?";
		jdbcTemplate.update(sql, count, Long.parseLong(id));
	}
	
}

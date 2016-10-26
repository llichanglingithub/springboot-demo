package com.example.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


@Repository
public class UserJDBCDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 插入一个用户信息
	 * @return 返回改变的数据的条数 ------1
	 */
	public String insertUserInfo(){
		String sql = "insert into user(name, password, banlance) values (?,?,?)";
		int count = jdbcTemplate.update(sql, "jdbcinsert", "111", 100.0);
		
		return count + "";
	}
	//获取用户的信息
	public User getUserInfoById(String id){
		String sql = "SELECT id, name, password, banlance FROM user WHERE id = ?";
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		User user = jdbcTemplate.queryForObject(sql, rowMapper, Long.parseLong(id));
		return user;
	}
	//更新用户的账户余额
	public void updateBanlanceById(String id, Double total){
		
		User user = getUserInfoById(id);
		Double banlance = user.getBanlance();
		if (banlance < total) {
			throw new UserAccountException("用户余额不足...");
		}
		
		String sql = "update user set banlance = banlance - ? where id = ?";
		System.out.println("这是要购买的商品的总价格" + total);
		jdbcTemplate.update(sql, total, Long.parseLong(id));
	}
}

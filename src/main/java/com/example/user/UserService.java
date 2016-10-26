package com.example.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	/**
	 * 使用JPA持久化数据
	 */
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserJDBCDao userJDBCDao;
	
	public String saveUserInfo(){
		//userRepository.save(new User("lcl", "123", 120.0));
		userRepository.save(new User("Tom", "111", 200.0));
		userRepository.save(new User("Anna", "222", 100.0));
		userRepository.save(new User("Kity", "333", 50.0));
		userRepository.save(new User("Stiven", "444", 120.0));
		return "user jpa insert info ending...";
	}
	
	public User printUserInfo() {
		User user= userRepository.findByName("lcl");
		//System.out.println(user);
		
		return user;
	}
	
	/**
	 * 使用JDBC持久化数据
	 */
	public String insertUserInfo(){
		String result = userJDBCDao.insertUserInfo();
		return result;
	}
	
	public User getUserInfo(String id){
		User user = userJDBCDao.getUserInfoById(id);
		return user;
	}
}

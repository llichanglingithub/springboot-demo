package com.example.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.ProductService;

/**
 * 用来测试JDBC
 * @author zyeeda
 *
 */

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	@Qualifier(value = "productServiceImpl")
	private ProductService productService;
	
	@RequestMapping("/")
	public String hello() {
		return "hello jpa and jdbc...";
	}
	@RequestMapping("/jpa/save")
	public String initData() {
		String saveUserInfo = userService.saveUserInfo();
		return saveUserInfo;
	}
	@RequestMapping("/jpa/getuserinfo")
	public User getUserInfo() {
		return userService.printUserInfo();
	}
	@RequestMapping("/jdbc/insert")
	public String insertUserInfo(){
		return userService.insertUserInfo();
	}
	
	@RequestMapping("/jdbc/getuserinfo")
	public String getUserInfoByJDBC(){
		return userService.getUserInfo("1").toString();
	}
	
	//测试事物
	@RequestMapping("/user/buyproduct")
	public String buy(HttpServletRequest request){
		String userId =request.getParameter("userid");
		String proId = request.getParameter("proid");
		int count = Integer.parseInt(request.getParameter("count"));
		productService.buyProcut(userId, proId, count);
		return "购买成功。。。";
	}
}


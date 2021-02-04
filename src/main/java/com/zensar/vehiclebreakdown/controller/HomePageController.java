package com.zensar.vehiclebreakdown.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zensar.vehiclebreakdown.dao.UserDao;
import com.zensar.vehiclebreakdown.model.User;
import com.zensar.vehiclebreakdown.service.UserService;

@Controller
public class HomePageController {
	@Autowired
	UserService userService;
	
	@Autowired
	UserDao userDao;
	
	@GetMapping("/home")
	public String getIndex() {
		return "index";
	}
	
	@GetMapping("/register/all")
	public String getRegisterForm(Model model) {
		User user = new User();
		model.addAttribute("user",user);
		return "registerform";
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping("/admin/viewuser")
	public String getUsers(HttpServletRequest req) {
		 HttpSession session=req.getSession();
		 List<User> user = userService.getAll();
		 session.setAttribute("user", user);
		return "viewuserform";
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
	@GetMapping("/user/searchlocation")
	public String getMechanic(HttpServletRequest req) {
		String role = "ROLE_MECHANIC";
		 HttpSession session=req.getSession();
		 List<User> user = userService.getUserByRole(role);
		 session.setAttribute("user", user);
		return "searchlocationform";
	
	}
	
	@GetMapping("/login")
	public String getLoginForm() {
		return "loginform";
	}
	
//	@ModelAttribute
	@PostMapping("/login.do")
	public String loginUser(@RequestParam("username") String username, @RequestParam("password") String password,
			HttpServletRequest req) {
		
		HttpSession session=req.getSession();
		 
		try {
			User user = userDao.findByUsername(username);
			if (username.equals(user.getUsername())) {
				if(password.equals(user.getPassword())) {
//						model.addAttribute("user", user);
						session.setAttribute("user", user);
						return "index";	
				}else {
					return "loginform";
				}
			} else {
				return "loginform";
			}
		}catch (Exception e) {
			System.out.println("User could not be identified: "+ e);
		}
		return "loginform";
	}
}

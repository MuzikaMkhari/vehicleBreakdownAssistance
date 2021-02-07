package com.zensar.vehiclebreakdown.controller;

import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zensar.vehiclebreakdown.dao.UserDao;
import com.zensar.vehiclebreakdown.model.Feedback;
import com.zensar.vehiclebreakdown.model.User;

import com.zensar.vehiclebreakdown.service.FeedbackService;


@Controller
public class FeedbackController {
	
	@Autowired
	FeedbackService feedbackservice;
	
	@Autowired
	UserDao userDao;
	
	@GetMapping("/feedback")
	public String getFeedbackForm(Model model) {
		Feedback f = new Feedback();
		model.addAttribute("feedback", f);
		return "feedbackform";
	}
	
	
	@PostMapping("/sendfeedback")
	public ResponseEntity<String> saveFeedback(Feedback feedback, Model model, HttpServletRequest req, Authentication authentication){
		
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("userSession");
	
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
		String date=dtf.format(now);
		
		feedback.setDate(date);
		feedback.setUser(user);
		
		feedbackservice.addFeedback(feedback);
		return ResponseEntity.ok("Feedback added successfully");
	}
}

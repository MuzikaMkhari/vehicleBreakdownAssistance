package com.zensar.vehiclebreakdown.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.vehiclebreakdown.dao.RequestDao;
import com.zensar.vehiclebreakdown.dao.customizedDao;
import com.zensar.vehiclebreakdown.model.Request;
import com.zensar.vehiclebreakdown.model.User;

@Service
public class RequestService {

	@Autowired
	RequestDao requestDao;
	
	public Request addRequest(@RequestBody Request request) {
		return  requestDao.save(request);
	}
	
	public List<Request> getRequests() {

		return (List<Request>) requestDao.findAll();
	}
	@Autowired
	customizedDao customDao;
	
	public User getUserById(int id) {
		return customDao.getOne(id);
	}
	
	public List<User> allUsers(){
		
		return customDao.findAll();
	}
	public Request makeRequest(@RequestBody Request req) {
		
		return requestDao.save(req);
	}
}
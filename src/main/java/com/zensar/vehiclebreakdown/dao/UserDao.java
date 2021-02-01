package com.zensar.vehiclebreakdown.dao;



import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zensar.vehiclebreakdown.model.User;

@Repository
public interface UserDao extends CrudRepository<User,Long> {
		
	

}

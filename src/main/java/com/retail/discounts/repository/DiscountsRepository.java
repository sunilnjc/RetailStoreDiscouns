package com.retail.discounts.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.retail.discounts.model.User;

@Repository
public class DiscountsRepository {
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	public List<User> findAllUsers(String userId){
		
		Criteria criteria = new Criteria();

		criteria = Criteria.where("_id").is(userId);

		Query queryResult = new Query();

		queryResult.addCriteria(criteria);

		List<User> userDetails = mongoTemplate.find(queryResult, User.class, "user");
		
		return userDetails;
		
	}
	
}

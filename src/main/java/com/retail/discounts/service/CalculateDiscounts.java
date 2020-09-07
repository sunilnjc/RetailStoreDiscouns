package com.retail.discounts.service;

import java.util.List;

import com.retail.discounts.model.Items;
import com.retail.discounts.model.User;

public interface CalculateDiscounts {

	Items calculateDiscountsBasedOnType(Items item, List<User> userDetails);
	
}

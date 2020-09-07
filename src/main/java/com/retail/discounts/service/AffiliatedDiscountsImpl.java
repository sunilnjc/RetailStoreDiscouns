package com.retail.discounts.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.retail.discounts.model.Items;
import com.retail.discounts.model.User;

/**
 * 
 * @author Sunil
 *
 * Design Patterns - SRP and O/P
 *
 */
@Service
public class AffiliatedDiscountsImpl implements CalculateDiscounts{

	@Override
	public Items calculateDiscountsBasedOnType(Items item, List<User> userDetails) {
		
		Items resultItems = null;
		
		Double totalPrice = item.getQuantity() * item.getPrice();

		Double discountedPrice = null;
		
		discountedPrice = Math.abs(totalPrice - Math.abs(0.1 * totalPrice));
		resultItems = new Items(item.getItemName(),item.getQuantity(), item.getType(), totalPrice, discountedPrice);
		
		return resultItems;
	}

}

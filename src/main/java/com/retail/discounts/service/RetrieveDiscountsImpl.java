package com.retail.discounts.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.retail.discounts.model.Items;
import com.retail.discounts.model.ItemsList;
import com.retail.discounts.model.ProductType;
import com.retail.discounts.model.User;
import com.retail.discounts.response.FinalDiscounts;

/**
 * 
 * @author Sunil
 *
 */

@Service
public class RetrieveDiscountsImpl implements RetrieveDiscounts {

	@Autowired
	MongoTemplate mongoTemplate;
	
	/**
	 * Discounted price method takes the userId and list of items as input
	 * userId will be used to verify whether user exists or not 
	 * based on the user existence we can differentiate the employee of the store or the affiliated
	 * There are 3 different types of  users EMPLOYED, AFFILIATED, OTHERS
	 * items is the list of the items consumer has ordered and ready to be billed
	 * @return the final list of items with total discounted price and total price of the each product categorised under 
	 * HOME and GROCERY
	 * 
	 */
	@Override
	public FinalDiscounts discountedPrice(String userId, ItemsList items) {

		FinalDiscounts finalDiscounts = null;

		Criteria criteria = new Criteria();

		criteria = Criteria.where("_id").is(userId);

		Query queryResult = new Query();

		queryResult.addCriteria(criteria);

		List<User> userDetails = mongoTemplate.find(queryResult, User.class, "user");

		finalDiscounts = calculateDiscounts(items, userDetails);

		return finalDiscounts;
	}

	/**
	 * 
	 * @param items
	 * @param userDetails
	 * userDetails - This method will verify whether the user details exists or not by calling mongodb
	 * We will iterate through each item and based on the categorisation of the product, it will be redirected to 
	 * two different methods 
	 * calculateDiscountsBasedOnRegularUserAndProductType - calculates discounts based on user type and product type
	 * calculateDiscountsBasedOnNonRegularUser - calculates discounts based on the non regular user
	 * @return finalDiscounts
	 */
	private FinalDiscounts calculateDiscounts(ItemsList items, List<User> userDetails) {

		FinalDiscounts finalDiscounts = new FinalDiscounts();

		List<Items> finalItemList = new ArrayList<>();

		items.getItems().forEach(item -> {

			if (!CollectionUtils.isEmpty(userDetails) && item.getType() != null
					&& item.getType().equals(ProductType.HOME)) {
				finalItemList.add(calculateDiscountsBasedOnRegularUserAndProductType(item,
						userDetails.get(0).getType().toString(), userDetails));
			} else {
				finalItemList.add(calculateDiscountsBasedOnNonRegularUser(item));
			}
		});

		Double totalDiscountedPrice = Math.round( calculateTotalDiscountedPrice(finalItemList) * 100.0 ) / 100.0;
		
		finalDiscounts.setTotalDiscountedPrice(totalDiscountedPrice);

		finalDiscounts.setItemsPurchased(finalItemList);
		
		if(!CollectionUtils.isEmpty(userDetails)) {
			finalDiscounts.setUserName(userDetails.get(0).getUserName());
			finalDiscounts.setUserType(userDetails.get(0).getType().toString());
		}

		return finalDiscounts;
	}

	/**
	 * 
	 * @param finalItemList
	 * This method calculates the total discounted price of the total items purchased
	 * @return totalDiscountedPrice
	 */
	private Double calculateTotalDiscountedPrice(List<Items> finalItemList) {
		Double totalDiscountedPrice = finalItemList.stream().mapToDouble(x -> x.getDiscountedPrice()).sum();

		if (totalDiscountedPrice > 100) {
			totalDiscountedPrice = totalDiscountedPrice - (totalDiscountedPrice / 100) * 5;
		}
		return totalDiscountedPrice;
	}

	/**
	 * 
	 * @param item
	 * This method will be called if there are no users or the product type is not HOME
	 * @return Items - an item object which contains the discounted price, item name, quantity, total price 
	 */
	private Items calculateDiscountsBasedOnNonRegularUser(Items item) {

		Items resultItems = null;

		Double totalPrice = item.getQuantity() * item.getPrice();

		Double discountedPrice = totalPrice;

		resultItems = new Items(item.getItemName(),item.getQuantity(),item.getType(),totalPrice, discountedPrice);

		return resultItems;
	}

	/**
	 * 
	 * @param item
	 * This method will be called if there are specific users such as EMPLOYED, AFFILIATED or OTHERS and the product type is  HOME
	 * @return Items - an item object which contains the discounted price, item name, quantity, total price 
	 */
	private Items calculateDiscountsBasedOnRegularUserAndProductType(Items item, String type, List<User> userDetails) {

		Items resultItems = null;

		Double totalPrice = item.getQuantity() * item.getPrice();

		Double discountedPrice = null;

		switch (type) {

		case "EMPLOYED":
			discountedPrice = Math.abs(totalPrice - Math.abs(0.3 * totalPrice));
			resultItems = new Items(item.getItemName(),item.getQuantity(), item.getType(), totalPrice, discountedPrice);
			break;

		case "AFFILIATED":
			discountedPrice = Math.abs(totalPrice - Math.abs(0.1 * totalPrice));
			resultItems = new Items(item.getItemName(),item.getQuantity(), item.getType(), totalPrice, discountedPrice);
			break;

		case "OTHERS":
			Long sinceWhen = ChronoUnit.MONTHS.between(LocalDate.parse(userDetails.get(0).getSinceWhen()),
					LocalDate.now());
			if (sinceWhen > 24) {
				discountedPrice = Math.abs(totalPrice - Math.abs(0.05 * totalPrice));
				resultItems = new Items(item.getItemName(),item.getQuantity(), item.getType(), totalPrice, discountedPrice);
			}
			break;

		default:
			calculateDiscountsBasedOnNonRegularUser(item);
			break;

		}

		return resultItems;
	}

}

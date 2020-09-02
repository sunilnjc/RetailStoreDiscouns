package com.retail.discounts.services;

import java.util.ArrayList;
import java.util.List;

import com.retail.discounts.model.Items;
import com.retail.discounts.model.ItemsList;
import com.retail.discounts.model.ProductType;
import com.retail.discounts.model.User;
import com.retail.discounts.model.UserType;
import com.retail.discounts.response.FinalDiscounts;

public class RetailDOFactory {

	public List<User> UserListEmployed() {

		User user = new User();
		user.setUserId("5f4e1b76ead6f06f6a348457");
		user.setUserName("Sunil");
		user.setType(UserType.EMPLOYED);
		user.setSinceWhen("2017-06-03");

		List<User> userDetails = new ArrayList<>();
		userDetails.add(user);

		return userDetails;

	}
	
	public List<User> UserListOthers() {

		User user = new User();
		user.setUserId("5f4e1b76ead6f06f6a348459");
		user.setUserName("Arul");
		user.setType(UserType.OTHERS);
		user.setSinceWhen("2016-12-03");

		List<User> userDetails = new ArrayList<>();
		userDetails.add(user);

		return userDetails;

	}
	
	public List<User> UserListAffiliated() {

		User user = new User();
		user.setUserId("5f4e1b76ead6f06f6a348458");
		user.setUserName("Anil");
		user.setType(UserType.AFFILIATED);
		user.setSinceWhen("2018-08-08");

		List<User> userDetails = new ArrayList<>();
		userDetails.add(user);

		return userDetails;

	}
	
	public List<User> UserListNonRegular() {

		User user = new User();
		user.setUserId("sunil007");
		user.setUserName("Anil");
		user.setType(UserType.AFFILIATED);
		user.setSinceWhen("2018-08-08");

		List<User> userDetails = new ArrayList<>();
		userDetails.add(user);

		return null;

	}

	public ItemsList ListOfItems() {

		Items items = new Items("Potato", 5, ProductType.HOME, 14.4, 10.0);

		List<Items> itemList = new ArrayList<>();
		itemList.add(items);

		ItemsList listOfItems = new ItemsList();
		listOfItems.setItems(itemList);

		return listOfItems;

	}
	
	public ItemsList ListOfItemsHome() {

		Items items = new Items("Bose", 5, ProductType.HOME, 100.4, 95.0);

		List<Items> itemList = new ArrayList<>();
		itemList.add(items);

		ItemsList listOfItems = new ItemsList();
		listOfItems.setItems(itemList);

		return listOfItems;

	}
	
	public FinalDiscounts finalDiscountsForOthers() {

		Items items = new Items("Potato", 5, ProductType.HOME, 14.4, 10.0);

		List<Items> itemList = new ArrayList<>();
		itemList.add(items);

		FinalDiscounts finalDiscounts = new FinalDiscounts();
		finalDiscounts.setUserName("Arul");
		finalDiscounts.setUserType(UserType.OTHERS.toString());
		finalDiscounts.setTotalDiscountedPrice(68.4);
		finalDiscounts.setItemsPurchased(itemList);

		return finalDiscounts;

	}
	
	public FinalDiscounts finalDiscountsForEmployed() {

		Items items = new Items("Potato", 5, ProductType.HOME, 14.4, 10.0);

		List<Items> itemList = new ArrayList<>();
		itemList.add(items);

		FinalDiscounts finalDiscounts = new FinalDiscounts();
		finalDiscounts.setUserName("Sunil");
		finalDiscounts.setUserType(UserType.EMPLOYED.toString());
		finalDiscounts.setTotalDiscountedPrice(50.4);
		finalDiscounts.setItemsPurchased(itemList);

		return finalDiscounts;

	}
	
	
	public FinalDiscounts totalDiscountedPriceForEmployee() {

		Items items = new Items("Potato", 5, ProductType.HOME, 14.4, 10.0);

		List<Items> itemList = new ArrayList<>();
		itemList.add(items);

		FinalDiscounts finalDiscounts = new FinalDiscounts();
		finalDiscounts.setUserName("Sunil");
		finalDiscounts.setUserType(UserType.EMPLOYED.toString());
		finalDiscounts.setTotalDiscountedPrice(476.9);
		finalDiscounts.setItemsPurchased(itemList);

		return finalDiscounts;

	}
	
	public FinalDiscounts finalDiscountsForAffiliated() {

		Items items = new Items("Potato", 5, ProductType.HOME, 14.4, 10.0);

		List<Items> itemList = new ArrayList<>();
		itemList.add(items);

		FinalDiscounts finalDiscounts = new FinalDiscounts();
		finalDiscounts.setUserName("Anil");
		finalDiscounts.setUserType(UserType.AFFILIATED.toString());
		finalDiscounts.setTotalDiscountedPrice(64.8);
		finalDiscounts.setItemsPurchased(itemList);

		return finalDiscounts;

	}
	
	public List<User> UserListDefaultUsers() {

		User user = new User();
		user.setUserId("5f4e1b76ead6f06f6a348457");
		user.setUserName("Anil");
		user.setType(UserType.TEST);
		user.setSinceWhen("2018-08-08");

		List<User> userDetails = new ArrayList<>();
		userDetails.add(user);

		return userDetails;

	}
	
	public FinalDiscounts finalDiscountsForNonRegularUsers() {

		Items items = new Items("Potato", 5, ProductType.HOME, 14.4, 10.0);

		List<Items> itemList = new ArrayList<>();
		itemList.add(items);

		FinalDiscounts finalDiscounts = new FinalDiscounts();
		finalDiscounts.setUserName("Anil");
		finalDiscounts.setUserType(UserType.AFFILIATED.toString());
		finalDiscounts.setTotalDiscountedPrice(72.0);
		finalDiscounts.setItemsPurchased(itemList);

		return finalDiscounts;

	}
	
	public FinalDiscounts fetchFinalDiscountedPriceForDefaultUsers() {

		Items items = new Items("Potato", 5, ProductType.HOME, 14.4, 10.0);

		List<Items> itemList = new ArrayList<>();
		itemList.add(items);

		FinalDiscounts finalDiscounts = new FinalDiscounts();
		finalDiscounts.setUserName("Anil");
		finalDiscounts.setUserType(UserType.TEST.toString());
		finalDiscounts.setTotalDiscountedPrice(72.0);
		finalDiscounts.setItemsPurchased(itemList);

		return finalDiscounts;

	}


}

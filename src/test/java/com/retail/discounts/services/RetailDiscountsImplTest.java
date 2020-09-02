package com.retail.discounts.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

import com.retail.discounts.model.ItemsList;
import com.retail.discounts.model.User;
import com.retail.discounts.response.FinalDiscounts;
import com.retail.discounts.service.RetrieveDiscounts;
import com.retail.discounts.service.RetrieveDiscountsImpl;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
public class RetailDiscountsImplTest {

	private static FinalDiscounts finalDiscounts;

	private static RetailDOFactory doFactory;

	MongoTemplate mongoTemplate = mock(MongoTemplate.class);

	@InjectMocks
	RetrieveDiscounts retrieveDiscounts = new RetrieveDiscountsImpl();

	@BeforeClass
	public static void setUp() throws IOException {
		doFactory = new RetailDOFactory();
	}

	@Test
	public void fetchFinalDiscountedPriceForOthers() {

		ItemsList listOfItems = doFactory.ListOfItems();

		List<User> listOfUsers = doFactory.UserListOthers();

		Mockito.when(mongoTemplate.find(Mockito.any(Query.class), Mockito.eq(User.class), Mockito.anyString()))
				.thenReturn(listOfUsers);

		FinalDiscounts finalDiscountsResponse = retrieveDiscounts.discountedPrice("5f4e1b76ead6f06f6a348459",
				listOfItems);

		finalDiscounts = doFactory.finalDiscountsForOthers();

		assertEquals(finalDiscounts.getTotalDiscountedPrice(), finalDiscountsResponse.getTotalDiscountedPrice());
		assertEquals(finalDiscounts.getUserType(), finalDiscountsResponse.getUserType());
		assertEquals(finalDiscounts.getUserName(), finalDiscountsResponse.getUserName());

	}

	@Test
	public void fetchFinalDiscountedPriceForEmployed() {

		ItemsList listOfItems = doFactory.ListOfItems();

		List<User> listOfUsers = doFactory.UserListEmployed();

		Mockito.when(mongoTemplate.find(Mockito.any(Query.class), Mockito.eq(User.class), Mockito.anyString()))
				.thenReturn(listOfUsers);

		FinalDiscounts finalDiscountsResponse = retrieveDiscounts.discountedPrice("5f4e1b76ead6f06f6a348459",
				listOfItems);

		finalDiscounts = doFactory.finalDiscountsForEmployed();

		assertEquals(finalDiscounts.getTotalDiscountedPrice(), finalDiscountsResponse.getTotalDiscountedPrice());
		assertEquals(finalDiscounts.getUserType(), finalDiscountsResponse.getUserType());
		assertEquals(finalDiscounts.getUserName(), finalDiscountsResponse.getUserName());

	}

	@Test
	public void fetchFinalDiscountedPriceForAffiliated() {

		ItemsList listOfItems = doFactory.ListOfItems();

		List<User> listOfUsers = doFactory.UserListAffiliated();

		Mockito.when(mongoTemplate.find(Mockito.any(Query.class), Mockito.eq(User.class), Mockito.anyString()))
				.thenReturn(listOfUsers);

		FinalDiscounts finalDiscountsResponse = retrieveDiscounts.discountedPrice("5f4e1b76ead6f06f6a348459",
				listOfItems);

		finalDiscounts = doFactory.finalDiscountsForAffiliated();

		assertEquals(finalDiscounts.getTotalDiscountedPrice(), finalDiscountsResponse.getTotalDiscountedPrice());
		assertEquals(finalDiscounts.getUserType(), finalDiscountsResponse.getUserType());
		assertEquals(finalDiscounts.getUserName(), finalDiscountsResponse.getUserName());

	}
	
	@Test
	public void fetchFinalDiscountedPriceForNonRegularUsers() {

		ItemsList listOfItems = doFactory.ListOfItems();

		List<User> listOfUsers = doFactory.UserListNonRegular();

		Mockito.when(mongoTemplate.find(Mockito.any(Query.class), Mockito.eq(User.class), Mockito.anyString()))
				.thenReturn(listOfUsers);

		FinalDiscounts finalDiscountsResponse = retrieveDiscounts.discountedPrice("sunil123",
				listOfItems);
			
		finalDiscounts = doFactory.finalDiscountsForNonRegularUsers();

		assertEquals(finalDiscounts.getTotalDiscountedPrice(), finalDiscountsResponse.getTotalDiscountedPrice());

	}
	
	@Test
	public void fetchFinalDiscountedPriceForDefaultUsers() {

		ItemsList listOfItems = doFactory.ListOfItems();

		List<User> listOfUsers = doFactory.UserListDefaultUsers();

		Mockito.when(mongoTemplate.find(Mockito.any(Query.class), Mockito.eq(User.class), Mockito.anyString()))
				.thenReturn(listOfUsers);

		FinalDiscounts finalDiscountsResponse = retrieveDiscounts.discountedPrice("sunil123",
				listOfItems);
			
		finalDiscounts = doFactory.finalDiscountsForNonRegularUsers();

		assertEquals(finalDiscounts.getTotalDiscountedPrice(), finalDiscountsResponse.getTotalDiscountedPrice());

	}

}

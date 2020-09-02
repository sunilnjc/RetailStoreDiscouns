package com.retail.discounts.controller;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.retail.discounts.model.Items;
import com.retail.discounts.model.ItemsList;
import com.retail.discounts.model.ProductType;
import com.retail.discounts.model.UserType;
import com.retail.discounts.response.FinalDiscounts;
import com.retail.discounts.service.RetrieveDiscounts;

@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@WebMvcTest
public class RetailDiscountsControllerTest {

	@InjectMocks
	RetailDiscountsController retailDiscountsControllerTest;

	@MockBean
	RetrieveDiscounts retrieveDiscounts;

	@Autowired
	MockMvc mvc;

	protected void setUp() {

		Items items = new Items("Potato", 5, ProductType.HOME, 14.4, 10.0);

		List<Items> itemList = new ArrayList<>();
		itemList.add(items);

		FinalDiscounts finalDiscounts = new FinalDiscounts();
		finalDiscounts.setUserName("Sunil");
		finalDiscounts.setUserType(UserType.EMPLOYED.toString());
		finalDiscounts.setTotalDiscountedPrice(444.34);
		finalDiscounts.setItemsPurchased(itemList);

		Mockito.when(retrieveDiscounts.discountedPrice(Mockito.anyString(), Mockito.any(ItemsList.class)))
				.thenReturn(finalDiscounts);

	}

	protected String mapToJson(Object obj) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(obj);
	}

	@Test
	public void updateDiscountedPrices() throws Exception {
		Items items = new Items("Potato", 5, ProductType.HOME, 14.4, 10.0);

		items.setItemId("test");

		List<Items> itemList = new ArrayList<>();
		itemList.add(items);

		ItemsList listOfItems = new ItemsList();
		listOfItems.setItems(itemList);

		String inputJson = mapToJson(listOfItems);

		// when
		MockHttpServletResponse response = mvc.perform(
				put("/v1/retail/5f4e1b76ead6f06f6a348459/discounts", mvc.getDispatcherServlet().getServletContext(),
						"/products").contentType(MediaType.APPLICATION_JSON).content(inputJson))
				.andReturn().getResponse();

		int status = response.getStatus();
		assertEquals(200, status);

	}

	@Test
	public void updateDiscountedPricesFailed() throws Exception {
		Items items = new Items("Potato", 5, ProductType.HOME, 14.4, 10.0);

		items.setItemId("test");

		List<Items> itemList = new ArrayList<>();
		itemList.add(items);

		ItemsList listOfItems = new ItemsList();
		listOfItems.setItems(itemList);

		String inputJson = mapToJson(listOfItems);

		// when
		MockHttpServletResponse response = mvc.perform(
				put("/product/v1/retail/5f4e1b76ead6f06f6a348459/discounts").contentType(MediaType.APPLICATION_JSON).content(inputJson))
				.andReturn().getResponse();

		int status = response.getStatus();
		assertEquals(404, status);

	}

}

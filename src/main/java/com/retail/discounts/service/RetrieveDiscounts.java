package com.retail.discounts.service;

import com.retail.discounts.model.ItemsList;
import com.retail.discounts.response.FinalDiscounts;

public interface RetrieveDiscounts {

	FinalDiscounts discountedPrice(String userId, ItemsList items);

}

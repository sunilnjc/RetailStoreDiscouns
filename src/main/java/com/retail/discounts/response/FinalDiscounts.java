package com.retail.discounts.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.retail.discounts.model.Items;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FinalDiscounts {

	private String userName;
	private String userType;

	private Double totalDiscountedPrice;

	private List<Items> itemsPurchased;

	public Double getTotalDiscountedPrice() {
		return totalDiscountedPrice;
	}

	public void setTotalDiscountedPrice(Double totalDiscountedPrice) {
		this.totalDiscountedPrice = totalDiscountedPrice;
	}

	public List<Items> getItemsPurchased() {
		return itemsPurchased;
	}

	public void setItemsPurchased(List<Items> itemsPurchased) {
		this.itemsPurchased = itemsPurchased;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "FinalDiscounts [userName=" + userName + ", userType=" + userType + ", totalDiscountedPrice="
				+ totalDiscountedPrice + ", itemsPurchased=" + itemsPurchased + "]";
	}
}

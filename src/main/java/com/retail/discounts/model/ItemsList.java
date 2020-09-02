package com.retail.discounts.model;

import java.util.List;

public class ItemsList {

	private List<Items> items;

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "ItemsList [items=" + items + "]";
	}
}

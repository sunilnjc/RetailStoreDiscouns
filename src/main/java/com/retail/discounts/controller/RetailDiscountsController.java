package com.retail.discounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.discounts.constants.Constants;
import com.retail.discounts.model.ItemsList;
import com.retail.discounts.response.FinalDiscounts;
import com.retail.discounts.service.RetrieveDiscounts;

@RestController
@RequestMapping(Constants.VERSION_1 + Constants.RETAIL)
public class RetailDiscountsController {

	@Autowired
	RetrieveDiscounts retrieveDiscounts;

	@PutMapping(Constants.ID + Constants.DISCOUNTS)
	public ResponseEntity<FinalDiscounts> fetchDiscounts(@PathVariable("id") String userId,
			@RequestBody ItemsList items) {
//		return response.responseEntity200(retrieveDiscounts.discountedPrice(userId, items));
		return ResponseEntity.ok(retrieveDiscounts.discountedPrice(userId, items));
	}

	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
		return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

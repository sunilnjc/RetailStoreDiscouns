package com.retail.discounts.utils;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ResponseGenerationUtils {

	@Autowired
	private ObjectMapper mapper;

	public ResponseEntity<Object> responseEntity200(Object object) {
		HttpHeaders responseHeaders = generateResponseHeaders(object);

		return new ResponseEntity<>(object, responseHeaders, HttpStatus.OK);
	}

	private HttpHeaders generateResponseHeaders(Object object) {

		HttpHeaders responseHeaders = new HttpHeaders();
		if (Objects.nonNull(object)) {
			try {
				responseHeaders.set("Content-Length", String.valueOf(mapper.writeValueAsString(object).length()));
			} catch (JsonProcessingException e) {
				e.getMessage();
			}
		}

		return responseHeaders;
	}

}

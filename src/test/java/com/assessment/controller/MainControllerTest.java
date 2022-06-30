package com.assessment.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class MainControllerTest {

	@Autowired
	MainController mainController;
	
	@Test
	void controllerHappyPath() throws Exception{
		
		String bizId = "MGd6HFEq1ALD58XWNviSXw";
		
		ResponseEntity<String> entity = mainController.getReviewsByBizId(bizId);
		
		assertNotNull(entity);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		
	}
}

package com.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.domain.Review;
import com.assessment.service.ReviewService;
import com.assessment.util.Constant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping(Constant.BASEPATH)
public class MainController {

	@Autowired
	ReviewService reviewService;
	
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	
	@GetMapping("/{biz_id}/reviews")
	public ResponseEntity<String> getReviewsByBizId(@PathVariable("biz_id") String bizId ) throws Exception{
		
		//Favorite Restaurant Id : MGd6HFEq1ALD58XWNviSXw 
		
		//Get the Reviews
		List<Review> reviews = reviewService.getReviewsByBizzId(bizId);

		//Transform the list into Json 
		String json = gson.toJson(reviews);
		
		
		return new ResponseEntity<>(json, HttpStatus.OK);
	}
	

	@GetMapping("/first_bizz")
	public ResponseEntity<String> getBizzId() throws Exception{
		
		//Get the Id
		String bizId = reviewService.findFirstBusinessIdByQuery();
		
		return new ResponseEntity<>(bizId, HttpStatus.OK);
	}

}

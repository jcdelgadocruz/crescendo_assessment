package com.assessment.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.stereotype.Service;
import com.assessment.domain.Reviews;
import com.assessment.domain.Businessess;
import com.assessment.domain.Review;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class ReviewService {

	
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	
	public String findFirstBusinessIdByQuery() throws Exception {

		String bizzId = "";
		
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://api.yelp.com/v3/businesses/search?term=food&location=nyc"))
				.header("Authorization",
						"Bearer mZcjzNFDd09EIysej2EvjSI63VZM4RPFtszVWUaUZda1DyTpFhmqGZmJpblbxG-am1jlLXthARLO4zSTXK531FHsg97m6HLcyPg8Fu_ym_d-qsVlJTWXLRh90JW8YnYx")
				.GET().build();
	
		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String jsonString = response.body();
		
		
		if (response.statusCode() != 200)
			throw new Exception(jsonString);
		
		Businessess businessess = gson.fromJson(jsonString, Businessess.class);

		bizzId = businessess.getBusinesses()[0].getId(); 
		
		return bizzId;
	}

	
	
	public List<Review> getReviewsByBizzId(String bizId) throws Exception {
		
		HttpResponse<String> response = null;

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://api.yelp.com/v3/businesses/" + bizId + "/reviews"))
				.header("Authorization",
						"Bearer mZcjzNFDd09EIysej2EvjSI63VZM4RPFtszVWUaUZda1DyTpFhmqGZmJpblbxG-am1jlLXthARLO4zSTXK531FHsg97m6HLcyPg8Fu_ym_d-qsVlJTWXLRh90JW8YnYx")
				.GET().build();

		response = client.send(request, HttpResponse.BodyHandlers.ofString());
		String jsonString = response.body();

		if (response.statusCode() != 200)
			throw new Exception(jsonString);

		Reviews reviews = gson.fromJson(jsonString, Reviews.class);
		
		//get a list of Reviews
		List<Review> reviewList = reviews.getReviews();

		return reviewList;

	}
}

package it.polito.tdp.Yelp.model;

import java.time.LocalDate;

public class Review {

	private String reviewId;
	private Business business; //Avrei potuto scegliere di rappresentare una stringa: private String businessId;
	private User user; 
	private double stars;
	private LocalDate reviewDate;
	private int votesFunny;
	private int votesUseful;
	private int votesCool;
	private String reviewText;
	
	
	
	
}

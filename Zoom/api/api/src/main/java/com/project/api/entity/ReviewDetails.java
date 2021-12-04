package com.project.api.entity;

import javax.persistence.Entity;

import javax.persistence.Id;


/**
 * @author: Aayush C 
 *  Description:Review Details Entity.
 */

@Entity
public class ReviewDetails {

	@Id
	private int reviewID;
	private String comment;
	private int carId;

	
	@Override
	public String toString() {
		return "ReviewDetails [reviewID=" + reviewID + ", comment=" + comment + ", carId=" + carId + "]";
	}

	public ReviewDetails() {}
	
	public ReviewDetails(int reviewID, String comment, int carId) {
		super();
		this.reviewID = reviewID;
		this.comment = comment;
		this.carId = carId;
	}
	
	public int getReviewID() {
		return reviewID;
	}
	
	public void setReviewID(int reviewID) {
		this.reviewID = reviewID;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	
}

package com.project.backend.entity;

/**
 * 
 * @author Aayush.C
 *
 */

public class Review {

	private int id;

	private String comment;

	private double rating;

	public Review() {
	}

	public Review(String comment, double rating) {
		this.comment = comment;
		this.rating = rating;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", comment=" + comment + ", rating=" + rating + "]";
	}

}

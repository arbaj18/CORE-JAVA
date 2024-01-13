package com.core.classes;

import java.time.LocalDate;

public class Publishing {
	private int id;
	private String title;
	private int price;
	private LocalDate publishedDate;
	private int rating;
	private static int idGenerator;
	public Publishing(String title, int price, LocalDate publishedDate, int rating) {
		super();
		this.id=++idGenerator;
		this.title = title;
		this.price = price;
		this.publishedDate = publishedDate;
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Publishing [id=" + id + ", title=" + title + ", price=" + price + ", publishedDate=" + publishedDate
				+ ", rating=" + rating + "]";
	}

	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public int getPrice() {
		return price;
	}
	public LocalDate getPublishedDate() {
		return publishedDate;
	}
	
	
}

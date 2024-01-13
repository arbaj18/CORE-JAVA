package com.core.classes;

import java.time.LocalDate;

public class Book extends Publishing {
	private int pageCount;

	public Book(String title, int price, LocalDate publishedDate, int rating, int pageCount) {
		super(title, price, publishedDate, rating);
		this.pageCount = pageCount;
	}

	@Override
	public String toString() {
		return "Book " + super.toString() + ", pageCount=" + pageCount + "]";
	}
	
}

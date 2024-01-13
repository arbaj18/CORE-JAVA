package com.core.classes;

import java.time.LocalDate;

public class Tape extends Publishing {
	private int playingTime;

	public Tape(String title, int price, LocalDate publishedDate, int rating, int playingTime) {
		super(title, price, publishedDate, rating);
		this.playingTime = playingTime;
	}

	@Override
	public String toString() {
		return "Tape " + super.toString() + ", playingTime=" + playingTime + "]";
	}

}

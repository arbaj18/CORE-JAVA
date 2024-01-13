package utils;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;

import com.core.classes.Book;
import com.core.classes.Publishing;
import com.core.classes.Tape;

import custom_exception.PublisherException;

public class FunctionalityOfPublisher {
	public static Book addBook(String title, int price, String publishedDate, int rating, int pageCount,Map<String, Publishing>mapPublish)throws PublisherException {
		validateAll(title,rating,mapPublish);
		return new Book(title, price, parseDate(publishedDate), rating, pageCount);
	}
	public static void validateAll(String title,int rating,Map<String, Publishing>mapPublish) throws PublisherException {
		if(mapPublish.containsKey(title))
			throw new PublisherException("Duplicate titles! can't be publish with the same title");
		if(rating<1 || rating>10)
			throw new PublisherException("Out of range rating!!! Rating must be between 1 to 10");
	}
	public static LocalDate parseDate(String publishedDate) {
		LocalDate date = LocalDate.parse(publishedDate);
		return date;
	}
	public static Tape addTape(String title, int price, String publishedDate, int rating, int playingTime,Map<String, Publishing>mapPublish) throws PublisherException {
		validateAll(title,rating,mapPublish);
		return new Tape(title, price, parseDate(publishedDate), rating, playingTime) ;
	}
	public static void displayAllBooks(Map<String, Publishing>mapPublish) {
		mapPublish.values().stream()
		.filter(p-> p instanceof Book)
		.sorted((i1,i2)->i2.getPublishedDate().compareTo(i1.getPublishedDate())).forEach(System.out::println);
	}
	public static void topFivePublication(Map<String, Publishing>mapPublish,int year) {
		mapPublish.values()
		.stream()
		.filter(p->p.getPublishedDate().getYear()==year)
		.sorted((i1,i2)->((Integer)i2.getRating()).compareTo(i1.getRating()))
		.limit(5)
		.forEach(System.out::println);
	}
	public static void removePublication(Map<String, Publishing>mapPublish) {
		mapPublish.values().removeIf(p->Period.between(p.getPublishedDate(), LocalDate.now()).toTotalMonths()>60);
	}
}

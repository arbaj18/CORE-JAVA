package tester;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static utils.FunctionalityOfPublisher.*;

import com.core.classes.Book;
import com.core.classes.Publishing;
import com.core.classes.Tape;

public class PublisherMenu {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)){
			boolean exit=false;
			Map<String, Publishing>mapPublish = new HashMap<String, Publishing>();
			while(!exit) {
				try {
					System.out.println("Choose an option:\n"
							+ "1.publish new book\n"
							+ "2.publish new tape\n"
							+ "3.Display all books sorted by date\n"
							+ "4.Top 5 publication of the year\n"
							+ "5.Remove publication older than 5 year\n"
							+ "0.Exit\n");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter: Title, Price, Published Date, rating, Total Page Numbers");
						Book book = addBook(sc.next(),sc.nextInt(),sc.next(),sc.nextInt(),sc.nextInt(),mapPublish);
						mapPublish.put(book.getTitle(), book);
						System.out.println("Book Published!!!");
						break;
					case 2:
						System.out.println("Enter: Title, price, publishedDate, rating, playingTime");
						Tape tape = addTape(sc.next(),sc.nextInt(),sc.next(),sc.nextInt(),sc.nextInt(),mapPublish);
						mapPublish.put(tape.getTitle(), tape);
						System.out.println("Tape Published!!!!");
						break;
					case 3:
						displayAllBooks(mapPublish);
						break;
					case 4:
						System.out.println("Enter a year");
						int year = sc.nextInt();
						topFivePublication(mapPublish,year);
						break;
					case 5:
						removePublication(mapPublish);
						System.out.println("Publications removed!!!!");
						break;
					case 0:
						exit = true;
						System.out.println("Thanks, Exiting!!!");
						break;
					default:
						System.out.println("Invalid choice");
						break;
					}
				}catch(Exception e) {
					e.printStackTrace();
					sc.nextLine();
					System.out.println("Please try again!!!!");
				}
				
			}
		}

	}

}

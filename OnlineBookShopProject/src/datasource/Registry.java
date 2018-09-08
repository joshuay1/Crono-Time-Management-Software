package datasource;

import java.util.*;

public class Registry {
	private static Map<Integer,BookGateway> booksgateway = new HashMap<Integer,BookGateway>();
	private static Map<Integer,TimeGateway> timegateway = new HashMap<Integer,TimeGateway>();
	public static BookGateway getBook(int id) {	
		return booksgateway.get(id);
		
	}

	public static void addBook(BookGateway bookGateway) {
		booksgateway.put(bookGateway.getId(),bookGateway);
		
	}
	
	
	public static TimeGateway getTime(int id) {	
		return timegateway.get(id);
		
	}

	public static void addTime(TimeGateway timeGateway) {
		timegateway.put(timeGateway.getId(),timeGateway);
		
	}

}

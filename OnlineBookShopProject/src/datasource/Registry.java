package datasource;

import java.util.*;

public class Registry {
	private static Map<Integer,BookGateway> booksgateway = new HashMap<Integer,BookGateway>();
	public static BookGateway getBook(int id) {	
		return booksgateway.get(id);
		
	}

	public static void addBook(BookGateway bookGateway) {
		booksgateway.put(bookGateway.getId(),bookGateway);
		
	}

}

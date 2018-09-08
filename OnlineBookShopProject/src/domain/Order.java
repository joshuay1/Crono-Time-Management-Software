package domain;

import java.util.Map;
import java.util.UUID;

public class Order {

    private UUID id;
    
    private Map<Book, Integer> bookCopies;

    private Customer orderedBy;

    private float totalPrice;
    
    public Order(Map<Book, Integer> bookCopies, Customer orderedBy) {
        this.bookCopies = bookCopies;
        this.orderedBy = orderedBy;
    }

    public Map<Book, Integer> getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(Map<Book, Integer> bookCopies) {
        this.bookCopies = bookCopies;
    }

    public Customer getOrderedBy() {
        return orderedBy;
    }

    public void setOrderedBy(Customer orderedBy) {
        this.orderedBy = orderedBy;
    }

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
}

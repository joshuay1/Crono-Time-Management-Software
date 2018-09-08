package domain;


import java.util.List;

public class Customer {

    private String email;

    private String name;

    private String address;

    private List<Order> orders;

    private ShoppingCart cart;

    public Customer(String email, String name, String address, List<Order> orders, ShoppingCart cart) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.orders = orders;
        this.cart = cart;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }
}

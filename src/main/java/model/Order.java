package model;

/**
 * Created by ivan on 03.08.17.
 */
public class Order {

    private int id;
    private Address from;
    private Address to;
    private OrderState orderState;
    private int price;
    private double distance;
    private User client;
    private Driver driver;

    public Order() {
    }

    public Order(int id, Address from, Address to,
                 OrderState orderState, int price,
                 double distance, User client, Driver driver) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.orderState = orderState;
        this.price = price;
        this.distance = distance;
        this.client = client;
        this.driver = driver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        return id == order.id;
    }

    @Override
    public int hashCode() {
        return id * 51;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", from=" + from +
                ", to=" + to +
                ", orderState=" + orderState +
                ", price=" + price +
                ", distance=" + distance +
                ", client=" + client +
                ", driver=" + driver +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Address getFrom() {
        return from;
    }

    public void setFrom(Address from) {
        this.from = from;
    }

    public Address getTo() {
        return to;
    }

    public void setTo(Address to) {
        this.to = to;
    }

    public OrderState getOrderState() {
        return orderState;
    }

    public void setOrderState(OrderState orderState) {
        this.orderState = orderState;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}

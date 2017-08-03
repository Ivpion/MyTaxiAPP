package model;

/**
 * Created by ivan on 03.08.17.
 */
public class Order {

    private int id;
    private Address from;
    private Address to;
    private OrderState orderState;
    private double price;
    private double distance;
    private User client;
    private Driver driver;

    public Order() {
    }

    public Order(int id, Address from, Address to,
                 OrderState orderState, double price,
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
}

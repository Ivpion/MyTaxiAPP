package model;

/**
 * Created by ivan on 03.08.17.
 */
public class Order {

    private static final int MIN_PRISE = 30;
    private static final int PRISE_FOR_KM = 5;

    private int id;
    private Address from;
    private Address to;
    private OrderState orderState;
    private int price = 0;
    private double distance;
    private Client client;
    private Driver driver;

    public Order() {
    }

    public Order(int id, Address from, Address to,
                 OrderState orderState, int price,
                 double distance, Client client, Driver driver) {
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

    public void setPrice() {
        this.price = MIN_PRISE + ((int)distance+1) * PRISE_FOR_KM;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distanceInKM) {
        this.distance = distanceInKM;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}

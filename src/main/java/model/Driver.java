package model;

/**
 * Created by ivan on 03.08.17.
 */
public class Driver extends User {

    private int id;
    private String name;
    private String phone;
    private Car car;
    private double money;
    private String pass;

    public Driver() {
    }

    public Driver(int id, String name, String phone, Car car, double money, String pass) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.car = car;
        this.money = money;
        this.pass = pass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Driver driver = (Driver) o;

        return id == driver.id;
    }

    @Override
    public int hashCode() {
        return id * 31;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Car getCar() {
        return car;
    }

    public double getMoney() {
        return money;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", car=" + car +
                ", money=" + money +
                '}';
    }
}

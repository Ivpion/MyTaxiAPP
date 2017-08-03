package model;

/**
 * Created by ivan on 03.08.17.
 */
public class Car {

    private String color;
    private String carNumber;
    private String model;

    public Car() {
    }

    public Car(String color, String carNumber, String model) {
        this.color = color;
        this.carNumber = carNumber;
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", carNumber='" + carNumber + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}

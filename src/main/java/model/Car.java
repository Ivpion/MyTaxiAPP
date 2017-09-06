package model;

/**
 * Created by ivan on 03.08.17.
 */
public class Car {

    private CarColor color;
    private String carNumber;
    private String model;

    public Car() {
    }

    public Car(CarColor color, String carNumber, String model) {
        this.color = color;
        this.carNumber = carNumber;
        this.model = model;
    }

    public CarColor getColor() {
        return color;
    }

    public void setColor(CarColor color) {
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

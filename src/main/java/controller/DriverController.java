package controller;

import db.AppDB;
import exception.AppException;
import exception.LoginCredentialException;
import exception.RegisterException;
import model.Car;
import model.Driver;
import model.Order;
import validator.Validator;

/**
 * Created by ivan on 30.08.17.
 */
public class DriverController implements IDriverController {

    private AppDB appDB = new AppDB();
    private Validator validator = new Validator();


    @Override
    public Driver register(String login, String pass, String phone, Car car) throws RegisterException {
        return null;
    }

    @Override
    public String login(String login, String pass) throws LoginCredentialException {
        return null;
    }

    @Override
    public Order takeOrder(Order orderRequest, String accessToken) throws AppException {
        return null;
    }

    @Override
    public Order finishOrder(Order tookOrder, String accessToken) throws AppException {
        return null;
    }

    @Override
    public Car changeCar(Car newCar) throws AppException {
        return null;
    }
}

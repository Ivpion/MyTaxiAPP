package controller;

import exception.AppException;
import exception.LoginCredentialException;
import exception.RegisterException;
import model.Car;
import model.Driver;
import model.Order;

/**
 * Created by ivan on 30.08.17.
 */
public interface IDriverController {

    Driver register(String login, String pass, String phone, Car car) throws RegisterException;

    String login(String login, String pass) throws LoginCredentialException;

    Order takeOrder(Order orderRequest, String accessToken) throws AppException;

    Order finishOrder(Order tookOrder, String accessToken)throws AppException;

    Car changeCar(Car newCar) throws AppException;
}

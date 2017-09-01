package controller;

import exception.AppException;
import exception.LoginCredentialException;
import exception.RegisterException;
import model.*;
import validator.Validator;

import static controller.UserController.appDB;

/**
 * Created by ivan on 30.08.17.
 */
public class DriverController implements IDriverController {


    private Validator validator = new Validator();


    @Override
    public Driver register(String login, String pass, String phone, Car car) throws RegisterException {
        if (validator.validateRegistration(login,phone,pass)){
            Driver driver = new Driver();
            driver.setName(login);
            driver.setPass(pass);
            driver.setPhone(phone);
            driver.setCar(car);
            return appDB.addDriver(driver);
        } else {
            throw new RegisterException("don`t validate input, try again");
        }
    }

    @Override
    public String login(String login, String pass) throws LoginCredentialException {
        Driver driver = new Driver();
        driver.setName(login);
        driver.setPass(pass);
        String accessToken = appDB.createAccessToken(driver);

        return accessToken;
    }

    @Override
    public Order takeOrder(Order orderRequest, String accessToken) throws AppException {
        if (orderRequest.getDriver() == null && orderRequest.getOrderState() == OrderState.NEW){
            orderRequest.setDriver((Driver) appDB.getUserByToken(accessToken));
            orderRequest.setOrderState(OrderState.INPROGRES);
        }
        return orderRequest;
    }

    @Override
    public Order finishOrder(Order tookOrder, String accessToken) throws AppException {
        if (!appDB.hasToken(accessToken)){
            throw new AppException("no Access, Login first");
        }
        tookOrder.setOrderState(OrderState.DONE);
        return tookOrder;
    }

    @Override
    public Car changeCar(Car newCar, String accessToken) throws AppException {
        Driver driver = (Driver) appDB.getUserByToken(accessToken);
        driver.setCar(newCar);
        return driver.getCar();
    }

}

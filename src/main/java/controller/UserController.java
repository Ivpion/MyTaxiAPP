package controller;

import db.AppDB;
import exception.*;
import model.*;
import validator.IValidator;
import validator.Validator;

import java.util.List;

/**
 * Created by ivan on 17.08.17.
 */
public class UserController implements IUserController {

    private AppDB appDB = new AppDB();
    IValidator validator = new Validator();

    public UserController() {
    }

    public UserController(AppDB appDB) {
        this.appDB = appDB;
    }

    @Override
    public User register(String login, String pass, String phone) throws RegisterException {
        if (validator.validateRegistration(login,phone,pass)){
        User user = new User();
        user.setName(login);
        user.setPass(pass);
        user.setPhone(phone);
        return appDB.addUser(user);
        } else {
            throw new RegisterException("don`t validate input, try again");
        }

    }

    @Override
    public String login(String login, String pass) throws LoginCredentialException {
        User user = new User();
        user.setName(login);
        user.setPass(pass);
        String accesToken = appDB.createAccessToken(user);

        return accesToken;
    }

    @Override
    public Address checkAddress(String stree, String num, String accessToken) throws InvalidAddressInfoException {
        // google API
        return null;
    }

    @Override
    public Order makeOrder(Order orderRequest, double price, String accessToken) throws AppException {
        if (!appDB.hasToken(accessToken)){
            throw new AppException("no access, login first");
        }

        //validation
        // business logic
        // check address
        // count distance
        // count price
        Order order = appDB.addOrder(orderRequest);
        return order;
    }

    @Override
    public Order getOrderInfo(Integer id, String accessToken) throws AppException {
        if (!appDB.hasToken(accessToken)) {
            throw new AppException("no Access, Login first");
        }
        return appDB.getOrderById(id);
    }

    @Override
    public String cancelOrder(Integer orderId, String accessToken) throws AppException{
       Order order = getOrderInfo(orderId, accessToken);

       Order found = appDB.cancelOrder(orderId);
       if (found == null){
           throw new NoOrderFoundException("no order with id" + orderId);
       }
       found.setOrderState(OrderState.CANCEL);
        Driver drived = found.getDriver();
        return "canceled order";
    }

    @Override
    public List<Order> showHistory(String accessToken) throws AppException {
        return null;
    }

    @Override
    public Order findDriver(Order order, String accessToken) throws AppException {
        if (!appDB.hasToken(accessToken)){
            throw new AppException("no Access, Login first");
        }
        return null;
    }
}

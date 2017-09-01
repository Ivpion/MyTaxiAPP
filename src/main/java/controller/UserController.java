package controller;

import db.AppDB;
import exception.*;
import geolocation.GoogleMaps;
import model.*;
import validator.IValidator;
import validator.Validator;

import java.util.List;

/**
 * Created by ivan on 17.08.17.
 */
public class UserController implements IUserController {

    protected static AppDB appDB = new AppDB();
    private IValidator validator = new Validator();
    private GoogleMaps geoloc = new GoogleMaps();

    public UserController() {
    }

    public UserController(AppDB appDB) {
        this.appDB = appDB;
    }

    @Override
    public Client register(String login, String pass, String phone) throws RegisterException {
        if (validator.validateRegistration(login,phone,pass)){
        Client client = new Client();
        client.setName(login);
        client.setPass(pass);
        client.setPhone(phone);
        return appDB.addClient(client);
        } else {
            throw new RegisterException("don`t validate input, try again");
        }

    }

    @Override
    public String login(String login, String pass) throws LoginCredentialException {
        Client client = new Client();
        client.setName(login);
        client.setPass(pass);
        String accesToken = appDB.createAccessToken(client);

        return accesToken;
    }

    @Override
    public boolean checkAddress(Address address, String accessToken) throws AppException {
        if (!appDB.hasToken(accessToken)){
            throw new AppException("no access, login first");
        }

            if (new GoogleMaps().getAddressFormatetPoint(address) != null){
                return true;
            } else {
                throw new InvalidAddressInfoException("invalidate address, please choose address again");
            }


    }


    @Override
    public Order makeOrder(Address from, Address to, String accessToken) throws AppException {
        Order newOrder = new Order();
        if (!appDB.hasToken(accessToken)){
            throw new AppException("no access, login first");
        }
        if (checkAddress(to, accessToken) && checkAddress(from, accessToken)){
            newOrder.setTo(to);
            newOrder.setFrom(from);
            double distanceInKM = geoloc.getDistanceBetweenTwoPoints(to,from);
            distanceInKM = distanceInKM/1000;
            newOrder.setDistance(distanceInKM);
            newOrder.setPrice();
            newOrder.setOrderState(OrderState.NEW);
            newOrder.setClient((Client) appDB.getUserByToken(accessToken));
        }


        //validation
        // business logic
        // check address
        // count distance
        // count price
        newOrder = appDB.addOrder(newOrder);
        return newOrder;
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
        return appDB.getAllHistory();
    }

    @Override
    public Order findDriver(Order order, String accessToken) throws AppException {
        if (!appDB.hasToken(accessToken)){
            throw new AppException("no Access, Login first");
        }
        return null;
    }
}

package controller;

import exception.AppException;
import exception.LoginCredentialException;
import exception.NoOrderFoundException;
import exception.RegisterException;
import model.Address;
import model.Order;
import model.Client;

import java.util.List;

/**
 * Created by ivan on 16.08.17.
 */
public interface IUserController {

    Client register(String login, String pass, String phone) throws RegisterException;
    // access token
    String login(String login, String pass) throws LoginCredentialException;

    boolean checkAddress(Address address, String accessToken) throws AppException;

    Order makeOrder(Address from, Address to, String accessToken) throws AppException;

    Order getOrderInfo(Integer id, String accessToken) throws AppException;

    String cancelOrder(Integer orderId, String accessToken) throws AppException, NoOrderFoundException;

    List<Order> showHistory(String accessToken) throws AppException;

    Order findDriver(Order order, String accessToken) throws AppException;
}

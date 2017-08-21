package controller;

import exception.*;
import model.Address;
import model.Order;
import model.User;

import java.util.List;

/**
 * Created by ivan on 16.08.17.
 */
public interface IUserController {

    User register(String login, String pass, String phone) throws RegisterException;
    // access token
    String login(String login, String pass) throws LoginCredentialException;

    Address checkAddress(String stree, String num, String accessToken) throws InvalidAddressInfoException;

    Order makeOrder(Order orderRequest, double price, String accessToken) throws AppException;

    Order getOrderInfo(Integer id, String accessToken) throws AppException;

    String cancelOrder(Integer orderId, String accessToken) throws AppException, NoOrderFoundException;

    List<Order> showHistory(String accessToken) throws AppException;

    Order findDriver(Order order, String accessToken) throws AppException;
}

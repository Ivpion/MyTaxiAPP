package db;

import exception.LoginCredentialException;
import model.Client;
import model.Order;
import model.User;

import java.util.*;


public class AppDB {

    private static int userCountId = 0;
    private static int  orderIdCount = 0;

    private Map<String, User> accessTokenUserMap;
    private Map<Integer, User> userMap;
    private Map<Integer, Order> ordersMap;
    private List<Order> newOrders;
    private List<Order> history;


    public AppDB(){
        userMap = new HashMap<>();
        accessTokenUserMap = new HashMap<>();
        ordersMap = new HashMap<>();
        history = new ArrayList<>();
        newOrders = new LinkedList<>();


    }

    public Client addUser(Client client){
        client.setId(userCountId);
        userMap.put(userCountId, client);
        userCountId++;
        return client;
    }

    //login
    public String createAccessToken(User user) throws LoginCredentialException {
       User found = userMap.values().stream().filter(
                u -> u.getName().equals(user.getName()) && u.getPass().equals(user.getPass())).
               findFirst().get();
        String accessKey = UUID.randomUUID().toString();
        accessTokenUserMap.put(accessKey, found);
        return accessKey;

    }

    public Order addOrder(Order order){
        order.setId(orderIdCount);
        ordersMap.put(orderIdCount, order);
        newOrders.add(order);
        orderIdCount++;

        return order;
    }

    public Order getOrderById(int id){
        return ordersMap.get(id);
    }

    public boolean hasToken(String accessToken){
        return accessTokenUserMap.containsKey(accessToken);

    }

    public List<Order> getAllHistory(){
        return history;
    }

    public Order cancelOrder(int id){
        Order order = ordersMap.get(id);

        return ordersMap.remove(id);
    }
    public User getClientByToken(String accessToken){
        return accessTokenUserMap.get(accessToken);
    }
}

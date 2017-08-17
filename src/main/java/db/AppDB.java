package db;

import exception.LoginCredentialException;
import model.Order;
import model.User;

import java.util.*;


public class AppDB {

    private int userCoutId = 0;
    private int orderIdCount = 0;

    private Map<String, User> accessTokenUserMap;
    private Map<Integer, User> userMap;
    private Map<Integer, Order> ordersMap;
    private List<Order> orders;
    private List<Order> history;


    public AppDB(){
        userMap = new HashMap<>();
        accessTokenUserMap = new HashMap<>();
        ordersMap = new HashMap<>();
        history = new ArrayList<>();
        orders = new LinkedList<>();


    }

    public User addUser(User user){
        user.setId(userCoutId);
        userMap.put(userCoutId, user);
        userCoutId++;
        return user;
    }

    //login
    public String createAccessToken(User user) throws LoginCredentialException {
       User found = userMap.values().stream().filter(
                u -> u.getPhone().equals(user.getPhone()) && u.getPass().equals(user.getPass())).
               findFirst().get();
       if (found == null){
           throw new LoginCredentialException("invalid login or pass");
       } else {
           String accessKey = UUID.randomUUID().toString();
           accessTokenUserMap.put(accessKey, found);
           return accessKey;
       }

    }

    public Order addOrder(Order order){
        order.setId(orderIdCount);
        ordersMap.put(orderIdCount, order);
        orders.add(order);
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


}

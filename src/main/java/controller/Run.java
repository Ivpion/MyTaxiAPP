package controller;

import db.AppDB;
import exception.AppException;
import exception.RegisterException;
import model.Address;
import model.Order;

/**
 * Created by ivan on 02.08.17.
 */
public class Run {
    public static void run(){

        Address firstAddress = new Address("київ", "Борщагівська", "146");
        Address secondAddress = new Address("Kyiv", "Ushakova", "142");
        UserController controller = new UserController(new AppDB());
        try {
            controller.register("Ivanpion", "qwerty", "(097)-732-32-32");
            System.out.println("check");
        } catch (RegisterException e) {
            e.printStackTrace();
        }
        try {
           String accessToken = controller.login("Ivanpion", "qwerty");
            System.out.println("check");
            Order order = controller.makeOrder(firstAddress,secondAddress,accessToken);
            System.out.println(order.toString());
            System.out.println(controller.showHistory(accessToken).toString());
        } catch (AppException e) {
            e.printStackTrace();
        }
    }
}

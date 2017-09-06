package model;

/**
 * Created by ivan on 30.08.17.
 */
public class User {
    private int id;
    private String name;
    private String phone;
    private String pass;

    public User(int id, String name, String phone, String pass) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public User() {
    }
}

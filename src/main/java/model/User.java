package model;

/**
 * Created by ivan on 02.08.17.
 */
public class User {
    private int id;
    private String name;
    private String phone;
    private String pass;

    public User() {
    }

    public User(int id, String name, String phone, String pass) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.pass = pass;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return id == user.id;

    }

    @Override
    public int hashCode() {
        return id * 17;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

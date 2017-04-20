package vn.com.winta.quan.mvp_retrofit.Model;

/**
 * Created by QWAN on 20/04/2017.
 */

public class User {
    @com.google.gson.annotations.SerializedName("user")
    private String user;
    @com.google.gson.annotations.SerializedName("pass")
    private String pass;

    public User() {
    }

    public User(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" +
                "user='" + user + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}

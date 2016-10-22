package example.com.jam;

/**
 * Created by Shane on 10/22/2016.
 */

public class User {
    private int rating = 0;
    private String uName = " ";
    private String contact = " ";
    private String desc = " ";
    // image file?

    public User() {
    }

    public User(String n) {
        uName = n;
    }

    public User(String n, String c) {
        uName = n;
        contact = c;
    }

    public User(String n, String c, String d) {
        uName = n;
        contact = c;
        desc = d;
    }

    public void setRating(int r) {
        rating = r;
    }

    public int getRating() {
        return rating;
    }

    public void setuName(String n) {
        uName = n;
    }

    public String getuName() {
        return uName;
    }

    public void setContact(String c) {
        contact = c;
    }

    public String getContact() {
        return contact;
    }

    public void setDesc(String d) {
        desc = d;
    }

    public String getDesc() {
        return desc;
    }
}

package example.com.jam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Shane on 10/22/2016.
 */

public class User {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date;
    private int rating = 0;
    private String fName = " ";
    private String lName = " ";
    private String contact = " ";
    private String desc = " ";
    private UUID mId;
    // image file?

    public User() {
    }

    public User(String n, String l) {
        fName = n;
        lName = l;
        contact = " ";
        desc = " ";
        date = new Date();
    }

    public User(String n, String l,  String c) {
        fName = n;
        lName = l;
        contact = c;
        desc = " ";
        date = new Date();
    }

    public User(String n, String l ,String c, String d) {
        fName = n;
        lName = l;
        contact = c;
        desc = d;
        date = new Date();
    }

    public void setRating(int r) {
        rating = r;
    }

    public int getRating() {
        return rating;
    }

    public void setfName(String n) {
        fName = n;
    }

    public void setlName(String l) {
        lName = l;
    }

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
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

    public Date getDate() { return date; }
}
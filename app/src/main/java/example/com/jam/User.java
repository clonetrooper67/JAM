package example.com.jam;

import java.io.File;
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
    private int mKarma = 0;
    private String fName;
    private String lName;
    private String contact;
    private String desc;
    private UUID mId;
    private File mProfileImage;

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

    public void setKarma(int r) {
        mKarma = r;
    }

    public int getKarma() {
        return mKarma;
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

    public UUID getId() {
        return mId;
    }

    public void setId(UUID mId) {
        this.mId = mId;
    }

    public File getProfileImage() {
        return mProfileImage;
    }

    public void setProfileImage(File mProfileImage) {
        this.mProfileImage = mProfileImage;
    }
}
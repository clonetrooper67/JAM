package example.com.jam;

import java.util.UUID;

/**
 * Created by ninjo on 10/22/2016.
 */

public class Post {
    private String body;
    private int karma;
    private String user;
    private String imgPath;

    public Post() {}

    public Post(String bodyIn, String userIn) {
        this.body = bodyIn;
        this.karma = 0;
        this.user = userIn;
    }
    public Post(String bodyIn, String userIn, String postImagePath) {
        this.body = bodyIn;
        this.karma = 0;
        this.user = userIn;
        this.imgPath = postImagePath;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getKarma() {
        return karma;
    }

    public void setKarma(int karma) {
        this.karma = karma;
    }

}

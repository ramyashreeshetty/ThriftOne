package com.mad.thriftone;

public class Messages6 {

    //Model Class

    String name;
    String imageUrl;
    String instaUrl;

    //constructors

    public Messages6(){

    }

    public Messages6(String name, String imageUrl, String instaUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.instaUrl = instaUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getInstaUrl() {
        return instaUrl;
    }

    public void setInstaUrl(String instaUrl) {
        this.instaUrl = instaUrl;
    }
}

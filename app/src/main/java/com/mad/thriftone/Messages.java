package com.mad.thriftone;

public class Messages {

    //Model Class

    String name;
    String imageUrl;
    String instaUrl;

    //constructors

    public Messages(){

    }

    public Messages(String name, String imageUrl, String instaUrl) {
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

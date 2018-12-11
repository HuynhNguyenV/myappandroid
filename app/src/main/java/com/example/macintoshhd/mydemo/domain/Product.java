package com.example.macintoshhd.mydemo.domain;

public class Product {

    String title, brief;
    int coverImage;

    public Product() {
    }

    public Product(String title, String brief, int coverImage) {
        this.title = title;
        this.brief = brief;
        this.coverImage = coverImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public int getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(int coverImage) {
        this.coverImage = coverImage;
    }
}

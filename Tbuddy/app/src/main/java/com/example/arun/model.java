package com.example.arun;

public class model {

    private int id;
    private String title;
    private String image;
    private String placename;

    public model(int id, String title, String image, String placename) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.placename = placename;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPlacename() {
        return placename;
    }

    public void setPlacename(String placename) {
        this.placename = placename;
    }
}
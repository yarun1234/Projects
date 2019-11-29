package com.example.arun.Hotel_module;

public class hmodel {


        private int id;
        private String title;
        private String shortdesc;
        private String rating;
        private double price;
        private String image;




        public hmodel(int id, String title, String shortdesc, String rating, double price, String image) {
            this.id = id;
            this.title = title;
            this.shortdesc = shortdesc;
            this.rating = rating;
            this.price = price;
            this.image = image;

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

    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}


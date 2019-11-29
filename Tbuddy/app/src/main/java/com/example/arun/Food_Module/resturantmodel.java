package com.example.arun.Food_Module;

public class resturantmodel {
    private String rating;
    private String restaurantname;
    private String restDescription;
    private String image;


    public resturantmodel(String rating, String restaurantname, String restDescription, String image) {
        this.rating = rating;
        this.restaurantname = restaurantname;
        this.restDescription = restDescription;
        this.image = image;

    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRestaurantname() {
        return restaurantname;
    }

    public void setRestaurantname(String restaurantname) {
        this.restaurantname = restaurantname;
    }

    public String getRestDescription() {
        return restDescription;
    }

    public void setRestDescription(String restDescription) {
        this.restDescription = restDescription;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



}

package com.example.arun.Food_Module;

public class Foodmodel {

    String Menuname;
    String MenuImage;
    String catID;
    public Foodmodel(String menuname, String menuImage, String catID) {
        this.Menuname = menuname;
        this.MenuImage = menuImage;
        this.catID=catID;
    }

    public String getMenuname() {
        return Menuname;
    }

    public void setMenuname(String menuname) {
        Menuname = menuname;
    }

    public String getMenuImage() {
        return MenuImage;
    }

    public void setMenuImage(String menuImage) {
        MenuImage = menuImage;
    }

    public String getCatID() {
        return catID;
    }

    public void setCatID(String catID) {
        this.catID = catID;
    }
}

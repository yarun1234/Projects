package com.example.arun.Food_Module;

public class menumodel {
    String Itemname,Itemimage,MenuID,Itemprice;

    public menumodel(String itemname, String itemimage, String menuID, String itemprice) {
        Itemname = itemname;
        Itemimage = itemimage;
       Itemprice = itemprice;
        MenuID = menuID;

    }

    public String getItemname() {
        return Itemname;
    }

    public void setItemname(String itemname) {
        Itemname = itemname;
    }

    public String getItemimage() {
        return Itemimage;
    }

    public void setItemimage(String itemimage) {
        Itemimage = itemimage;
    }

    public String getMenuID() {
        return MenuID;
    }

    public void setMenuID(String menuID) {
        MenuID = menuID;
    }

    public String getItemprice() {
        return Itemprice;
    }

    public void setItemprice(String itemprice) {
        Itemprice = itemprice;
    }
}

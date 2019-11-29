package com.example.arun.Hotel_module;

public class hoteluser {
    public hoteluser(String cidate, String codate, String fname, String lname, String preference, String email, String contact) {
        this.cidate = cidate;
        this.codate = codate;
        this.fname = fname;
        this.lname = lname;
        this.preference = preference;
        this.email = email;
        this.contact = contact;

    }

    private String cidate,codate,fname,lname,preference,email,contact,dfname,dlname,cardnumber,exdatem,exdatey;

    public String getCidate() {
        return cidate;
    }

    public void setCidate(String cidate) {
        this.cidate = cidate;
    }

    public String getCodate() {
        return codate;
    }

    public void setCodate(String codate) {
        this.codate = codate;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

}

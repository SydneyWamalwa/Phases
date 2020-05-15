package com.example.phases;

public class uploadinfo {
    public String MProductname;
    public String MProductdescription;
    public String MProductprice;
    public String MMimageURL;

    public uploadinfo(){

    }

    public uploadinfo(String prod_name,String prod_desc,String prod_price, String url) {
        MProductname=prod_name;
        MProductdescription=prod_desc;
        MProductprice=prod_price;
        MMimageURL=url;
    }

    public String getMProductname() {
        return MProductname;
    }

    public void setMProductname(String prod_name) {
        MProductname = prod_name;
    }

    public String getMProductdescription() {
        return MProductdescription;
    }

    public void setMProductdescription(String prod_desc) {
        MProductdescription = prod_desc;
    }

    public String getMProductprice() {
        return MProductprice;
    }

    public void setMProductprice(String prod_price) {
        MProductprice = prod_price;
    }

    public String getMMimageURL() {
        return MMimageURL;
    }

    public void setMMimageURL(String url) {
        MMimageURL = url;
    }
}


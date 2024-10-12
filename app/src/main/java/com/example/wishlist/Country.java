package com.example.wishlist;

public class Country {
    private String name;
    private String flag;
    private String country;
    private boolean checkbox;

    public Country(String name, String flag, String country) {
        this.name = name;
        this.flag = flag;
        this.country = country;
        this.checkbox = checkbox;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isCheckbox() {
        return checkbox;
    }

    public void setCheckbox(boolean checkbox) {
        this.checkbox = checkbox;
    }
}



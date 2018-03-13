package com.example.thoailun.demo;


/**
 * Created by THOAILUN on 03/13/18.
 */

public class Staff {
    private String staffUsername;
    private  Integer staffImage;
    public  Staff(String s_un, Integer s_img) {
        staffUsername = s_un;
        staffImage = s_img;
    }

    public String getStaffUsername() {
        return staffUsername;
    }

    public void setStaffUsername(String staffUsername) {
        this.staffUsername = staffUsername;
    }

    public Integer getStaffImage() {
        return staffImage;
    }

    public void setStaffImage(Integer staffImage) {
        this.staffImage = staffImage;
    }
}

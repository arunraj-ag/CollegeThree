package com.example.college.HelperClasses.HomeAdapter;

public class DeptHelperClass {
    int image;
    String title,desc;

    public DeptHelperClass(int image, String title, String desc) {
        this.image = image;
        this.title = title;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}

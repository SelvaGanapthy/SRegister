package com.example.dell.sregister;

/**
 * Created by Dell on 4/11/2017.
 */

public class Register {
    String uname = "", udob = "", umob = "", ucity = "";

    public void getuname(String uname) {
        this.uname = uname;
    }

    public void getudob(String udob) {
        this.udob = udob;
    }

    public void getumob(String umob) {
        this.umob = umob;
    }

    public void getucity(String ucity) {
        this.ucity = ucity;
    }

    public String setuname() {
        return uname;
    }

    public String setudob() {
        return udob;
    }

    public String setumob() {
        return umob;
    }

    public String setucity() {
        return ucity;
    }
}

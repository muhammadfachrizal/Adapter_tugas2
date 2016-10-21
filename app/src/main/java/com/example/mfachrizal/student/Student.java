package com.example.mfachrizal.student;
import java.util.ArrayList;
import java.io.Serializable;
/**
 * Created by M. FACHRIZAL on 10/7/2016.
 */
public class Student implements Serializable{
    private int id;
    private String noreg;
    private String nama;
    private String mail;
    private String phone;


    public Student(int id, String noreg,String nama, String mail, String phone){
        this.setId(id);
        this.setNoreg(noreg);
        this.setNama(nama);
        this.setMail(mail);
        this.setPhone(phone);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoreg() {
        return noreg;
    }

    public void setNoreg(String noreg) {
        this.noreg = noreg;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



}

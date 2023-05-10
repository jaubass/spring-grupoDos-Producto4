package com.GrupoDos.producto4.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "restaurantes")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String adress;
    private String city;
    private String postalCode;
    private String web;
    private String image="no-image.png";


    public Restaurant() {}

    public Restaurant(Long id, String name, String email, String phone, String adress, String city, String postalCode, String web) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.adress = adress;
        this.city = city;
        this.postalCode = postalCode;
        this.web = web;
    }

    public Restaurant(Long id, String name, String email, String phone, String adress, String city, String postalCode, String web, String image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.adress = adress;
        this.city = city;
        this.postalCode = postalCode;
        this.web = web;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

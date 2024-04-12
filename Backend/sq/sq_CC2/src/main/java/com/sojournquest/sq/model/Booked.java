package com.sojournquest.sq.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToOne;


@Entity
public class Booked {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long hotelId;
    private String hotelName;
    private String description;
    private String roomTypes;
    private String city;
   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;
    public Booked() {
    }
    
    public Booked(Long hotelId, String hotelName, String description, String roomTypes, String city, User user) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.description = description;
        this.roomTypes = roomTypes;
        this.city = city;
        this.user = user;
    }

    public Long getHotelId() {
        return hotelId;
    }
    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }
    public String getHotelName() {
        return hotelName;
    }
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getRoomTypes() {
        return roomTypes;
    }
    public void setRoomTypes(String roomTypes) {
        this.roomTypes = roomTypes;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

     
        
}

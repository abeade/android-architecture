package com.abeade.android.architecture.testapp.data.network.model.response;

import com.google.gson.annotations.SerializedName;

public class UserDto {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("address")
    private String address;
    @SerializedName("bio")
    private String bio;
    @SerializedName("image")
    private String image;

    public UserDto() {
    }

    public UserDto(int id, String name, String email, String address, String bio, String image) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.bio = bio;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

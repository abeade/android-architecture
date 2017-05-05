package com.abeade.android.architecture.testapp.domain.model;

public class UserViewItem {
    private int id;
    private String name;
    private String email;
    private String address;
    private String bio;
    private String image;

    public UserViewItem() {
    }

    public UserViewItem(int id, String name, String email, String address, String bio, String image) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserViewItem that = (UserViewItem) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}

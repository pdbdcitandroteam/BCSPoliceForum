package com.cit.bcspoliceforum.database;

/**
 * Created by Hi on 17-Jan-16.
 */
public class HolderContact {
    private int id = -1;
    private String displayId, name, father, mother, address, phone, email, position, posting, bloodGroup, photo;
    private boolean claimed = false;
    private String password, verificationCode;
    private boolean verified = false;

    public HolderContact() {
    }

    public HolderContact(int id, String displayId, String name, String father, String mother, String address, String phone, String email, String position, String posting, String bloodGroup, String photo, boolean claimed, String password, String verificationCode, boolean verified) {
        this.id = id;
        this.displayId = displayId;
        this.name = name;
        this.father = father;
        this.mother = mother;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.position = position;
        this.posting = posting;
        this.bloodGroup = bloodGroup;
        this.photo = photo;
        this.claimed = claimed;
        this.password = password;
        this.verificationCode = verificationCode;
        this.verified = verified;
    }

    public HolderContact(String displayId, String name, String father, String mother, String address, String phone, String email, String position, String posting, String bloodGroup, String photo, boolean claimed, String password, String verificationCode, boolean verified) {
        this.displayId = displayId;
        this.name = name;
        this.father = father;
        this.mother = mother;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.position = position;
        this.posting = posting;
        this.bloodGroup = bloodGroup;
        this.photo = photo;
        this.claimed = claimed;
        this.password = password;
        this.verificationCode = verificationCode;
        this.verified = verified;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisplayId() {
        return displayId;
    }

    public void setDisplayId(String displayId) {
        this.displayId = displayId;
    }

    public String getName() {
        return name;
    }

    public HolderContact setName(String name) {
        this.name = name;
        return this;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosting() {
        return posting;
    }

    public void setPosting(String posting) {
        this.posting = posting;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isClaimed() {
        return claimed;
    }

    public void setClaimed(boolean claimed) {
        this.claimed = claimed;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}

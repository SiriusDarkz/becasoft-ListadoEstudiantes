package Model.entities;

import java.io.Serializable;

public class Student implements Serializable {

    private String fullName;
    private String career;
    private String gender;
    private String address;
    private String dateOfBirth;
    private int img;


    public Student() {

    }

    public Student(String fullName, String career, String gender, String address, String dateOfBirth, int img) {
        this.fullName = fullName;
        this.career = career;
        this.gender = gender;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.img = img;
    }

    public String getFullName() {
        return fullName;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
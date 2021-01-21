package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Directory implements Serializable {
    private String phoneNumber;
    private String group;
    private String name;
    private Gender gender;
    private String address;
    private LocalDate birthday;
    private String email;

    public Directory() {
    }
    public Directory withPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
        return this;
    }
    public Directory withGroup(String group){
        this.group=group;
        return this;
    }
    public Directory withName(String name){
        this.name=name;
        return this;
    }
    public Directory withGender(Gender gender){
        this.gender=gender;
        return this;
    }
    public Directory withAddress(String address){
        this.address=address;
        return this;
    }
    public Directory withBirthday(LocalDate birthday){
        this.birthday=birthday;
        return this;
    }
    public Directory withEmail(String email){
        this.email=email;
        return this;
    }
    public Directory build(){
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public Gender getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", group='" + group + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                '.'+"\n";
    }
}

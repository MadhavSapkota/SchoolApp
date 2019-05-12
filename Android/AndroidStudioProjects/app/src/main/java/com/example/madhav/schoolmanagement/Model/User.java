package com.example.madhav.schoolmanagement.Model;

public class User {


    private String firstName;
    private String lastName;
    private  String username;
    private String password;
    private String user_type;
    private String birthdate;
    private String address;
    private String email;
    private String phone;
    private String sex;


//    public Student () {
//
//    }



    public User ( ) {
    }

    public User (String firstName , String lastName , String username , String password ,String email,
                 String user_type , String birthdate , String address , String phone , String sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.email = email;
        this.user_type = user_type;
        this.birthdate = birthdate;
        this.address = address;

        this.phone = phone;
        this.sex = sex;
    }

    public String getFirstName ( ) {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName ( ) {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getUsername ( ) {
        return username;
    }

    public void setUsername (String username) {
        this.username = username;
    }

    public String getPassword ( ) {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public String getEmail ( ) {
        return email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    public String getUser_type ( ) {
        return user_type;
    }

    public void setUser_type (String user_type) {
        this.user_type = user_type;
    }

    public String getBirthdate ( ) {
        return birthdate;
    }

    public void setBirthdate (String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAddress ( ) {
        return address;
    }

    public void setAddress (String address) {
        this.address = address;
    }



    public String getPhone ( ) {
        return phone;
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    public String getSex ( ) {
        return sex;
    }

    public void setSex (String sex) {
        this.sex = sex;
    }
}



package com.javatpoint.beans;

public class AccountantBean {

    private int id;
    private String firstname, lastname, email, password, address, role;

    public AccountantBean() {
        super();
        // TODO Auto-generated constructor stub
    }

    public AccountantBean(String firstname, String lastname, String email, String password, String address, String role) {
        super();
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.role = role;
    }

     public AccountantBean(int id, String firstname, String lastname, String email, String password, String address, String role) {
        super();
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AccountantBean{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", password=" + password + ", address=" + address + ", role=" + role + '}';
    }

}

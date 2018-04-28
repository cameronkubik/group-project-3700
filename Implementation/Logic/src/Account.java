//package com.cmk;
//Account Class

// Table of Contents
/*
variables
constructor
getter setter pairs
default constructor
identity
*/

public class Account {
    //member variables
    private String username;
    private String email;
    private String phoneNumber;
    private String ssn;
    private String fullName;
    private String password;

    /**
	* Default Account constructor
	*/
	public Account(String username, String password, String email, String phoneNumber, String ssn, String fullName) {
		super();
		this.username = username;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.ssn = ssn;
		this.fullName = fullName;
        this.password = password;
	}

	/**
	* Returns value of username
	* @return
	*/
	public String getUsername() {
		return username;
	}

	/**
	* Sets new value of username
	* @param
	*/
	public void setUsername(String username) {
		this.username = username;
	}

    /**
	* Returns value of password
	* @return
	*/
	public String getPassword() {
		return password;
	}

	/**
	* Sets new value of password
	* @param
	*/
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	* Returns value of email
	* @return
	*/
	public String getEmail() {
		return email;
	}

	/**
	* Sets new value of email
	* @param
	*/
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	* Returns value of phoneNumber
	* @return
	*/
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	* Sets new value of phoneNumber
	* @param
	*/
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	* Returns value of ssn
	* @return
	*/
	public String getSsn() {
		return ssn;
	}

	/**
	* Sets new value of ssn
	* @param
	*/
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/**
	* Returns value of fullName
	* @return
	*/
	public String getFullName() {
		return fullName;
	}

	/**
	* Sets new value of fullName
	* @param
	*/
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

    /**
	* TODO Returns user identity as an object
	*/
    public void getIdentity() {

    }
}

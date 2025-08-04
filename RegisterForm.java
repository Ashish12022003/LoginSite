package com.example;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.*;

public class RegisterForm extends ActionForm {
    private String username, password, email, role,  city, pincode, dob;
    private int age;

    public String getUsername() { 
    	return username; 
    }
    public void setUsername(String username) { 
    	this.username = username; 
    }

    public String getPassword() { 
    	return password; 
    }
    public void setPassword(String password) { 
    	this.password = password; 
    }

    public String getEmail() { 
    	return email; 
    }
    public void setEmail(String email) { 
    	this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public String getCity() { 
    	return city; 
    }
    public void setCity(String city) { 
    	this.city = city; 
    }
    public String getPincode() { 
    	return pincode; 
    }
    public void setPincode(String pincode) { 
    	this.pincode = pincode;
    }
    public String getDob() {
        return dob;
    }
    public void setDob(String dob) {
        this.dob = dob;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();

        
        if (username == null || username.trim().isEmpty()) {
            errors.add("username", new ActionMessage("error.username.required"));
        }

     
        if (password == null || password.trim().isEmpty()) {
            errors.add("password", new ActionMessage("error.password.required"));
        }

       
        if (email == null || !email.matches("^\\S+@\\S+\\.\\S+$")) {
            errors.add("email", new ActionMessage("error.email.invalid"));
        }

        
        if (role == null || role.trim().isEmpty()) {
            errors.add("role", new ActionMessage("error.role.required"));
        }

       
        if (city == null || city.trim().isEmpty()) {
            errors.add("city", new ActionMessage("error.city.required"));
        }

       
        if (pincode == null || !pincode.matches("\\d{6}")) {
            errors.add("pincode", new ActionMessage("error.pincode.invalid"));
        }

        //basic format check — yyyy-mm-dd)
        if (dob == null || !dob.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            errors.add("dob", new ActionMessage("error.dob.invalid"));
        }

        //(must be a number between 1 and 120)
        if (age <= 0 || age > 120) {
            errors.add("age", new ActionMessage("error.age.invalid"));
        }

        return errors;
    }

}

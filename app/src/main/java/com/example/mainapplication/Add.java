package com.example.mainapplication;

public class Add {
    private String name,contact,email;

    @Override
    public String toString() {
        return "Add{" +
               "name='" + name + '\'' +
               ", contact='" + contact + '\'' +
               ", email='" + email + '\'' +
               '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}



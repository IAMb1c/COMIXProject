package main;


public class User {
    private int id;
    public String name;
    private String password;
    public boolean isLoggedIn;

    public User() {
        this.id = 0;
        this.name = "";
        this.password = "";
        this.isLoggedIn = false;
    }

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.isLoggedIn = false;
    }

    public void setUser(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String getName(){
        return this.name;
    }

    public String getPassword(){
        return this.password;
    }

    public int getId(){
        return this.id;
    }

    public String getUser(){
        return this.id + "," + this.name + "," + this.password;
    }

    public void setLoggedIn(boolean isLoggedIn){
        this.isLoggedIn = isLoggedIn;
    }
}

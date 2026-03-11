package com.doom.first.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Credentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
    private String username ;
    private String passkey ;

    public Credentials() {}

    public Credentials(String username, String passkey) {
        this.username = username ;
        this.passkey  = passkey ;
    }

    public String getUsername() { return  username ; }
    public String getPasskey()  { return  passkey  ; }
    public Integer getId() { return  id ;}

    public void setUsername(String username) { this.username = username ; }
    public void setPasskey(String passkey)   { this.passkey  = passkey  ; }
}

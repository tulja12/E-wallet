package com.doom.first.repository;

import com.doom.first.model.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Credentials, Integer> {


    Credentials findByUsername(String username);

}
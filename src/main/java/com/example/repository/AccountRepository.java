package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

    boolean existsByUsername(String username);

    Account findByUsernameAndPassword(String username, String password);
}

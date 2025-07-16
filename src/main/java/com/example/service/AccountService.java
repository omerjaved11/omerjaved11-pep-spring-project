package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Account;
import com.example.repository.AccountRepository;

import javassist.bytecode.DuplicateMemberException;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public Account registerUser(Account account){
        


        if(null == account.getUsername() || account.getUsername().isEmpty() || account.getUsername().isBlank())
            throw new IllegalArgumentException(account.getUsername() + " Username cannot be empty or blank");
        
        if(null == account.getPassword() || account.getPassword().length() < 4)
            throw new IllegalArgumentException(account.getPassword() + " Password cannot be less than 4 character");
            
        if(accountRepository.existsByUsername(account.getUsername()))
            throw new IllegalArgumentException(account.getUsername() + " already exists");

        return accountRepository.save(account);
    }
}

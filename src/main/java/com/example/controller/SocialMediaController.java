package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.service.AccountService;
import com.example.service.MessageService;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {

    private AccountService accountService;
    private MessageService messageService;

    @Autowired
    public SocialMediaController(AccountService accountService, MessageService messageService){
        this.accountService = accountService;
        this.messageService = messageService;
    }

    @PostMapping("register")
    ResponseEntity<Account> registerUser(@RequestBody Account account){
        return ResponseEntity.ok().body(accountService.registerUser(account));
    }

    
    @PostMapping("login")
    ResponseEntity<Account> loginUser(@RequestBody Account account){
        return ResponseEntity.ok().body(accountService.login(account));
    }

    
    @PostMapping("messages")
    ResponseEntity<Message> newMessage(@RequestBody Message message){
        return ResponseEntity.ok().body(messageService.newMessage(message));
    }

     
    @GetMapping("messages")
    ResponseEntity<List<Message>> getAllMessages(){
        return ResponseEntity.ok().body(messageService.getAllMessages());
    }

      
    @GetMapping("messages/{messageId}")
    ResponseEntity<Message> getMessage(@PathVariable Integer messageId){
        return ResponseEntity.ok().body(messageService.getMessage(messageId));
    }

      
    @DeleteMapping("messages/{messageId}")
    ResponseEntity<Integer> deleteMessage(@PathVariable Integer messageId){
        return ResponseEntity.ok().body(messageService.deleteMessage(messageId));
    }
    
          
    @PatchMapping("messages/{messageId}")
    ResponseEntity<Integer> patchMessage(@PathVariable Integer messageId, @RequestBody Message message){
        return ResponseEntity.ok().body(messageService.patchMessage(messageId, message));
    }

    @GetMapping("accounts/{accountId}/messages")
    ResponseEntity<List<Message>> getMessagesByAccountId(@PathVariable Integer accountId){
        return ResponseEntity.ok().body(messageService.getAllMessageByAccount(accountId));
    }

}

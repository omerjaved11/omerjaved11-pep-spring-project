package com.example.controller;

import java.util.List;

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

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {

    @PostMapping("register")
    ResponseEntity<Account> registerUser(@RequestBody Account reqAccount){
        Account respAccount =  null;

        return ResponseEntity.ok().body(respAccount);
    }

    
    @PostMapping("login")
    ResponseEntity<Account> loginUser(@RequestBody Account reqAccount){
        Account respAccount =  null;

        return ResponseEntity.ok().body(respAccount);
    }

    
    @PostMapping("messages")
    ResponseEntity<Message> registerUser(@RequestBody Message message){
        Message respMessage =  null;

        return ResponseEntity.ok().body(respMessage);
    }

     
    @GetMapping("messages")
    ResponseEntity<List<Message>> getAllMessages(){
        List<Message> allMessages = null;

        return ResponseEntity.ok().body(allMessages);
    }

      
    @GetMapping("messages/{messageId}")
    ResponseEntity<Message> getMessage(@PathVariable long messageId){
        Message message = null;

        return ResponseEntity.ok().body(message);
    }

      
    @DeleteMapping("messages/{messageId}")
    ResponseEntity<Message> deleteMessage(@PathVariable long messageId){
        Message message = null;

        return ResponseEntity.ok().body(message);
    }
    
          
    @PatchMapping("messages/{messageId}")
    ResponseEntity<Message> patchMessage(@PathVariable long messageId){
        Message message = null;

        return ResponseEntity.ok().body(message);
    }

    @GetMapping("accounts/{accountId}/messages")
    ResponseEntity<Message> getMessagesByAccountId(@PathVariable long accountId){
        Message message = null;

        return ResponseEntity.ok().body(message);
    }

}

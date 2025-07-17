package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;

@Service
public class MessageService {
    private MessageRepository messageRepository;
    private AccountRepository accountRepository;
    
    @Autowired
    public MessageService(MessageRepository messageRepository, AccountRepository accountRepository){
        this.messageRepository = messageRepository;
        this.accountRepository = accountRepository;
    }

    public Message newMessage(Message message){

        if(!accountRepository.existsById(message.getPostedBy()))
            throw new IllegalArgumentException(message.getPostedBy() + " not a real username");

        if(null == message || message.getMessageText().isBlank() || message.getMessageText().isEmpty() || message.getMessageText().length() > 255)
            throw new IllegalArgumentException(message.getMessageText() + " message can not be empty or blank or more than 255 characters");
        
        return messageRepository.save(message);
    }
    
    public List<Message> getAllMessages(){
        return (List<Message>) messageRepository.findAll();
    }

    public Message getMessage(Integer messageId){
        return messageRepository.findById(messageId).isPresent()? messageRepository.findById(messageId).get(): null;
    }

    public Integer deleteMessage(Integer messageId){
        if(messageRepository.existsById(messageId)){
            messageRepository.deleteById(messageId);
            return 1;
        }
        else 
            return null;
    }

    public Integer patchMessage(Integer messageId, Message updatedMessage){
        if(!messageRepository.existsById(messageId))
            throw new IllegalArgumentException("Message not found");
        if(null == updatedMessage.getMessageText() || updatedMessage.getMessageText().isEmpty() || updatedMessage.getMessageText().isBlank() || updatedMessage.getMessageText().length() > 255)
            throw new IllegalArgumentException("Message text is blank or length is greater than 255 characters");
        return null != messageRepository.save(updatedMessage)? 1: null;
    }

    public List<Message> getAllMessageByAccount(Integer accountId){
        return messageRepository.findAllByPostedBy(accountId);
    }


}

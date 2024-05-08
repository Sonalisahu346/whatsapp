package com.whatsapp.task.controller;

import java.util.List;

import javax.management.ServiceNotFoundException;
import javax.management.relation.RelationTypeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whatsapp.task.entity.ChatEntity;
import com.whatsapp.task.entity.MessageEntity;
import com.whatsapp.task.entity.UserProfile;
import com.whatsapp.task.model.MessageDTO;
import com.whatsapp.task.repository.ChatEntityRepository;
import com.whatsapp.task.repository.MessageRepository;
import com.whatsapp.task.repository.UserProfileRepository;

@RestController
@RequestMapping("/api")
public class AllController {

	 @Autowired
	 private UserProfileRepository userProfileRepository;
	
	 @Autowired
	  private ChatEntityRepository chatEntityRepository;
	 
	 @Autowired
	  private MessageRepository messageRepository;
	 
	 @GetMapping("/{id}")
	    public UserProfile getUserProfile(@PathVariable int id) throws RelationTypeNotFoundException {
	        return userProfileRepository.findById(id)
	                .orElseThrow(() -> new RelationTypeNotFoundException());
	    }
	 
	 @GetMapping
	    public List<ChatEntity> getAllChatrooms() {
	        return chatEntityRepository.findAll();
	    }
	 
	 @PostMapping
	    public MessageEntity sendMessage(@RequestBody MessageDTO messageDTO) throws ServiceNotFoundException {
	        // Validate senderId and chatroomId
	        UserProfile sender = userProfileRepository.findById(messageDTO.getSenderId())
	                .orElseThrow(() -> new ServiceNotFoundException());
	        ChatEntity chatroom = chatEntityRepository.findById(messageDTO.getChatroomId())
	                .orElseThrow(() -> new ServiceNotFoundException());

	        // Create and save the message
	        MessageEntity message = new MessageEntity();
	        message.setSender(sender);
	        message.setChatentity(chatroom);
	        message.setContent(messageDTO.getContent());
	        return messageRepository.save(message);
	    }
	 

	 
}

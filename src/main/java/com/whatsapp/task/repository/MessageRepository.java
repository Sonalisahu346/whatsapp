package com.whatsapp.task.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whatsapp.task.entity.ChatEntity;
import com.whatsapp.task.entity.MessageEntity;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
    List<MessageEntity> findByChatroom(ChatEntity chatEntity);
}

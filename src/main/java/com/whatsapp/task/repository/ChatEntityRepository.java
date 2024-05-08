package com.whatsapp.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whatsapp.task.entity.ChatEntity;

public interface ChatEntityRepository extends JpaRepository<ChatEntity, Integer> {
}

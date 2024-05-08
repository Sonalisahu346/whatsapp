package com.whatsapp.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whatsapp.task.entity.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile, Integer> {
}

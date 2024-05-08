package com.whatsapp.task.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {
    private int senderId;
    private int chatroomId;
    private String content;

}
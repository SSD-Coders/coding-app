package com.example.init.models;

public class Chat {
    private String content;
    private String sender;
    private String type;

    public enum MessageType {
        CHAT, LEAVE, JOIN
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return this.sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

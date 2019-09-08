package com.steer.demo.dto;

public class Session {
    private long userId;

    public static Session build(long userId){
        Session session = new Session();
        session.setUserId(userId);
        return session;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}

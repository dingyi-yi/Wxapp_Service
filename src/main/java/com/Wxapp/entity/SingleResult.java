package com.Wxapp.entity;

import com.Wxapp.dao.userdao.UserAccount;

public class SingleResult<S> {
   int Code;
   S Token;
   S Message;
   UserAccount user;

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public S getToken() {
        return Token;
    }

    public void setToken(S token) {
        Token = token;
    }

    public S getMessage() {
        return Message;
    }

    public void setMessage(S message) {
        Message = message;
    }

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }
}

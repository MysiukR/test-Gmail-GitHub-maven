package com.epam.lab.filereader;

public class ModelGmailUsers {

    public String login;
    public String password;
    public String sendTo;
    public String subject;
    public String messageText;

    String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String toAddress) {
        this.sendTo = toAddress;
    }

    String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

}
package com.algorithms.demo.gof.bridge.abstraction;
import com.algorithms.demo.gof.bridge.implementation.MessageSender;

public class EmailMessage extends Message{
    public EmailMessage(MessageSender messageSender){
        super(messageSender);
    }
    @Override
    public void send(){
        messageSender.sendMessage();
    }

}

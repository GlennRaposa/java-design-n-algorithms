package com.algorithms.demo.gof.bridge.abstraction;

import com.algorithms.demo.gof.bridge.implementation.MessageSender;

public class TextMessage extends Message{

    public TextMessage(MessageSender messageSender){
        super(messageSender);
    }
    @Override
    public void send(){
      messageSender.sendMessage();
    }

}

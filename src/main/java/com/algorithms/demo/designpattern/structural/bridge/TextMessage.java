package com.algorithms.demo.designpattern.structural.bridge;

public class TextMessage extends Message{
	 
    public TextMessage(MessageSender messageSender){
        super(messageSender);
    }
    @Override
    public void send(){
      messageSender.sendMessage();
    }
 
}

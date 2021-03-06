package com.algorithms.demo.gof.strategy.context;


import com.algorithms.demo.gof.strategy.strategies.EncryptionStrategy;

public class Encryptor {
    private EncryptionStrategy strategy;
    private String plainText;
    public Encryptor(EncryptionStrategy strategy){
        this.strategy=strategy;
    }
    public void encrypt(){
        strategy.encryptData(plainText);
    }
    public String getPlainText() {
        return plainText;
    }

    public void setPlainText(String plainText) {
        this.plainText = plainText;
    }

}

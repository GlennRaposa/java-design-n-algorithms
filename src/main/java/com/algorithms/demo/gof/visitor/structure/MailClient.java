package com.algorithms.demo.gof.visitor.structure;

import com.algorithms.demo.gof.visitor.visitors.MailClientVisitor;

public interface MailClient {
    void sendMail(String[] mailInfo);
    void receiveMail(String[] mailInfo);
    boolean accept(MailClientVisitor visitor);
}

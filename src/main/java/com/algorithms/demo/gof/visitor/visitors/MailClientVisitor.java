package com.algorithms.demo.gof.visitor.visitors;


import com.algorithms.demo.gof.visitor.structure.OperaMailClient;
import com.algorithms.demo.gof.visitor.structure.SquirrelMailClient;
import com.algorithms.demo.gof.visitor.structure.ZimbraMailClient;

public interface MailClientVisitor {
    void visit(OperaMailClient mailClient);
    void visit(SquirrelMailClient mailClient);
    void visit(ZimbraMailClient mailClient);
}

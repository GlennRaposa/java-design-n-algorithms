package com.algorithms.demo.gof.mediator.mediator;


import com.algorithms.demo.gof.mediator.colleague.ArmedUnit;

public interface Commander {
   void registerArmedUnits(ArmedUnit soldierUnit, ArmedUnit tankUnit);
    void setAttackStatus(boolean attackStatus);
    boolean canAttack();
    void startAttack(ArmedUnit armedUnit);
    void ceaseAttack(ArmedUnit armedUnit);
}

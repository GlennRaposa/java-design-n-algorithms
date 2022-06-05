package com.algorithms.demo.gof.state.states;


import com.algorithms.demo.gof.state.context.CandyVendingMachine;

public class NoCandyState implements CandyVendingMachineState{

    CandyVendingMachine machine;
    public NoCandyState(CandyVendingMachine machine){
        this.machine=machine;
    }
    @Override
    public void insertCoin() {
     System.out.println("No candies available");
    }
    @Override
    public void pressButton() {
        System.out.println("No candies available");
    }
    @Override
    public void dispense() {
        System.out.println("No candies available");
    }
    @Override
    public String toString(){
        return "NoCandyState";
    }
}

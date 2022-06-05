package com.algorithms.demo.gof.iterator;

public interface PatternAggregate {
    void addPattern(DesignPattern designPattern);
    void removePattern(DesignPattern designPattern);
    PatternIterator getPatternIterator();
}

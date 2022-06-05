package com.algorithms.demo.designpattern.creational.prototype;

public interface PrototypeCapable extends Cloneable {
	public PrototypeCapable clone() throws CloneNotSupportedException;
}

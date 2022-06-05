package com.javadatastructure;
//http://stackoverflow.com/questions/25501563/queue-implementation-with-generics-in-java
import java.util.LinkedList;
import java.util.List;

public class ImmutableQueue<T> {

    private List<T> immuatableQ = null;

    public ImmutableQueue() {
        this.immuatableQ = new LinkedList<T>();
    }

    public ImmutableQueue(List<T> immutableQ) {
        this();
        if (immutableQ != null) {
            this.immuatableQ.addAll(immutableQ);
        }
    }

    public ImmutableQueue<T> enqueue(T newItem) {
        List<T> copyQ = new LinkedList<T>(this.immuatableQ);
        copyQ.add(newItem);

        return new ImmutableQueue<T>(copyQ);
    }

    public ImmutableQueue<T> dequeue() {
        List<T> copyQ = new LinkedList<T>(this.immuatableQ);
        copyQ.remove(0);

        return new ImmutableQueue<T>(copyQ);
    }

    public T peek() {
        return this.immuatableQ.get(0);
    }

    public int size() {
        return this.immuatableQ.size();
    }

    public boolean isEmpty() {
        return this.immuatableQ.size() == 0;
    }

}


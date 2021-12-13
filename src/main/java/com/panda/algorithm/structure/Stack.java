package com.panda.algorithm.structure;

/**
 * @author : Edward
 * @date : 2021/12/12 3:07 下午
 *
 * "栈"实现
 */
public class Stack<E> {

    private Object[] elements;

    private int elementCount;

    public Stack(int capacity) {
        elements = new Object[capacity];
    }

    /**
     * 入栈
     */
    public synchronized void push(E item) {
        //check容量
        if (elementCount >= elements.length) {
            throw new IndexOutOfBoundsException();
        }
        elements[elementCount++] = item;
    }


    /**
     * 出栈
     */
    public synchronized E pop() {
        if (elementCount == 0) {
            throw new IndexOutOfBoundsException();
        }
        E element = (E) elements[elementCount-1];
        elements[elementCount--] = null;
        return element;
    }
}

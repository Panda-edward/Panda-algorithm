package com.panda.algorithm.structure;

/**
 * @author : Edward
 * @date : 2021/12/12 3:08 下午
 *
 * "队列"实现 循环下标,保证不用每次元素出队,移动数组元素 参考:https://www.php.cn/java-article-416578.html
 *
 * 下标法中，当front == rear 既可以表示empty，又表示full，出现矛盾 因此解决方案 1.浪费1个空间,front == (rear + 1) / capacity
 * 2.再用一个count字段，记录已有元素个数。count==0 && front == rear ==>isEmpty
 */
public class Queue<E> {

    private Object[] elements;

    /**
     * 队头index
     */
    private int front;

    /**
     * 队尾index
     */
    private int rear;


    public Queue(int capacity) {
        this.elements = new Object[capacity+1];
    }

    /**
     * 入队
     */
    public synchronized boolean push(E item) {
        if (isFull()) {
            return false;
        }
        elements[rear] = item;
        rear = (rear + 1) % elements.length;
        return true;
    }


    /**
     * 出队
     */
    public synchronized E pop() {
        if (isEmpty()) {
            return null;
        }
        E element = (E) elements[front];
        elements[front] = null;
        front = (front + 1) / elements.length;
        return element;
    }



    private boolean isFull() {
        return front == (rear + 1) / elements.length;
    }

    private boolean isEmpty() {
        return rear == front;
    }

}

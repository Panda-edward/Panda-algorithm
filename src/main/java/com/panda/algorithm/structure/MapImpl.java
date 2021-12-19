package com.panda.algorithm.structure;

/**
 * @author : Edward
 * @date : 2021/12/16 12:03 上午
 */
public class MapImpl<K, V> implements Map<K, V> {

    private int size;

    private int capacity;

    private Node<K, V>[] table;


    public MapImpl() {
        this.capacity = 1;
        table = (Node<K, V>[]) new Node[capacity];
    }

    @Override
    public void put(K k, V v) {
        if (capacity == size) {
            resize();
        }
        int index = indexFor(k);
        if (table[index] == null) {
            table[index] = new Node<>(k, v);
            size++;
        } else {
            Node<K, V> p, pre = null;
            for (p = table[index]; p != null; pre = p, p = p.next) {
                if (p.k.equals(k) && p.k.hashCode() == k.hashCode()) {
                    p.v = v;
                    break;
                }
            }
            if (p == null) {
                pre.next = new Node<>(k, v);
                size++;
            }
        }
    }

    @Override
    public V get(K k) {
        int index = indexFor(k);
        for (Node<K, V> p = table[index]; p != null; p = p.next) {
            if (p.k.equals(k) && p.k.hashCode() == k.hashCode()) {
                return p.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    private void resize() {
        //每次扩容2倍,保证capacity始终2的幂
        int oldCap = capacity;
        Node<K, V>[] newTable = (Node<K, V>[]) new Node[capacity = oldCap << 1];
        for (int i = 0; i < oldCap; i++) {
            if (table[i] == null) {
                continue;
            }
            Node<K, V> p = table[i];
            if (p.next == null) {
                newTable[indexFor(p.k)] = p;
            } else {
                //链表节点会分成2部分，一部分index不变，一部分变成新index
                Node<K, V> loHead = null, loTail = null, hiHead = null, hiTail = null, next = null;
                do {
                    next = p.next;
                    if (indexFor(p.k) == 0) {
                        if (loTail == null) {
                            loHead = p;
                        } else {
                            loHead.next = p;
                        }
                        loTail = p;
                    } else {
                        if (hiTail == null) {
                            hiHead = p;
                        } else {
                            hiHead.next = p;
                        }
                        hiTail = p;
                    }
                } while ((p = next) != null);
                if (loTail != null) {
                    loTail.next = null;
                    newTable[i] = loHead;
                }
                if (hiTail != null) {
                    hiTail.next = null;
                    newTable[i + oldCap] = hiHead;
                }
            }
        }
        table = newTable;
    }


    private int hash(K k) {
        return k.hashCode() ^ (k.hashCode() >>> 16);
    }

    private int indexFor(K k) {
        //扰动函数,保证h分布更均匀
        return k == null ? 0 : hash(k) & (capacity - 1);
    }

    class Node<K, V> implements Map.Entity<K, V> {
        private K k;
        private V v;
        private Node<K, V> next;

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }
}

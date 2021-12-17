package com.panda.algorithm.structure;

/**
 * @author : Edward
 * @date : 2021/12/16 12:02 上午
 */
public interface Map<K, V> {

    void put(K k, V v);

    V get(K k);

    int size();

    interface Entity<K,V> {

        K getKey();

        V getValue();

    }
}

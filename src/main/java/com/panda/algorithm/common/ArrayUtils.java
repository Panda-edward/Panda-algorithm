package com.panda.algorithm.common;

/**
 * @Author: Edward
 * @Date: 2020/7/22 上午12:22
 * <p>
 * 数据处理工具类
 */
public class ArrayUtils {

    /**
     * 交换array中两个元素
     * @param array 操作数组
     * @param x 元素在数组中下标
     * @param y 元素在数组中下标
     */
    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

}

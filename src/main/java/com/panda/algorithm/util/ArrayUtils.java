package com.panda.algorithm.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: Edward
 * @Date: 2020/7/22 上午12:22
 * <p>
 * 数据处理工具类
 */
public class ArrayUtils {

    /**
     * 交换array中两个元素
     *
     * @param array 操作数组
     * @param x     元素在数组中下标
     * @param y     元素在数组中下标
     */
    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    /**
     * 打印数组元素
     */
    public static void printArr(int[] array) {
        if (array == null || array.length == 0) {
            System.out.println("[]");
            return;
        }
        List<Integer> collect = Arrays.stream(array).boxed().collect(Collectors.toList());
        System.out.println(collect);
    }

}

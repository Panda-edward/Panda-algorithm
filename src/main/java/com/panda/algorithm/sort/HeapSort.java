package com.panda.algorithm.sort;

import com.panda.algorithm.common.ArrayUtils;

/**
 * @Author: Edward
 * @Date: 2020/7/30 上午10:33
 * <p>
 * 堆排序实现
 */
public class HeapSort {

    /**
     * 堆排序
     */
    public static void heapSort(int[] array) {
        //构建最大堆(从最后的非叶子节点开始,构建整个数组)
        for (int i = (array.length - 1) / 2; i >= 0; i--) {
            buildMaxHeap(array, i, array.length);
        }
        //基于[0,j]再构建最大堆,再将堆顶元素和最后交换，然后[0,j-1]构建最大堆，以此实现排序
        for (int j = array.length - 1; j > 0; j--) {
            ArrayUtils.swap(array, 0, j);
            buildMaxHeap(array, 0, j);
        }
    }

    /**
     * 构建最大堆
     * */
    static void buildMaxHeap(int[] array, int parent, int len) {
        //定位parent的子节点
        int lc = parent * 2 + 1;
        int rc = lc + 1;
        //找出叶子节点中大的一个
        int max = lc;
        if (lc >= len) {
            return;
        }
        if (rc < len && array[rc] > array[lc]) {
            max = rc;
        }
        //max子节点与parent比较,如果大交换位置,然后以max为parent,构建最大堆,保证堆性质
        if (array[max] > array[parent]) {
            ArrayUtils.swap(array, max, parent);
            buildMaxHeap(array,max,len);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 8, 2, 5, 3, 9};
        heapSort(array);
        ArrayUtils.printArr(array);
    }
}

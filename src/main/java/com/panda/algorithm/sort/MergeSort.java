package com.panda.algorithm.sort;

import com.panda.algorithm.common.ArrayUtils;

/**
 * @Author: Edward
 * @Date: 2020/7/29 上午11:47
 * <p>
 * 归并排序实现
 */
public class MergeSort {

    /**
     *
     */
    public static void mergeSort(int[] array, int left, int right, int[] temp) {
        //终止条件
        if (left >= right) {
            return;
        }
        /* 数组拆分 */
        int mid = (left + right) / 2;
        mergeSort(array, left, mid, temp);
        mergeSort(array, mid+1, right, temp);
        merge(array, left, right, mid, temp);
    }

    /**
     * 合并两个数组
     */
    static void merge(int[] array, int left, int right, int mid, int[] temp) {
        int i = left, j = mid + 1, t = 0;
        /* 合并两个数组 */
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                temp[t++] = array[i++];
            } else {
                temp[t++] = array[j++];
            }
        }
        /* 如果数组有未比较元素，直接追加到后面（因为2个数组有序） */
        while (i <= mid) {
            temp[t++] = array[i++];
        }
        while (j <= right) {
            temp[t++] = array[j++];
        }
        /* 将temp元素放回原数组对应位置 */
        t = 0;
        while (left <= right) {
            array[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 8, 2, 5, 3, 9};
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
        ArrayUtils.printArr(array);
    }
}

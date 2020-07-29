package com.panda.algorithm.sort;

import com.panda.algorithm.common.ArrayUtils;

/**
 * @Author: Edward
 * @Date: 2020/7/28 上午11:09
 * <p>
 * 快速排序实现
 */
public class QuicklySort {

    public static void quickSort(int[] array, int left, int right) {
        //递归终止条件
        if (left >= right) {
            return;
        }
        int mid = partition(array, left, right);
        quickSort(array, left, mid - 1);
        quickSort(array, mid + 1, right);
    }

    public static int partition(int[] array, int left, int right) {
        //选取基准点
        int midVal = array[left];
        int i = left, j = right;
        //调整元素位置，保证左边的元素都<基准，右边元素都>基准
        while (i < j) {
            while (array[j] >= midVal && i < j) {
                j--;
            }
            while (array[i] <= midVal && i < j) {
                i++;
            }
            ArrayUtils.swap(array, i, j);
        }
        //将基准点位置，与分界点位置调换
        ArrayUtils.swap(array, left, j);
        return j;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 8, 2, 5, 3, 9};
        quickSort(array, 0, array.length - 1);
        ArrayUtils.printArr(array);
    }

}

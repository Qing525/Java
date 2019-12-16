package com.ljq;

import java.util.Arrays;

/**
 * @author : LJQ
 * @date : 2019/6/8 14:13
 */
public class HeapSort {
    public static void main(String[] args) {

        int[] arr = {4, 6, 8, 5, 9};
        adjustHeap(arr, 1, arr.length);

        System.out.println(Arrays.toString(arr));
        adjustHeap(arr, 0, arr.length);

        System.out.println(Arrays.toString(arr));
    }


    public static void heapSort() {


    }

    /**
     * 把数组变成大顶堆
     *
     * @param arr    数组
     * @param i      非叶子节点
     * @param length 比较的个数
     */
    public static void adjustHeap(int[] arr, int i, int length) {


        int temp = arr[i];
        for (int j = i * 2 + 1; j < length; j = i * 2 + 1) {

            //左节点<右节点

            if (arr[j] < arr[j + 1] && j + 1 < length) {
                j++;
            }

            //右节点》 父节点   交换
            if (arr[j] > temp) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
            arr[i] = temp;
        }


    }
}

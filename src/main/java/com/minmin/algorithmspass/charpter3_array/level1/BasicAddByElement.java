package com.minmin.algorithmspass.charpter3_array.level1;


import static com.minmin.algorithmspass.tools.ArrayTool.printList;

/**
 * @author liuqingchao
 * @说明 在有序数组中插入新元素
 * @email 505459350@qq.com
 */
public class BasicAddByElement {
    public static void main(String[] args) {
        //初始化数组
        int[] arr = initArray();
        int size = 4;//数组中已有元素的数量

        //测试中间位置插入元素
        //addByElementSequence(arr, size, 1);
        add(arr, size, 5);
        printList("通过元素顺序插入", arr, 5);

//        //在上面基础上继续测试,尾部位置插入元素
//        size = size + 1;
//        addByElementSequence(arr, size, 9);
//        printList("通过元素顺序，尾部插入", arr, 6);
//
//        //在上面基础上继续测试，首部位置插入元素
//        size = size + 1;
//        addByElementSequence(arr, size, 0);
//        printList("通过元素顺序，尾部插入", arr, 7);
    }

    public static int addByElementSequenceByMyself(int[] arr, int size, int element) {
        if(size >= arr.length) return -1;

        int index = size;
        for(int i = 0; i < size; i++) {
            if(arr[i] > element) {
                index = i;
                break;
            }
        }
        for(int j = size; j > index; j--) {
            arr[j] = arr[j - 1];
        }
        arr[index] = element;
        return index;
    }

    public static int add(int[] arr, int size, int element) {
        if(size >= arr.length) return -1;
        int index = 0;
        for(int j = size; j > 0; j--) {
            if(arr[j - 1] < element) {
                // 这里为什么是index = j，而不是j-1呢？
                // 因为如果arr[j - 1] < element, 则element应该放在arr[j - 1]的后面一位才对
                index = j;
                break;
            }else {
                // 那么这里为什么是对的呢？
                // 因为最后并没有执行这个分支里的语句，倒数第二步执行了，也就是说最终是把
                // j位置腾出来了
                // 一切都严丝合缝的感觉真是太爽了
                arr[j] = arr[j - 1];
            }
        }
        arr[index] = element;
        return index;
    }

    /**
     * @param arr
     * @param size    数组已经存储的元素数量
     * @param element 待插入的元素元素
     * @return
     */
    public static int addByElementSequence(int[] arr, int size, int element) {
        //size和arr.length都表示元素的数量，都是从1开始编号
        if (size >= arr.length)
            throw new IllegalArgumentException("Add failed. Array is full.");
        int index = size;
        //找到新元素的插入位置
        for (int i = 0; i < size; i++) {
            if (element < arr[i]) {
                index = i;
                break;
            }
        }
        //元素后移
        for (int j = size; j > index; j--) {
            arr[j] = arr[j - 1]; //index下标开始的元素后移一个位置
        }
        arr[index] = element;//插入数据
        return index;
    }



    /**
     * 初始化要使用的数组
     * @return
     */
    private static int[] initArray() {
        int[] arr = new int[20];
        arr[0] = 3;
        arr[1] = 4;
        arr[2] = 7;
        arr[3] = 8;
        return arr;
    }

}

package com.example.Quest;

public class Sort {

    public static int[] createArray(int length){
        if(length <= 0){
            throw new RuntimeException();
        }
        int arr[] = new int[length];
        for(int i=0;i<length;i++){
            arr[i] = (int)(Math.random()*100+1);
        }
        return arr;
    }

    // 插入排序
    public static void insertSort(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }
        int p;
        for(int i=0;i<arr.length;i++){
            p = i;
            for(int j=i;j<arr.length;j++){
                if(arr[p] > arr[j]){
                    p = j;
                }
            }
            if(p != i){
                int temp = arr[p];
                arr[p] = arr[i];
                arr[i] = temp;
            }
        }
    }

    //快速排序

    public static void main(String[] args) {
        createArray(1);
    }
}

package com.example.chatgpt.BigO.task02;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] mas = {5, 1, 3, 2, 9, 4, 8, 6, 7, 0};
        mergeSort(mas);
        System.out.println(Arrays.toString(mas));
    }

    public static void mergeSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }

        int[] temp = new int[a.length];
        mergeSort(a, temp, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int[] temp, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(a, temp, left, mid);
        mergeSort(a, temp, mid + 1, right);
        merge(a, temp, left, mid, right);
    }

    private static void merge(int[] a, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                temp[k] = a[i];
                i++;
            } else {
                temp[k] = a[j];
                j++;
            }
            k++;
        }
        while (j <= right) {
            temp[k] = a[j];
            j++;
            k++;
        }
        while (i <= mid) {
            temp[k] = a[i];
            k++;
            i++;
        }
        System.arraycopy(temp, left, a, left, right - left + 1);

    }


}

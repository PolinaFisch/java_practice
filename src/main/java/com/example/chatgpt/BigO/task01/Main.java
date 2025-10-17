package com.example.chatgpt.BigO.task01;

public class Main {
    public static void main(String[] args) {
        assert binarySearchRecursive(new int[]{1,2,3,4,5}, 4) == 3;

        assert binarySearchRecursive(new int[]{1,2,3,4,5}, 6) == -1;

        assert binarySearchRecursive(new int[]{}, 1) == -1;

        assert binarySearchRecursive(new int[]{7}, 7) == 0;
    }

    public static int linearSearch(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (key == a[i]) {
                return i;
            }
        }
        return -1;
    }

    // 111 -> 011
    // 1000 -> 0100
    // 1110 -> 0111

    public static int binarySearch(int[] a, int key) {
        //int index = Arrays.binarySearch(a, key);
        int left = 0; // left index
        int right = a.length - 1; //right index

        while (left <= right) {
            int mid = left + (right - left) / 2; //middle index
            int midVal = a[mid];

            if (key > midVal)
                left = mid + 1;
            else if (key < midVal)
                right = mid - 1;
            else
                return mid; // key found
        }
        return -1;
    }

    public static int binarySearchRecursive(int[] a, int key) {
        int left = 0;
        int right = a.length - 1;
        return binarySearchRecursive(a, left, right, key);
    }

    private static int binarySearchRecursive(int[] a, int left, int right, int key){
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (key < a[mid]) {
            return binarySearchRecursive(a, left, mid - 1, key);
        } else if (key > a[mid]) {
            return binarySearchRecursive(a, mid + 1, right, key);
        } else {
            return mid;
        }
    }

}

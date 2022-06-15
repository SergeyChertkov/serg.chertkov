package sort;

import java.util.Arrays;

public class Main {
    static int[] arr = new int[10];

    public static void main(String[] args) {
        filling();
        shakerSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void filling() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10 + 1);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void shakerSort(int arr[]) {
        int buff;
        int left = 0;
        int right = arr.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    buff = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buff;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    buff = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = buff;
                }
            }
            left++;
        } while (left < right);
    }
}

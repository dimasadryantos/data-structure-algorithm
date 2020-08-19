package com.main;

public class Main {

    public static void main(String[] args) {


        int[] intArray = {20, 35, 15, 7, 55, 1, 14};

        for (int lastUnsortedIndex = 0;lastUnsortedIndex < intArray.length; lastUnsortedIndex++) {

            for (int i = intArray.length -1; i > lastUnsortedIndex; i--) {

                if (intArray[i] > intArray[i - 1]) {
                    swap(intArray, i, i - 1);
                }
            }
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.print(" " + intArray[i]);
        }

    }


    private static void swap(int[] array, int i, int j) {

        if (i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    //OUTPUT SHOULD BE :  55 35 20 15 14 7 1

}

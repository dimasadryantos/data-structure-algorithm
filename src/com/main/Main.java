package com.main;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
    }


    /**
     * simple method for practice
     * move char to front and back
     * @param input
     * @return
     */
    public static String moveChar(String input) {
        char temp = input.charAt(input.length() - 1);
        return temp + input + temp;
    }

    public static void arrayListPractice() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Marry", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));

        employeeList.forEach(employee -> System.out.println(employee));
        System.out.println(employeeList.get(1));
        System.out.println(employeeList.isEmpty());

        employeeList.set(1, new Employee("John", "Adams", 4568));
        employeeList.forEach(employee -> System.out.println(employee));

        System.out.println(employeeList.size());

        employeeList.add(3, new Employee("John", "Doe", 4567));
        employeeList.forEach(employee -> System.out.println(employee));

        Employee[] employeeArray = employeeList.toArray(new Employee[employeeList.size()]);

        for (Employee employee : employeeArray) {
            System.out.println(employee);
        }

        System.out.println(employeeList.contains(new Employee("Marry", "Smith", 22)));
        System.out.println(employeeList.indexOf(new Employee("John", "Doe", 4567)));

        employeeList.remove(2);
        employeeList.forEach(employee -> System.out.println(employee));
    }


    public static void radixSort(int[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }


    /**
     * input : {"bcdef", "dbaqc", "abcde", "omadd", "bbbbb"}
     * radix= alphabet 26 width 5
     *
     * @param input
     * @param radix
     * @param width
     */
    public static void radixSortStr(String[] input, int radix, int width) {
        for (int i = width - 1; i >= 0; i--) {
            radixSingleSortStr(input, i, radix);
        }
    }


    public static void radixSingleSortStr(String[] input, int position, int radix) {
        int numItems = input.length;
        int[] countArray = new int[radix];

        for (String value : input) {
            countArray[getIndex(position, value)]++;
        }

        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        String[] temp = new String[numItems];

        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getIndex(position, input[tempIndex])]] = input[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }

    }

    /**
     * method to get index for count Arr
     * a=97 ASCII A=65
     *
     * @param position
     * @param value
     * @return
     */
    public static int getIndex(int position, String value) {
        return value.charAt(position) - 'a';
    }

    public static void radixSingleSort(int[] input, int position, int radix) {

        int numItems = input.length;
        int[] countArray = new int[radix];

        for (int value : input) {
            countArray[getDigit(value, position, radix)]++;
        }

        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];

        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(input[tempIndex], position, radix)]] = input[tempIndex];
        }

        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }

    }


    /**
     * Challange 2 change inertion to recursive
     *
     * @param input
     * @param numItems = input.length
     */
    public static void recursiveInsertionSort(int[] input, int numItems) {

        if (numItems < 2) {
            return;
        }

        recursiveInsertionSort(input, numItems - 1);

        int newElement = input[numItems - 1];

        int i;

        for (i = numItems - 1; i > 0 && input[i - 1] >= newElement; i--) {
            input[i] = input[i - 1];
        }

        input[i] = newElement;

        System.out.println("Result of call when numItems = " + numItems);
        for (i = 0; i < input.length; i++) {
            System.out.print(input[i]);
            System.out.print(", ");
        }
        System.out.println("");
        System.out.println("---------------------");
    }


    public static void rotateArray(int[] input) {
        int[] temp = {input[1], input[2], input[0]};
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i]);
        }
    }

    /**
     * using compareTo()=if value equal return 0,
     * if value less than 0 the left is less than the other
     * if value bigger than 0 the left is bigger than the other
     */
    public static void bubbleSortString() {
        String[] input = {"e", "b", "a", "d", "c"};
        String temp;

        for (int i = 0; i < input.length; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i].compareTo(input[j]) > 0) {
                    temp = input[j];
                    input[j] = input[i];
                    input[i] = temp;
                }
            }
        }

        for (int k = 0; k < input.length; k++) {
            System.out.print(" " + input[k]);
        }
    }


    public static int getDigit(int value, int position, int radix) {
        return (int) (value / Math.pow(radix, position) % radix);
    }


    public static void countingSort(int[] input, int min, int max) {
        int[] countingArr = new int[max - min + 1];

        for (int i = 0; i < input.length; i++) {
            countingArr[input[i] - min]++;
        }

        int j = 0;

        for (int i = min; i < max; i++) {
            while (countingArr[i - min] > 0) {
                input[j++] = i;
                countingArr[i - min]--;
            }
        }

    }


    public static void quickSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }
        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);
    }

    //{20, 35, -15, 7, 55, 1, -22}
    public static int partition(int[] input, int start, int end) {
        // This is using the first element as the pivot
        int pivot = input[start];
        int i = start;
        int j = end;

        while (i < j) {
            // NOTE: empty loop body
            while (i < j && input[--j] >= pivot) ;
            if (i < j) {
                input[i] = input[j];
            }

            // NOTE: empty loop body
            while (i < j && input[++i] <= pivot) ;
            if (i < j) {
                input[j] = input[i];
            }
        }
        input[j] = pivot;
        return j;

    }


    /**
     * Merge Sort Recursive
     * { 20, 35, -15, 7, 55, 1, -22 }
     *
     * @param input
     * @param start
     * @param end
     */
    public static void mergeSort(int[] input, int start, int end) {

        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(input, start, mid);
        mergeSort(input, mid, end);

        merge(input, start, mid, end);
    }

    /**
     * Merging from merge sort
     * { 20, 35, -15, 7, 55, 1, -22 }
     *
     * @param input
     * @param start
     * @param mid
     * @param end
     */
    public static void merge(int[] input, int start, int mid, int end) {

        if (input[mid - 1] <= input[mid]) {
            return;
        }

        int i = start;
        int k = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && k < end) {
            temp[tempIndex++] = input[i] <= input[k] ? input[i++] : input[k++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }


    /**
     * Basic arrayCopy()
     */
    public static void arrayCopy() {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {11, 12, 13, 14, 15};

        System.arraycopy(array2, 0, array1, 0, 1);

        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
    }


    /**
     * Recursive reduceByOne
     *
     * @param n
     * @return
     */
    public static int reduceByOne(int n) {
        if (n > 0) {
            reduceByOne(n - 1);
        }
        System.out.println("Completed call " + n);
        return n;
    }

    /**
     * Recursive sumTwoNum
     *
     * @param start
     * @param end
     * @return
     */
    public static int sumTwoNum(int start, int end) {
        if (end > start) {
            return end + sumTwoNum(start, end - 1);
        } else {
            return end;
        }
    }


    private static int recursiveSum(int number) {
        if (number > 0) {
            int result = number + recursiveSum(number - 1);
            return result;
        } else {
            return 0;
        }
    }


    private static int recursiveFactorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * recursiveFactorial(num - 1);
    }

    private static int iterativeFactorial(int num) {

        if (num == 0) {
            return 1;
        }

        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
            System.out.println(factorial);
        }

        return factorial;
    }


    /**
     * Shell sort is variation to optimise Insertion sort with reduce the shifting
     */
    private static void shellSort() {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        for (int gobs = intArray.length / 2; gobs > 0; gobs /= 2) {
            for (int i = gobs; i < intArray.length; i++) {

                int newElement = intArray[i];
                int j = i;
                while (j >= gobs && intArray[j - gobs] > newElement) {
                    intArray[j] = intArray[j - gobs];
                    j -= gobs;
                }
                intArray[j] = newElement;
            }
        }
        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }


    private static void insertionSortsAscending() {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {

            int newElement = intArray[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
            }
            intArray[i] = newElement;
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.print(" " + intArray[i]);
        }
    }

    private static void selectionShortAscending() {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        for (int lastSortedIdex = intArray.length - 1; lastSortedIdex > 0; lastSortedIdex--) {

            int largest = 0;
            for (int i = 1; i <= lastSortedIdex; i++) {
                if (intArray[i] > intArray[largest]) {
                    largest = i;
                }
            }
            swap(intArray, largest, lastSortedIdex);
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }


    public static int searchBiggerNum() {
        int[] input = {4, 2, 5, 3, 7, 9};
        int largest = 0;
        for (int i = input.length; i > 0; i--) {
            for (int j = 1; j < i; j++) {
                if (input[j] > input[largest]) {
                    largest = j;
                }
            }
        }
        return input[largest];
    }

    public static int searchSmalestNum() {
        int[] input = {8, 9, 6, 7, 1};
        int smalest = 0;
        for (int i = input.length - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (input[j] < input[smalest]) {
                    smalest = j;
                }
            }
        }
        return input[smalest];
    }


    /**
     * bubble sorting bigger to small
     */
    private static void bubbleSortDescending() {

        int[] intArray = {20, 35, 15, 7, 55, 1, 14};

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {

            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] < intArray[i + 1]) {
                    swap(intArray, i, i + 1);
                }
            }
        }

        for (int i = 0; i < intArray.length; i++) {
            System.out.print(" " + intArray[i]);
        }
    }


    /**
     * bubble sorting small to bigger
     */
    private static void bubbleSortAscending() {

        int[] arrayInt = {20, 35, -15, 7, 55, 1, -22};

        for (int unsortList = arrayInt.length - 1; unsortList > 0; unsortList--) {

            for (int i = 0; i < unsortList; i++) {
                if (arrayInt[i] > arrayInt[i + 1]) {
                    swap(arrayInt, i, i + 1);
                }
            }
        }

        for (int i = 0; i < arrayInt.length; i++) {
            System.out.print(" " + arrayInt[i]);
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


}

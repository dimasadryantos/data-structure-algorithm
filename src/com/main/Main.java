package com.main;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Tree tree = new Tree();

        tree.insert(25);
        tree.insert(20);
        tree.insert(15);
        tree.insert(27);
        tree.insert(30);
        tree.insert(29);
        tree.insert(26);
        tree.insert(22);
        tree.insert(32);

       /*tree.traverseInOrder();

        System.out.println();

        System.out.println(tree.get(22));
        System.out.println(tree.get(32));*/

        System.out.println(tree.min());
        System.out.println(tree.max());


    }


    private static int count8(int n) {
        if (n == 0) {
            return 0;
        }

        if (n % 10 == 8 && (n / 10) % 10 == 8) {
            return 2 + count8(n / 10);
        } else if (n % 10 == 8) {
            return 1 + count8(n / 10);
        } else {
            return count8(n / 10);
        }
    }


    private static int count7(int n) {
        if (n == 0) {
            return 0;
        }

        if (n % 10 == 7) {
            return 1 + count7(n / 10);
        } else {
            return count7(n / 10);
        }
    }


    private static int sumDigits(int num) {
        if (num < 10) {
            return num;
        }
        return num % 10 + sumDigits(num / 10);
    }

    public static int triangle1(int rows) {
        if (rows == 0) {
            return 0;
        }
        return rows + triangle1(rows - 1);
    }

    public static int result(int n) {
        if (n == 1) {
            return 2;
        } else {
            return 2 * result(n - 1);
        }

    }

    public static int triangle(int rows) {
        if (rows == 0) {
            return 0;
        }

        if (rows == 1) {
            return 1;
        }

        return 2 + triangle(rows - 1);
    }

    public static int bunnyEars2(int bunnies) {

        if (bunnies == 0) {
            return 0;
        }

        if (bunnies % 2 == 0) {
            return 3 + bunnyEars2(bunnies - 1);
        } else {
            return 2 + bunnyEars2(bunnies - 1);
        }

    }


    // 0,1,1,2,3,5,8,13,21
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }

        int intFib = fibonacci(n - 1);
        int intFib2 = fibonacci(n - 2);
        System.out.println("Fib = " + n);
        return intFib + intFib2;
    }

    // 0,1,1,2,3,5,8,13,21
    public static int iterativeFibonaci(int nthNumber) {

        int previouspreviousNumber;
        int previousNumber = 0;
        int currentNumber = 1;

        for (int i = 1; i < nthNumber; i++) {

            previouspreviousNumber = previousNumber;

            previousNumber = currentNumber;

            currentNumber = previouspreviousNumber + previousNumber;

        }
        return currentNumber;
    }


    /**
     * Simple Practice Sum Recursive
     * 2 return 4,4 return 8
     *
     * @param bunnies
     * @return
     */
    public static int bunnyEars(int bunnies) {
        if (bunnies == 0) {
            return 0;
        }
        return 2 + bunnyEars(bunnies - 1);
    }


    public static int recursiveBinarySearch(int[] input, int value) {
        return recursiveBinarySearch(input, 0, input.length, value);
    }

    public static int recursiveBinarySearch(int[] input, int start, int end, int value) {

        if (start >= end) {
            return -1;
        }
        int midPoint = (start + end) / 2;
        System.out.println("Midpoint = " + midPoint);

        if (input[midPoint] == value) {
            return midPoint;
        } else if (input[midPoint] < value) {
            return recursiveBinarySearch(input, midPoint + 1, end, value);
        } else {
            return recursiveBinarySearch(input, start, midPoint, value);
        }

    }


    /**
     * Binary Search Using Iterative
     *
     * @param input
     * @param value
     * @return
     */
    public static int iterativeBinarySearch(int[] input, int value) {

        int start = 0;
        int end = input.length;

        while (start < end) {
            int midPoint = (start + end) / 2;
            if (input[midPoint] == value) {
                return midPoint;
            } else if (input[midPoint] < value) {
                start = midPoint + 1;
            } else {
                end = midPoint;
            }
        }

        return -1;
    }

    /**
     * simple implementation linear Search
     *
     * @param input
     * @param value
     * @return
     */
    public static int linearSearch(int[] input, int value) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == value) {
                return i;
            }
        }

        //Main implementation
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};

        System.out.println(linearSearch(intArray, -15));
        System.out.println(linearSearch(intArray, 1));
        System.out.println(linearSearch(intArray, 8888));
        System.out.println(linearSearch(intArray, -22));

        return -1;
    }


    public static void hashMapChallange2() {
        LinkedList<Employee> employees = new LinkedList<>();
        Map<Integer, Employee> employeeMap = new HashMap<>();

        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));

        employees.forEach(e -> System.out.println(e));


        ListIterator<Employee> iterator = employees.listIterator();
        List<Employee> remove = new ArrayList<>();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employeeMap.containsKey(employee.getId())) {
                remove.add(employee);
            } else {
                employeeMap.put(employee.getId(), employee);
            }
        }

        for (Employee employee : remove) {
            employees.remove(employee);
        }

        System.out.println("=====================After Deleted==========================");

        employees.forEach(e -> System.out.println(e));
    }


    public static void hashChallange1() {
        int[] nums = new int[10];
        int[] numsToAdd = {59382, 43, 6894, 500, 99, -58};

        for (int i = 0; i < numsToAdd.length; i++) {
            nums[hashChallange(numsToAdd[i])] = numsToAdd[i];
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }


    public static int hashChallange(int values) {
        return Math.abs(values % 10);
    }

    public static void bucketSort(int[] intArray) {
        List<Integer>[] buckets = new List[10];

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < intArray.length; i++) {
            buckets[hash(intArray[i])].add(intArray[i]);
        }

        for (List bucket : buckets) {
            Collections.sort(bucket);
        }

        int j = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int value : buckets[i]) {
                intArray[j++] = value;
            }
        }


        //main method
        int[] intArray1 = {54, 46, 83, 66, 95, 92, 43};

        bucketSort(intArray1);

        for (int i = 0; i < intArray1.length; i++) {
            System.out.println(intArray1[i]);
        }

    }


    public static int hash(int input) {
        return input / 10;
    }


    /**
     * hashMap implementation
     */
    public static void mapJDK() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        Map<String, Employee> hashMap = new HashMap<String, Employee>();

        StringBuilder str = new StringBuilder();
        hashMap.put("Jones", janeJones);
        hashMap.put("Doe", johnDoe);
        String str1 = hashMap.get("Jones").toString();


        //Employee employee = hashMap.put("Doe", mikeWilson);

        hashMap.putIfAbsent("Doe", mikeWilson);

        System.out.println(hashMap.getOrDefault("annisa", marrySmith));

        System.out.println(hashMap.remove("Doe"));

        // System.out.println(employee);
        /*Iterator iterator = hashMap.values().iterator();


        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/

        /*System.out.println("Key= " + hashMap.containsKey("Jones"));
        System.out.println(hashMap.containsValue(janeJones));*/

        hashMap.forEach((k, v) -> System.out.println("Key = " + k + " , Employee = " + v));
    }


    public static void chaining() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        ChainHashTable ht = new ChainHashTable();

        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marrySmith);

        ht.printHashTable();

       /*  System.out.println("Retrieve key smith "+ht.get("Smith"));
         System.out.println("=====================================");

         ht.remove("Doe");
         ht.remove("Jones");
         ht.printHashTable();
        System.out.println("Retrieve key smith "+ht.get("Smith"));*/
    }


    /**
     * Implementation linear Probing
     */
    public static void linearProbing() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);


        SimpleHashTable ht = new SimpleHashTable();

        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marrySmith);

        ht.printHashTable();
        System.out.println("Retrieve key Smith" + ht.get("Smith"));

        ht.remove("Wilson");
        ht.remove("Jones");

        System.out.println("----------------------------");
        ht.printHashTable();
        System.out.println("Retrieve key Smith" + ht.get("Smith"));
        System.out.println("Retrieve key Smith" + ht.get("Doe"));
    }


    /**
     * Simple explanation of hashtable
     */
    public static void hashTable() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);


        SimpleHashTable ht = new SimpleHashTable();

        ht.put("Jones", janeJones);
        ht.put("Doe", johnDoe);
        ht.put("Wilson", mikeWilson);
        ht.put("Smith", marrySmith);

        ht.printHashTable();

        //System.out.println("Retrieve key Wilson" + ht.get("Wilson"));
    }

    /**
     * check String polindrom using stack and queue
     *
     * @param input
     * @return
     */
    public static boolean checkPolindromStackQueue(String input) {
        LinkedList<Character> stack = new LinkedList<Character>();
        LinkedList<Character> queue = new LinkedList<Character>();
        String lowerCase = input.toLowerCase();

        for (int i = 0; i < lowerCase.length(); i++) {
            char inputChar = lowerCase.charAt(i);
            if (inputChar >= 'a' && inputChar <= 'z') {
                queue.addLast(inputChar);
                stack.push(inputChar);
            }
        }

        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.removeFirst())) {
                return false;
            }
        }
        return true;
    }


    public static void arrayQueueCircular() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);


        ArrayQueueCircular queue = new ArrayQueueCircular(5);

        queue.add(janeJones);
        queue.add(johnDoe);
        queue.remove();
        queue.add(marrySmith);
        queue.remove();
        queue.add(mikeWilson);
        queue.remove();
        queue.add(billEnd);
        queue.remove();
        queue.add(janeJones);

        queue.printQueue();


        /*queue.add(janeJones);
        queue.add(johnDoe);
        queue.add(marrySmith);
        queue.add(mikeWilson);
        queue.add(billEnd);*/

       /* queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
*/

        //  System.out.println(queue.peek());
        queue.printQueue();


    }

    /**
     * this is Queues with array implementation
     */
    public static void arrayQueue() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        ArrayQueue queue = new ArrayQueue(10);

        queue.add(janeJones);
        queue.add(johnDoe);
        queue.add(marrySmith);
        queue.add(mikeWilson);
        queue.add(billEnd);

        //  queue.printQueue();

        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.add(mikeWilson);

        //  queue.printQueue();

        //  System.out.println(queue.peek());
        queue.printQueue();
    }

    /**
     * Check for palindrome string
     * (mengecek string apakah bisa di baca dari depan maupun dari belakang)
     * Logic :
     * hilangkan spasi,character,jadikan huruf kecil
     *
     * @param string
     * @return
     */
    public static boolean checkForPalindrome(String string) {

        LinkedList<Character> stack = new LinkedList<Character>();
        StringBuilder stringNoPuctuation = new StringBuilder(string.length());
        String lowerCase = string.toLowerCase();

        for (int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                stringNoPuctuation.append(c);
                stack.push(c);
            }
        }

        StringBuilder reversedString = new StringBuilder(stack.size());
        while (!stack.isEmpty()) {
            reversedString.append(stack.pop());
        }

        //thid should run in main method
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));

        return reversedString.toString().equals(stringNoPuctuation.toString());
    }

    public static void stackWithLinkedList() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        LinkedStack stack = new LinkedStack();
        stack.push(janeJones);
        stack.push(johnDoe);
        stack.push(marrySmith);
        stack.push(mikeWilson);
        stack.push(billEnd);

        System.out.println("POOP " + stack.pop());
        System.out.println(stack.peek());
        //stack.printStack();
    }


    public static void stackWithArray() {
        ArrayStack stack = new ArrayStack(10);

        stack.push(new Employee("Jane", "Jones", 123));
        stack.push(new Employee("John", "Doe", 4567));
        stack.push(new Employee("Marry", "Smith", 22));
        stack.push(new Employee("Mike", "Wilson", 3245));
        stack.push(new Employee("Bill", "End", 48));

        // stack.printStack();

        System.out.println(stack.peek());

        System.out.println("POOP " + stack.pop());

        System.out.println(stack.peek());
    }


    public static int[] makeLast(int[] input) {
        int lengthInput = input.length;
        int[] intArray = new int[2 * lengthInput];
        intArray[intArray.length - 1] = input[lengthInput - 1];
        return intArray;
    }


    /**
     * Sorting integer values using singly LinkedList
     */
    public static void sortIntegerValues() {
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;

        IntegerLinkedList list = new IntegerLinkedList();
        list.insertSorted(three);
        list.printList();
        list.insertSorted(two);
        list.printList();
        list.insertSorted(one);
        list.printList();
        list.insertSorted(four);
        list.printList();
    }


    public static void addBefore() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        EmployeeLinkedList list = new EmployeeLinkedList();

        list.addFront(janeJones);
        list.addFront(johnDoe);
        list.addFront(marrySmith);
        list.addFront(mikeWilson);

        list.addBefore(billEnd, mikeWilson);
        list.printList();
    }

    public static void LinkedListJDK() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
        Employee billEnd = new Employee("Bill", "End", 78);

        LinkedList<Employee> list = new LinkedList<>();

        list.addFirst(janeJones);
        list.addFirst(johnDoe);
        list.addFirst(marrySmith);
        list.addFirst(mikeWilson);

        Iterator iterator = list.iterator();

        System.out.print("HEAD -> ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(" <=> ");
        }
        System.out.println(" NULL");

       /* for (Employee employee : list) {
            System.out.println(employee);
        }*/

        list.add(billEnd);
        iterator = list.iterator();
        System.out.print("HEAD -> ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(" <=> ");
        }
        System.out.println(" NULL");


        list.add(billEnd);
        list.removeFirst();
        iterator = list.iterator();
        System.out.print("HEAD -> ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(" <=> ");
        }
        System.out.println(" NULL");


        list.removeLast();
        iterator = list.iterator();
        System.out.print("HEAD -> ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
            System.out.print(" <=> ");
        }
        System.out.println(" NULL");
    }


    public static void doublyLinkedList() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        EmployeeLinkedList list = new EmployeeLinkedList();

        list.addFront(janeJones);
        list.addFront(johnDoe);
        list.addFront(marrySmith);
        list.addFront(mikeWilson);

        list.printList();
        System.out.print(list.getSize());

        Employee billEnd = new Employee("Bill", "End", 78);
        list.addToEnd(billEnd);

        list.printList();
        System.out.println(list.getSize());

        list.removeFromFront();
        list.printList();
        System.out.println(list.getSize());


        list.removeFromEnd();
        list.printList();
        System.out.println(list.getSize());
    }


    public static void singlyLinkedList() {
        Employee janeJones = new Employee("Jane", "Jones", 123);
        Employee johnDoe = new Employee("John", "Doe", 4567);
        Employee marrySmith = new Employee("Marry", "Smith", 22);
        Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

        EmployeeLinkedList list = new EmployeeLinkedList();

        System.out.println(list.isEmpty());

        list.addFront(janeJones);
        list.addFront(johnDoe);
        list.addFront(marrySmith);
        list.addFront(mikeWilson);
        System.out.print(list.getSize());


        list.printList();

        list.removeFromFront();
        System.out.println(list.getSize());
        list.printList();
    }


    /**
     * simple method for practice
     * move char to front and back
     *
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
